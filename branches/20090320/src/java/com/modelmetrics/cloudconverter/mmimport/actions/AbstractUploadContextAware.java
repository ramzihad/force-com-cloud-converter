package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractUploadContextAware extends ActionSupport {

	private UploadContext uploadContext;
	
	public static final Long NO = Long.valueOf(0);

	
	private SalesforceSessionContext salesforceSessionContext;

	protected String message;

	public UploadContext getUploadContext() {
		return uploadContext;
	}

	public void setUploadContext(UploadContext uploadContext) {
		this.uploadContext = uploadContext;
	}

	public SalesforceSessionContext getSalesforceSessionContext() {
		return salesforceSessionContext;
	}

	public void setSalesforceSessionContext(
			SalesforceSessionContext salesforceSessionContext) {
		this.salesforceSessionContext = salesforceSessionContext;
	}
	

	
}
