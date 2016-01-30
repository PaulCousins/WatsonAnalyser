package com.kingfisher.watson.taxonomy;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.kingfisher.helpdesk.base.Taxonomy;
import com.kingfisher.utils.APIBase;
import com.kingfisher.watson.keywords.KeywordResponse;

public class TaxonomyHandler extends APIBase{
	private static final String PATH = "calls/text/TextGetRankedTaxonomy";
	
	public Taxonomy[] getTaxonomy(String text) throws Exception{
		Client watsonClient = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

		WebTarget alchemy = watsonClient.target(WATSON_URL);
		WebTarget textExtraction = alchemy.path(PATH).queryParam("apikey",APIKEY).
				queryParam("text", text).queryParam("outputMode","json");
		
		Invocation.Builder textInv = textExtraction.request();
		TaxonomyResponse response = textInv.get().readEntity(TaxonomyResponse.class);
		
		if(response.getStatus().equals(ERROR)){
			System.err.println(response.getStatusInfo());
			return null;
		}
		else{
			return response.getTaxonomies();
		}
	}
}
