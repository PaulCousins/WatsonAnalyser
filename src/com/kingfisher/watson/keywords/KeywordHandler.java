package com.kingfisher.watson.keywords;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.kingfisher.helpdesk.base.Keyword;
import com.kingfisher.utils.APIBase;

public class KeywordHandler extends APIBase{
	private static final String PATH = "calls/text/TextGetRankedKeywords";
	
	public Keyword[] getKeywords(String text, int numKeywords) throws Exception {
		
		Client watsonClient = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

		WebTarget alchemy = watsonClient.target(WATSON_URL);
		WebTarget textExtraction = alchemy.path(PATH).queryParam("apikey",APIKEY).
				queryParam("text", text).queryParam("maxRetrieve",""+numKeywords).
				queryParam("sentiment", 0).queryParam("outputMode","json").
				queryParam("keywordExtractMode","strict");
		
		Invocation.Builder textInv = textExtraction.request();
		
		//System.out.println(textInv.get().readEntity(String.class));
		KeywordResponse response = textInv.get().readEntity(KeywordResponse.class);
		
		if(response.getStatus().equals(ERROR)){
			System.err.println(response.getStatusInfo());
			return null;
		}
		else{
			return response.getKeywords();
		}
	}
}
