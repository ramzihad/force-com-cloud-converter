package com.modelmetrics.cc.importxls.struts2;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.temp.CloudConverterObject;
import com.temp.CloudConverterObjectBuilder;
import com.temp.ExcelWorksheetWrapperBean;
import com.temp.FileService;
import com.temp.ParseException;
import com.temp.SalesforceService;

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
	public String execute() {

		if (this.getSalesforceSessionContext().getSalesforceSession() == null) {
			addActionMessage("No Salesforce Session present.");
		}

		if (upload == null) {
			addActionMessage("Please select a file");
		}

		if (!getActionMessages().isEmpty()) {
			return INPUT;
		}

		salesforceService.setSalesforceSession(this
				.getSalesforceSessionContext().getSalesforceSession());

		// parse all sheets here
		List<ExcelWorksheetWrapperBean> beans = null;

		try {
			beans = fileService.parseXLS(upload);
		} catch (Exception e) {
			message = "There has been a problem uploading and parsing the file. (" + e.getLocalizedMessage() + ")";
			log.error(message, e);
			this.getUploadContext().setLastException(e);
			return ERROR;
		}

		List<CloudConverterObject> targets = null;

		try {
			targets = new CloudConverterObjectBuilder()
					.buildFromExcelFile(beans);
		} catch (Exception e) {
			message = "There has been a problem converting the file to metadata";
			log.error(message, e);
			this.getUploadContext().setLastException(e);
			if (e instanceof IndexOutOfBoundsException) {
				this.getUploadContext().setMessage("This message is usually caused by an Excel document that is not properly formatted.");
			}
			return ERROR;
		}
		
		this.getUploadContext().setCloudConverterObjects(targets);

		log.info("Upload Completed Successfully");
		return SUCCESS;

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

	public void setSalesforceService(SalesforceService salesforceService) {
		this.salesforceService = salesforceService;
	}

	public SalesforceService getSalesforceService() {
		return this.salesforceService;
	}





}
