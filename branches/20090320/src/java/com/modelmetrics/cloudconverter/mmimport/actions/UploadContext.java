package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.AdvanceOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;

public class UploadContext  {

	private Exception lastException;

	private String salesforceUsername;

	private String salesforcePassword;

	private WrapperBean wrapperBean;
	
	private List<AdvanceOptionsBean> advanceOptionsBeans;

	
	private MigrationStatusSubscriber statusSubscriber;



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

	public MigrationStatusSubscriber getStatusSubscriber() {
		return statusSubscriber;
	}

	public void setStatusSubscriber(MigrationStatusSubscriber statusSubscriber) {
		this.statusSubscriber = statusSubscriber;
	}

	public List<AdvanceOptionsBean> getAdvanceOptionsBeans() {
		return advanceOptionsBeans;
	}

	public void setAdvanceOptionsBeans(List<AdvanceOptionsBean> advanceOptionsBeans) {
		this.advanceOptionsBeans = advanceOptionsBeans;
	}



}
