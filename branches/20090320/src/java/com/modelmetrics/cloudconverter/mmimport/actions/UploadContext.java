package com.modelmetrics.cloudconverter.mmimport.actions;

import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;

public class UploadContext  {

	private Exception lastException;

	private String salesforceUsername;

	private String salesforcePassword;

	private WrapperBean wrapperBean;



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

	public String getErrorMessage() {
		return this.getLastException().getMessage() + ", "
				+ this.getLastException().getLocalizedMessage();
	}



}
