package com.modelmetrics.utility.describe.struts2;

import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;
import com.modelmetrics.utility.common.struts2.AbstractUtilityContextAware;

public class AbstractDescribeContextAware extends AbstractUtilityContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DescribeContext describeContext;
	
	private SalesforceSessionContext salesforceSessionContext;

	public DescribeContext getDescribeContext() {
		return describeContext;
	}

	public void setDescribeContext(DescribeContext describeContext) {
		this.describeContext = describeContext;
	}

	public SalesforceSessionContext getSalesforceSessionContext() {
		return salesforceSessionContext;
	}

	public void setSalesforceSessionContext(
			SalesforceSessionContext salesforceSessionContext) {
		this.salesforceSessionContext = salesforceSessionContext;
	}
	
}
