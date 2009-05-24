package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;

public class SalesforceServiceFactory {



	
	public SalesforceService buildCloudConverterObject() {
		SalesforceServiceCloudConverterCollectionImpl ret = new SalesforceServiceCloudConverterCollectionImpl();
		
		return ret;
		
	}
}
