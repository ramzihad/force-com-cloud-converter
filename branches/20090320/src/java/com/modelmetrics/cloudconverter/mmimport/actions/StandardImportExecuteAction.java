package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceServiceFactory;

public class StandardImportExecuteAction extends AbstractUploadContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1198350407323092698L;

	public String execute() throws Exception {
		
		SalesforceService salesforceService = new SalesforceServiceFactory().buildCloudConverterObject();
		
		salesforceService.execute(this.getUploadContext());
		
		return SUCCESS;
	}
}
