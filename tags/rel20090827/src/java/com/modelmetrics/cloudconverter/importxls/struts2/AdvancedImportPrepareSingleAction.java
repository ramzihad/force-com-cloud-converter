package com.modelmetrics.cloudconverter.importxls.struts2;

import com.modelmetrics.cloudconverter.forceutil.ObjectToIdMapBuilder;
import com.opensymphony.xwork2.Action;

public class AdvancedImportPrepareSingleAction extends AbstractUploadContextAware {

	public String execute() throws Exception {
		
		ObjectToIdMapBuilder builder = new ObjectToIdMapBuilder();
		
		builder.build(this.getSalesforceSessionContext().getSalesforceSession());
		
		this.getUploadContext().setObjectToIdMap(builder.getObjectToIdMap());
		
		this.getUploadContext().setObjectToFieldMap(builder.getObjectToFieldMap());
		
		//HACK
		this.getUploadContext().setStatusSubscriber(null);
		
		return Action.SUCCESS;
		
	}
}
