package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.engine.ObjectDeleteHandler;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriberLifoImpl;

/**
 * deletes existing objects in the correct order. a separate action becuase of
 * how the basic workflow works.
 * 
 * @author Reid Carlberg rcarlberg@modelmetrics.com
 * @since 2009-05-25
 * 
 */
public class AdvancedImportDeleteExistingAction extends
		AbstractUploadContextAware {

	public String execute() throws Exception {

		if (!this.getUploadContext().isOkToDelete()) {
			return ERROR;
		}
		
		if (this.getSalesforceSessionContext().getSalesforceSession() == null) {
			this.getUploadContext().setLastException(new RuntimeException("Missing Salesforce Session.  (This is sometimes an issue with Internet Explorer.)"));
			return ERROR;
		}

		
		// giddyup
		try {
			
			this.getUploadContext().setStatusSubscriber(new MigrationStatusSubscriberLifoImpl());
			
			new ObjectDeleteHandler().execute(this
					.getSalesforceSessionContext().getSalesforceSession(), this
					.getUploadContext().getCloudConverterObjects(),
					this.getUploadContext().getStatusSubscriber());
		} catch (Exception e) {
			this.getUploadContext().setLastException(e);
			return ERROR;
		}
		// done
		return SUCCESS;
	}
}
