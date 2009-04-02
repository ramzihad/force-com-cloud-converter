package com.modelmetrics.cloudconverter.mmimport.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractUploadContextAware extends ActionSupport {

	private static final Log log = LogFactory.getLog(AbstractUploadContextAware.class);
	
	private UploadContext uploadContext;
	
	private SalesforceSessionContext salesforceSessionContext;


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
