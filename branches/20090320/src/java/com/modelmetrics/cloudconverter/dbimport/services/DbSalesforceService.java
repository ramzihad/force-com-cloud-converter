package com.modelmetrics.cloudconverter.dbimport.services;

import com.modelmetrics.common.sforce.SalesforceSession;

public interface DbSalesforceService {
	void generateObjectFromDB(DbUploadAction action)
			throws Exception;

	void setSalesforceSession(SalesforceSession salesforceSession);

}
