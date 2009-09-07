package com.modelmetrics.cloudconverter.importxls.struts2;

import com.modelmetrics.cloudconverter.forceutil.ObjectToIdMapBuilder;
import com.modelmetrics.cloudconverter.util.OperationStatusPublisherSupport;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriber;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriberLifoImpl;
import com.opensymphony.xwork2.Action;

public class AdvancedImportPrepareSingleAction extends
		AbstractUploadContextAware {

	public String execute() throws Exception {

		this.getUploadContext().setStatusSubscriber(
				new OperationStatusSubscriberLifoImpl());

		ObjectToIdMapBuilder builder = new ObjectToIdMapBuilder();
		
		builder.setOperationStatusPublisherSupport(new OperationStatusPublisherSupport());

		builder.getOperationStatusPublisherSupport().subscribeToStatus(
				this.getUploadContext().getStatusSubscriber());

		builder
				.build(this.getSalesforceSessionContext()
						.getSalesforceSession());

		this.getUploadContext().setObjectToIdMap(builder.getObjectToIdMap());

		this.getUploadContext().setObjectToFieldMap(
				builder.getObjectToFieldMap());

		// HACK
		this.getUploadContext().setStatusSubscriber(null);

		return Action.SUCCESS;

	}
}
