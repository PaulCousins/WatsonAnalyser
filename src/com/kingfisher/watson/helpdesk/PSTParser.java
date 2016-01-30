package com.kingfisher.watson.helpdesk;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.kingfisher.helpdesk.base.Email;
import com.kingfisher.helpdesk.base.Keyword;
import com.kingfisher.helpdesk.base.Sentiment;
import com.kingfisher.helpdesk.base.Taxonomy;
import com.kingfisher.utils.BaseUtils;
import com.kingfisher.watson.elasticindex.ElasticHandler;
import com.kingfisher.watson.keywords.KeywordHandler;
import com.kingfisher.watson.keywords.KeywordResponse;
import com.kingfisher.watson.sentiment.SentimentHandler;
import com.kingfisher.watson.taxonomy.TaxonomyHandler;
import com.pff.PSTFile;
import com.pff.PSTFolder;
import com.pff.PSTMessage;


public class PSTParser extends BaseUtils{
	private KeywordHandler kwHandler;
	private ElasticHandler searchHandler;
	
	public static void main(String[] args) {
		new PSTParser().parse(args[0]);
	}
	
	public PSTParser(){
		 kwHandler = new KeywordHandler();
		 searchHandler = new ElasticHandler();
	}
	
	
	private void parse(String file){
		try{
			PSTFile pstFile = new PSTFile(file);
			processFolder(pstFile.getRootFolder());
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private void processFolder(PSTFolder folder) throws Exception{
	
		//Recurse into subfolders
		if(folder.hasSubfolders()){
			Vector<PSTFolder> childFolders = folder.getSubFolders();
			
			for(PSTFolder child: childFolders){
				processFolder(child);
			}
		}
		
		int count = 0;
		
		//Process Emails in 'this' folder
		if(folder.getContentCount()>0){

			while(true){ //loop until the loop is broken
				PSTMessage email = (PSTMessage)folder.getNextChild();
				if(email!=null){
					handleEmail(email);
					count++;
					
					if(count==25) //just for testing, to be removed
						break;
				}
				else //no more messages to process, break
					break;
			}		
		}
	}
	
	// Get the body, use the Alchemy API to extract the keyword
	private void handleEmail(PSTMessage email) throws Exception{
		Email outEmail = new Email();
		outEmail.setBody(email.getBody());
		outEmail.setSubject(email.getSubject());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		outEmail.setSentDateTime(dateFormat.format(email.getCreationTime()));
		outEmail.setPriority(email.getPriority());

		String body = email.getBody();
		String subject = email.getSubject();

		Taxonomy[] taxs = new TaxonomyHandler().getTaxonomy(body);
		outEmail.setTaxonomy(taxs);

		Keyword[] subjectKWs = kwHandler.getKeywords(subject,2);
		outEmail.setSubjectKeywords(subjectKWs);
		Keyword[] keywords = kwHandler.getKeywords(body,5);
		outEmail.setKeywords(keywords);
		
		Sentiment[] sentiments = new SentimentHandler().handle(body);
		outEmail.setSentiment(sentiments);
		
		//This is rubbish... needs rework
		searchHandler.handle(outEmail);
		
	}
}
