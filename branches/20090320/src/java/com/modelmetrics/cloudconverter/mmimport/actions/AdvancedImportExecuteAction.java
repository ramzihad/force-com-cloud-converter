package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceServiceFactory;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriberLifoImpl;

/**
 * proceeds only with the current cloud converter object.
 * 
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * @since 2009-05-24
 * 
 */
public class AdvancedImportExecuteAction extends AbstractUploadContextAware {

	private static final long serialVersionUID = -1198350407323092698L;

	public String execute() throws Exception {

		if (this.getSalesforceSessionContext().getSalesforceSession() == null) {
			this.getUploadContext().setLastException(new RuntimeException("Missing Salesforce Session.  (This is sometimes an issue with Internet Explorer.)"));
			return ERROR;
		}
		// subscribe to the updates
		this.getUploadContext().setStatusSubscriber(
				new MigrationStatusSubscriberLifoImpl());

		// instantiate the salesforce service
		SalesforceService salesforceService = new SalesforceServiceFactory()
				.build(this.getSalesforceSessionContext()
						.getSalesforceSession());

		// giddyup
		try {
			salesforceService.execute(this.getUploadContext()
					.getCurrentCloudConverterObject(), this.getUploadContext()
					.getStatusSubscriber());
		} catch (Exception e) {
			this.getUploadContext().setLastException(e);
			return ERROR;
		}
		// done
		return SUCCESS;
	}
}
