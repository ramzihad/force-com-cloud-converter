package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.AdvanceOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.OptionsOneBean;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.LookupBean;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriber;

public class UploadContext  {

	private Exception lastException;

	private String salesforceUsername;

	private String salesforcePassword;

	private WrapperBean wrapperBean;
	
	private List<WrapperBean> wrapperBeans;
	
	private List<ExternalIdBean> externalIds = new ArrayList<ExternalIdBean>();

	private List<LookupBean> lookups = new ArrayList<LookupBean>();
	
	private List<AdvanceOptionsBean> advanceOptionsBeans;

	private List<OptionsOneBean> advanceOptionsWrapperBeans;

	
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

	public List<ExternalIdBean> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(List<ExternalIdBean> externalIds) {
		this.externalIds = externalIds;
	}

	public List<LookupBean> getLookups() {
		return lookups;
	}

	public void setLookups(List<LookupBean> lookups) {
		this.lookups = lookups;
	}

	public List<WrapperBean> getWrapperBeans() {
		return wrapperBeans;
	}

	public void setWrapperBeans(List<WrapperBean> wrapperBeans) {
		this.wrapperBeans = wrapperBeans;
	}

	public List<OptionsOneBean> getAdvanceOptionsWrapperBeans() {
		return advanceOptionsWrapperBeans;
	}

	public void setAdvanceOptionsWrapperBeans(
			List<OptionsOneBean> advanceOptionsWrapperBeans) {
		this.advanceOptionsWrapperBeans = advanceOptionsWrapperBeans;
	}



}
