package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.SingleFieldOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.LookupAndIdWrapper;
import com.modelmetrics.cloudconverter.mmimport.services.SheetOptionsBean;
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
	
	private List<SingleFieldOptionsBean> advanceOptionsBeans;

	private List<SheetOptionsBean> advanceOptionsWrapperBeans;

	private List<LookupAndIdWrapper> lookupIdWrapperList;
	
	private MigrationStatusSubscriber statusSubscriber;

	private List<LookupAndIdWrapper> auxList;

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

	public List<SingleFieldOptionsBean> getAdvanceOptionsBeans() {
		return advanceOptionsBeans;
	}

	public void setAdvanceOptionsBeans(List<SingleFieldOptionsBean> advanceOptionsBeans) {
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

	public List<SheetOptionsBean> getAdvanceOptionsWrapperBeans() {
		return advanceOptionsWrapperBeans;
	}

	public void setAdvanceOptionsWrapperBeans(
			List<SheetOptionsBean> advanceOptionsWrapperBeans) {
		this.advanceOptionsWrapperBeans = advanceOptionsWrapperBeans;
	}

	public List<LookupAndIdWrapper> getLookupIdWrapperList() {
		return lookupIdWrapperList;
	}

	public void setLookupIdWrapperList(List<LookupAndIdWrapper> lookupIdWrapperList) {
		this.lookupIdWrapperList = lookupIdWrapperList;
	}

	public List<LookupAndIdWrapper> getAuxList() {
		return auxList;
	}

	public void setAuxList(List<LookupAndIdWrapper> auxList) {
		this.auxList = auxList;
	}



}
