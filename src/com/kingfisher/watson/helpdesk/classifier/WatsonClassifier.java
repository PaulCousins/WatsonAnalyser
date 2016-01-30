package com.kingfisher.watson.helpdesk.classifier;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;

public class WatsonClassifier {
	private static final String CLASSIFIER_ID="";
	
	public void classify(String keywords){
		NaturalLanguageClassifier nlc = new NaturalLanguageClassifier();
		nlc.setUsernameAndPassword("ross_stanton@hotmail.com", "volcane5");
		
		nlc.classify(CLASSIFIER_ID,"keywords");
	}
}
