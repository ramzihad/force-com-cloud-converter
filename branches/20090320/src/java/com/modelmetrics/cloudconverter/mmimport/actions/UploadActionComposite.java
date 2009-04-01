package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import org.apache.log4j.Logger;

import com.modelmetrics.cloudconverter.mmimport.services.FileService;
import com.modelmetrics.cloudconverter.mmimport.services.ParseException;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.common.sforce.struts2.AbstractCompositeAction;
import com.modelmetrics.common.sforce.struts2.SalesforceSessionContext;

public class UploadActionComposite extends AbstractCompositeAction {

	private static final Logger log = Logger.getLogger(UploadActionComposite.class);

	private static final long serialVersionUID = 1760991341958287065L;

	

	private FileService fileService;

	private SalesforceService salesforceService;

	private File upload;

	private String uploadContentType;

	
	private Boolean override;

	private String uploadFileName;

	private WrapperBean bean;

	private String message;

private SalesforceSessionContext salesforceSessionContext;

	private UploadContext uploadContext;

	public UploadContext getUploadContext() {
		return uploadContext;
	}

	public void setUploadContext(UploadContext uploadContext) {
		this.uploadContext = uploadContext;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * initializes form input page
	 * 
	 * @return
	 * @throws Exception
	 */
//	public String init() throws Exception {
//
//		boolean error = false;
//		
//		if ("".equals(this.getExistingLocationUrl())) {
//			addActionMessage("locationUrl is required");
//			error = true;
//		}
//		if ("".equals(this.getExistingSessionId())) {
//			addActionMessage("Session Id is required");
//			error = true;
//		}
//		
//		if (error) {
//			return ERROR;
//		}
//		
//		/*
//		 * let's check the session id and location url
//		 */
//		try {
//			this.getUploadContext().setSalesforceExistingSession(
//					this.getExistingSessionId(), this.getExistingLocationUrl());
//			addActionError("session set.");
//			log.debug("Session set");
//			
//		} catch (Exception e) {
//			this.getUploadContext().setLastException(e);
//			error = true;
//			addActionMessage("Could not initialize your Salesforce session.  (Existing URL or Session ID invalid");
//		}		
//		
//		return INPUT;
//	}

	public String init2() throws Exception {
		return INPUT;
	}
	/**
	 * Uploads the XLS and transforms it to a WrapperBean object to be sent to
	 * view
	 * 
	 * @return
	 */
	public String upload() {

		try {
			boolean error = false;

			if (this.getSalesforceSessionContext().getSalesforceSession() == null) {
				addActionMessage("No Salesforce Session present.");
				error = true;
			}
			if (upload == null) {
				addActionMessage("Please select a file");
				error = true;
			}


			
			/*
			 * failed?
			 */
			if (error) {
				return INPUT;
			}

			salesforceService.setSalesforceSession(this.getSalesforceSessionContext().getSalesforceSession());
			
			bean = fileService.parseXLS(upload);
			bean.setOverride(override);
			
			this.getUploadContext().setWrapperBean(bean);

			log.info("File uploaded successfully");

			boolean containsObject = salesforceService.checkObject(bean);
			if (containsObject) {

				return "override";
			} else {
				log.info("Generating Salesforce object now...");
				bean.setOverride(Boolean.FALSE);
				salesforceService.execute(bean);
			}
			log.info("Object sent successfully");

			return SUCCESS;
		} catch (ParseException e) {
			message = "There has been a problem uploading the file";
			log.error(message, e);
			this.getUploadContext().setLastException(e);
			return ERROR;

		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			this.getUploadContext().setLastException(e);
			return ERROR;
		}
	}

	public String override() {
		try {
			log.info("Generating Salesforce object now...");
			bean = this.getUploadContext().getWrapperBean();
			bean.setOverride(Boolean.TRUE);
			salesforceService.setSalesforceSession(this.getSalesforceSessionContext().getSalesforceSession());
			salesforceService.execute(bean);

			
			log.info("Object sent successfully");
			return SUCCESS;
		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			this.getUploadContext().setLastException(e);
			return ERROR;
		}
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public FileService getFileService() {
		return fileService;
	}

	public WrapperBean getBean() {
		return bean;
	}

	public void setBean(WrapperBean bean) {
		this.bean = bean;
	}

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}

	public SalesforceService getSalesforceService() {
		return this.salesforceService;
	}

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}

	public SalesforceSessionContext getSalesforceSessionContext() {
		return salesforceSessionContext;
	}

	public void setSalesforceSessionContext(
			SalesforceSessionContext salesforceSessionContext) {
		this.salesforceSessionContext = salesforceSessionContext;
	}



}
