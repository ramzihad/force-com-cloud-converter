package com.modelmetrics.cloudconverter.importxls.struts2;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class UploadActionCompositeBranch extends AbstractUploadContextAware {

	private static final long serialVersionUID = -3145368694251083353L;

	private static final String SUBMIT_STANDARD = "Standard Import";

	private static final String SUBMIT_ADVANCED = "Show Advanced Options";

	private static final String SUCCESS_ADVANCED = "success_advanced";

	private static final String SUCCESS_STANDARD = "success_standard";

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeBranch.class);

	private String submit;

	public String execute() throws Exception {

		// if someone comes "back" submit will be null and we need to get them
		// to input.
		if (this.getSubmit() == null) {
			return Action.INPUT;
		}

		// standard goes right to the override check
		if (this.getSubmit().equalsIgnoreCase(SUBMIT_STANDARD)) {
			return SUCCESS_STANDARD;
		}

		// ONLY OTHER OPTION - advanced goes to the field level detail screen
		return SUCCESS_ADVANCED;

	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

}
