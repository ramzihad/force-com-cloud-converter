package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;

import org.apache.log4j.Logger;

import com.modelmetrics.cloudconverter.mmimport.services.FileService;
import com.modelmetrics.cloudconverter.mmimport.services.ParseException;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;

public class UploadActionComposite extends AbstractUploadContextAware {

	private static final Logger log = Logger
			.getLogger(UploadActionComposite.class);

	private static final long serialVersionUID = 1760991341958287065L;

	private FileService fileService;

	private SalesforceService salesforceService;

	private File upload;

	private String uploadContentType;

	private Boolean override;

	private String uploadFileName;

	private WrapperBean bean;

	private String message;

	private String existingLocationUrl;
	private String existingSessionId;

	public String getExistingLocationUrl() {
		return existingLocationUrl;
	}

	public String getExistingSessionId() {
		return existingSessionId;
	}

	public String getS() {
		return this.getExistingSessionId();
	}

	public String getU() {
		return this.getExistingLocationUrl();
	}

	public void setExistingLocationUrl(String username) {
		this.existingLocationUrl = username;
	}

	public void setExistingSessionId(String password) {
		this.existingSessionId = password;
	}

	public void setS(String s) {
		this.setExistingSessionId(s);
	}

	public void setU(String u) {
		this.setExistingLocationUrl(u);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String init2() throws Exception {

		if (this.getSalesforceSessionContext().getSalesforceSession() == null
				&& this.getExistingSessionId() != null
				&& this.getExistingLocationUrl() != null) {
			this.getSalesforceSessionContext().setSalesforceExistingSession(
					this.getExistingSessionId(), this.getExistingLocationUrl());

			log.info("salesforce existing session was null??");
		}
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

			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());

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
			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());
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

}
