package com.kingfisher.watson.elasticindex;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingfisher.helpdesk.base.Email;
import com.kingfisher.utils.Handler;

public class ElasticHandler {
	ObjectMapper mapper = new ObjectMapper();
	Client client = new TransportClient().addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
	
	public void handle(Email email) throws Exception{
	
		byte[] json = mapper.writeValueAsBytes(email);
		
		IndexResponse response = client.prepareIndex("email","analysedemail").setSource(json).execute().actionGet();
		
		System.out.println("Indexed: "+response.getId());
	}
}
	
