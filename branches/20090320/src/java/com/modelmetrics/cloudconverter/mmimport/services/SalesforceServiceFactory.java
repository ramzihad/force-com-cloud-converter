package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.common.sforce.SalesforceSession;

public class SalesforceServiceFactory {



	
	public SalesforceService build(SalesforceSession salesforceSession) {
		SalesforceServiceImpl ret = new SalesforceServiceImpl();
		ret.setSalesforceSession(salesforceSession);
		return ret;
		
	}
}
