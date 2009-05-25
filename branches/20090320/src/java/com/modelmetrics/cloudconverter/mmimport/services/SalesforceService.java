package com.modelmetrics.cloudconverter.mmimport.services;

import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;
import com.modelmetrics.common.sforce.SalesforceSession;

public interface SalesforceService {

	public void setSalesforceSession(SalesforceSession salesforceSession);
	
	public void execute(UploadContext uploadContext) throws Exception;
	
	public void execute(CloudConverterObject current, MigrationStatusSubscriber migrationStatusSubscriber) throws Exception;

	public boolean containsObject(String objectName) throws Exception;
	
}
