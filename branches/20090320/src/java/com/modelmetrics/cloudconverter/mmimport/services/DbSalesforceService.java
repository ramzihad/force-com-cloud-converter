package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.mmimport.actions.DbUploadAction;
import com.modelmetrics.common.sforce.SalesforceSession;

public interface DbSalesforceService {
	void generateObjectFromDB(DbUploadAction action, String path)
			throws Exception;

	void setSalesforceSession(SalesforceSession salesforceSession);

}
