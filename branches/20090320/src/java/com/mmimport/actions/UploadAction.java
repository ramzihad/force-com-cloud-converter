package com.mmimport.actions;

import java.io.File;

import org.apache.log4j.Logger;

import com.mmimport.beans.WrapperBean;
import com.mmimport.exceptions.ParseException;
import com.mmimport.services.FileService;
import com.mmimport.services.SalesforceService;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private static final Logger log = Logger.getLogger(UploadAction.class);

	private static final long serialVersionUID = 1760991341958287065L;

	private FileService fileService;

	private SalesforceService salesforceService;

	private File upload;

	private String uploadContentType;

	private String password;

	private String username;
	
	private Boolean override;

	private String uploadFileName;

	private WrapperBean bean;

	/**
	 * initializes form input page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String init() throws Exception {

		return INPUT;
	}

	/**
	 * Uploads the XLS and transformes it to a WrapperBean object to be sent to
	 * view
	 * 
	 * @return
	 */
	public String upload() {

		try {
			boolean error = false;
			if ("".equals(username)) {
				addActionMessage("Username is required");
				error = true;
			}
			if ("".equals(password)) {
				addActionMessage("Password is required");
				error = true;
			}
			if (upload == null) {
				addActionMessage("Please select a file");
				error = true;
			}
			if (error) {
				return INPUT;
			}


			bean = fileService.parseXLS(upload);
			bean.setOverride(override);
			
			log.info("File uploaded successfully");

			log.info("Generating Salesforce object now...");
			salesforceService.execute(bean, username, password);
			log.info("Object sent successfully");

			return SUCCESS;
		} catch (ParseException e) {
			log.error("There has been a problem uploading the file", e);
			return ERROR;

		} catch (Exception e) {
			log.error("There has been a problem generating salesforce objects",
					e);
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}



}
