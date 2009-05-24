package com.modelmetrics.cloudconverter.mmimport.actions;

import com.opensymphony.xwork2.Action;

public class UploadActionCompositeOverride extends AbstractUploadContextAware {

	private static final long serialVersionUID = 1760991341958287065L;

	private static final String SUBMIT_CANCEL = "No";
	
	private static final String SUCCESS_CANCEL = "cancel";
	
	private String submit;


	public String execute() throws Exception {
		
		if (this.getSubmit() == null) {
			return Action.INPUT;
		}
		
		if (this.getSubmit().startsWith(SUBMIT_CANCEL)) {
			return SUCCESS_CANCEL;
		}
		
		return SUCCESS;
	}


	public String getSubmit() {
		return submit;
	}


	public void setSubmit(String submit) {
		this.submit = submit;
	}

}
