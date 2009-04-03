package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.mmimport.actions.DbUploadAction;
import com.modelmetrics.common.sforce.SalesforceSession;


public interface SalesforceService {

	public void setSalesforceSession(SalesforceSession salesforceSession);
	
	void execute(WrapperBean bean)
			throws Exception;

	boolean checkObject(WrapperBean bean)
			throws Exception;
	
	void generateObjectFromDB(DbUploadAction action, String path)
	throws Exception;

}
