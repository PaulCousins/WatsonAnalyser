package com.kingfisher.watson.sentiment;

import java.util.Vector;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.kingfisher.helpdesk.base.Sentiment;
import com.kingfisher.utils.APIBase;
import com.kingfisher.utils.Handler;
import com.kingfisher.watson.keywords.KeywordResponse;

public class SentimentHandler extends APIBase implements Handler<Sentiment> {
	private static final String PATH = "calls/text/TextGetTextSentiment";
	
	@Override
	public Sentiment[] handle(String text) {
		Client watsonClient = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

		WebTarget alchemy = watsonClient.target(WATSON_URL);
		WebTarget textExtraction = alchemy.path(PATH).queryParam("apikey",APIKEY).
				queryParam("text", text).queryParam("outputMode","json").
				queryParam("showSourceText","1");
		
		Invocation.Builder textInv = textExtraction.request();
		
		//System.out.println(textInv.get().readEntity(String.class));
		SentimentResponse response = textInv.get().readEntity(SentimentResponse.class);
		
		if(response.getStatus().equals(ERROR)){
			System.err.println(response.getStatusInfo());
			return null;
		}
		else{
			Sentiment[] s = { response.getDocSentiment() };
			return s;
		}
	}

}
