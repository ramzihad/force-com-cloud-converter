package com.modelmetrics.cloudconverter.common.struts2;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractUtilityContextAware extends ActionSupport {

	private UtilityContext utilityContext;

	public UtilityContext getUtilityContext() {
		return utilityContext;
	}

	public void setUtilityContext(UtilityContext utilityContext) {
		this.utilityContext = utilityContext;
	}
	
	
}
