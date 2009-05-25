package com.modelmetrics.cloudconverter.mmimport.actions;

import com.opensymphony.xwork2.Action;

/**
 * 
 * @author reidcarlberg
 * @since 2009-05-24
 */
public class AdvancedImportSetOptionsAction extends AbstractUploadContextAware {

	private String submit;
	


	public String execute() throws Exception {
	
		if (this.getSubmit() == null) {
			return Action.INPUT;
		}
		
		
		return Action.SUCCESS;

	}
	
	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
}
