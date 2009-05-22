package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.modelmetrics.cloudconverter.mmimport.services.FileService;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.MigrationStatusSubscriberLifoImpl;

public class UploadActionCompositeExecute extends AbstractUploadContextAware {

	private static final Logger log = Logger
			.getLogger(UploadActionCompositeExecute.class);

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

	/**
	 * Uploads the XLS and transforms it to a WrapperBean object to be sent to
	 * view
	 * 
	 * @return
	 */
	public String execute() throws Exception {
		try {
			List<WrapperBean> beans = this.getUploadContext().getWrapperBeans();

			this.getUploadContext().setStatusSubscriber(
					new MigrationStatusSubscriberLifoImpl());

			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());

			log.info("Generating Salesforce object now...");
			this.getUploadContext().setWrapperBeans(beans);

			salesforceService.executeMultiple(this.getUploadContext());

			log.info("Object sent successfully");
			this.getUploadContext().setWrapperBeans(beans);
			return SUCCESS;
		} catch (Exception e) {
			message = "There has been a problem generating salesforce objects";
			log.error(message, e);
			addActionMessage(message);
			// this.getUploadContext().setLastException(e);
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
