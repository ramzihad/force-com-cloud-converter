package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.common.sforce.SalesforceSession;


public interface SalesforceService {

	public void setSalesforceSession(SalesforceSession salesforceSession);
	
	public void execute(UploadContext uploadContext)
			throws Exception;

	boolean checkObject(UploadContext uploadContext)
			throws Exception;
	
	

}
