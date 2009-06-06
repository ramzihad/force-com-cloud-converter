package com.modelmetrics.cloudconverter.compare.struts2;

import com.modelmetrics.cloudconverter.compare.ComparisonGroup;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractCompareContextAware extends ActionSupport {

	private SalesforceSessionContext salesforceSessionContext;
	
	private CompareContext compareContext;

	public CompareContext getCompareContext() {
		return compareContext;
	}

	public void setCompareContext(CompareContext compareContext) {
		this.compareContext = compareContext;
	}

	public SalesforceSessionContext getSalesforceSessionContext() {
		return salesforceSessionContext;
	}

	public void setSalesforceSessionContext(
			SalesforceSessionContext salesforceSessionContext) {
		this.salesforceSessionContext = salesforceSessionContext;
	}
	
}
