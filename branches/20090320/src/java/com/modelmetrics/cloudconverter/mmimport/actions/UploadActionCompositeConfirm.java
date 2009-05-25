package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.SheetOptionsBean;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.opensymphony.xwork2.Action;

public class UploadActionCompositeConfirm extends AbstractUploadContextAware
		 {

	private static final long serialVersionUID = 5950249609611643673L;

	private static final String SUBMIT_CONFIRM = "Yes";

	private static final String SUCCESS_GOBACK = "GoBack";
	
	private static final Logger log = Logger
	.getLogger(UploadActionCompositeConfirm.class);

	private String submit;
	
	


	
	public String execute() throws Exception {

		if (this.getSubmit() == null) 
			return Action.INPUT;
		
		if (this.getSubmit().startsWith(SUBMIT_CONFIRM) ) 
			return Action.SUCCESS;
		
		return SUCCESS_GOBACK;

		
	}





	public String getSubmit() {
		return submit;
	}





	public void setSubmit(String submit) {
		this.submit = submit;
	}
	




}
