package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;

public class UploadContext {

	private Exception lastException;
	
	private String salesforceUsername;
	
	private String salesforcePassword;
	
	private WrapperBean wrapperBean;

	private SalesforceSession salesforceSession;
	
	public void setSalesforceCredentials(String salesforceUsername, String salesforcePassword) throws Exception {
		
		salesforceSession = new SalesforceSessionFactory().build(new SalesforceCredentials(salesforceUsername, salesforcePassword));
		salesforceSession.initialize();
		
	}
	
	public void setSalesforceExistingSession(String sessionId, String url) throws Exception {
		
		salesforceSession = new SalesforceSessionFactory().build(sessionId, url);
		salesforceSession.initialize();
		
	}
	public Exception getLastException() {
		return lastException;
	}

	public void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

	public String getSalesforceUsername() {
		return salesforceUsername;
	}

	public void setSalesforceUsername(String salesforceUsername) {
		this.salesforceUsername = salesforceUsername;
	}

	public String getSalesforcePassword() {
		return salesforcePassword;
	}

	public void setSalesforcePassword(String salesforcePassword) {
		this.salesforcePassword = salesforcePassword;
	}

	public WrapperBean getWrapperBean() {
		return wrapperBean;
	}

	public void setWrapperBean(WrapperBean wrapperBean) {
		this.wrapperBean = wrapperBean;
	}

	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

	public void setSalesforceSession(SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
	}
	
	
	
}
