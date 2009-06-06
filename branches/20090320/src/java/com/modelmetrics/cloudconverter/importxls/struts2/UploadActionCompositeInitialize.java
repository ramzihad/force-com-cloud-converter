package com.modelmetrics.cloudconverter.importxls.struts2;

import java.io.File;

import org.apache.log4j.Logger;

import com.modelmetrics.cc.importxls.svcs.ExcelWorksheetWrapperBean;
import com.modelmetrics.cc.importxls.svcs.FileService;
import com.modelmetrics.cc.importxls.svcs.SalesforceService;

public class UploadActionCompositeInitialize extends AbstractUploadContextAware {

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeInitialize.class);

	private static final long serialVersionUID = 1760991341958287065L;

	private FileService fileService;

	private SalesforceService salesforceService;

	private File upload;

	private String uploadContentType;

	private Boolean override;

	private String uploadFileName;

	private ExcelWorksheetWrapperBean bean;

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

	public String execute() throws Exception {

		if (this.getExistingSessionId() != null
				&& this.getExistingLocationUrl() != null) {
			this.getSalesforceSessionContext().setSalesforceSession(null);
			this.getSalesforceSessionContext().setSalesforceExistingSession(
					this.getExistingSessionId(), this.getExistingLocationUrl());
		} else {
			return ERROR;
		}
		return INPUT;
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

	public ExcelWorksheetWrapperBean getBean() {
		return bean;
	}

	public void setBean(ExcelWorksheetWrapperBean bean) {
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
