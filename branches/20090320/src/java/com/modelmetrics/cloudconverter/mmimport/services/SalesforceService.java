package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.actions.UploadContext;
import com.modelmetrics.common.sforce.SalesforceSession;

public interface SalesforceService {

	public void setSalesforceSession(SalesforceSession salesforceSession);

	public void execute(UploadContext uploadContext) throws Exception;

	public void executeMultiple(UploadContext uploadContext) throws Exception;

	
	List<String> checkObject(UploadContext uploadContext) throws Exception;

	List<ValueId>  getAllSalesforcObjects()
			throws Exception;

	public List<ValueId> getFieldsForObject(String object)throws Exception;

}
