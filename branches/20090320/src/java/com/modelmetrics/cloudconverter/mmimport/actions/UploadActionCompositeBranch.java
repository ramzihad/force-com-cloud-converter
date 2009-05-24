package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.services.SingleFieldOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.SheetOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.ValueId;
import com.modelmetrics.cloudconverter.mmimport.services.ExcelWorksheetWrapperBean;
import com.opensymphony.xwork2.Action;

public class UploadActionCompositeBranch extends AbstractUploadContextAware {

	private static final long serialVersionUID = -3145368694251083353L;

	private static final String SUBMIT_STANDARD = "Standard Import";

	private static final String SUBMIT_ADVANCED = "Show Advanced Options";

	private static final String SUCCESS_ADVANCED = "advancedOptionsOne";

	private static final String SUCCESS_STANDARD = "standardCheckExisting";

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
