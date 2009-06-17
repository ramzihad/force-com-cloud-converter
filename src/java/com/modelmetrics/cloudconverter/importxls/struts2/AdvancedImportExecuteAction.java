package com.modelmetrics.cloudconverter.importxls.struts2;

import com.modelmetrics.cloudconverter.importxls.services.SalesforceService;
import com.modelmetrics.cloudconverter.importxls.services.SalesforceServiceFactory;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriberLifoImpl;

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
				new OperationStatusSubscriberLifoImpl());

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
			if (e instanceof IndexOutOfBoundsException) {
				this.getUploadContext().setMessage("This message is usually caused by an Excel document that is not properly formatted.");
			}
			return ERROR;
		}
		// done
		return SUCCESS;
	}
}
