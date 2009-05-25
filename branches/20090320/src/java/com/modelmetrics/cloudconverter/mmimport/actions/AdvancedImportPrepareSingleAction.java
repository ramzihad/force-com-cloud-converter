package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.List;
import java.util.Map;

import com.modelmetrics.cloudconverter.forceutil.ObjectToIdMapBuilder;
import com.opensymphony.xwork2.Action;

public class AdvancedImportPrepareSingleAction extends AbstractUploadContextAware {

	public String execute() throws Exception {
		
		Map<String, List<String>> objectToIdMap = new ObjectToIdMapBuilder().getMap(this.getSalesforceSessionContext().getSalesforceSession());
		
		this.getUploadContext().setObjectToIdMap(objectToIdMap);
		
		return Action.SUCCESS;
		
	}
}
