package com.mmimport.actions;

import java.io.File;

import org.apache.log4j.Logger;

import com.mmimport.beans.WrapperBean;
import com.mmimport.exceptions.ParseException;
import com.mmimport.services.FileService;
import com.opensymphony.xwork2.ActionSupport;

public class UploadActionCC extends ActionSupport {

	/**
	 * jhjh
	 */
	private static final long serialVersionUID = 1L;



	private static final Logger log = Logger.getLogger(UploadActionCC.class);

	

	private FileService fileService;

	private File upload;

	private String uploadContentType;

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
	 * Uploads the XLS and transformes it to a WrapperBean 
	 * object to be sent to view 
	 * @return
	 */
	public String upload() {

		try {
			if (upload == null) {
				addActionMessage("Please select a file");
				return INPUT;
			}

			bean = fileService.parseXLS(upload);

			log.info("File uploaded successfully");
			return SUCCESS;
		} catch (ParseException e) {
			log.error("There has been a problem uploading the file", e);
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

}
