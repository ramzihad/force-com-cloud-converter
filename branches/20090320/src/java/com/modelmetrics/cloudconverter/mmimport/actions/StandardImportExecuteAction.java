package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceServiceFactory;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriberLifoImpl;

public class StandardImportExecuteAction extends AbstractUploadContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1198350407323092698L;

	public String execute() throws Exception {

		//subscribe to the updates
		this.getUploadContext().setStatusSubscriber(
				new MigrationStatusSubscriberLifoImpl());

		//instantiate the salesforce service
		SalesforceService salesforceService = new SalesforceServiceFactory()
				.build(this.getSalesforceSessionContext()
						.getSalesforceSession());

		//giddyup
		try {
			salesforceService.execute(this.getUploadContext());
		} catch (Exception e) {
			this.getUploadContext().setLastException(e);
			return ERROR;
		}

		//done
		return SUCCESS;
	}
}
