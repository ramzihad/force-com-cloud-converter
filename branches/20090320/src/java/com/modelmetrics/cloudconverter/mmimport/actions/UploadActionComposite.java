package com.modelmetrics.cloudconverter.mmimport.actions;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.modelmetrics.cloudconverter.mmimport.services.FileService;
import com.modelmetrics.cloudconverter.mmimport.services.ParseException;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.SalesforceCredentialsBuilder;
import com.modelmetrics.common.sforce.SalesforceCredentials;

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

	private List<WrapperBean> beans;

	private String message;
	
	private Long selectedOption;
	
	private Map<Long,String> optionsList;

	private String existingLocationUrl;
	private String existingSessionId;
	private List<String> sheets;

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

		try {

			/*if (this.getSalesforceSessionContext().getSalesforceSession() == null) {
				addActionMessage("No Salesforce Session present.");
			}*/
			
			//TODO make work the session context
			/*this.getSalesforceSessionContext()
			.setSalesforceCredentials("marianocolombo.dev@gmail.com",
					"police78aV9NiOCnvUNs3VC2FzoVX1Dt");
			*/
			if (upload == null) {
				addActionMessage("Please select a file");
			}

			if (!getActionMessages().isEmpty()) {
				return INPUT;
			}
		
			salesforceService.setSalesforceSession(this
					.getSalesforceSessionContext().getSalesforceSession());

			// parse all sheets here
			beans = fileService.parseXLS(upload);
			this.getUploadContext().setWrapperBeans(beans);
		
			//set radio button options for next page
			optionsList = StringUtils.getOptions();
			
			log.info("XLS file uploaded successfully");
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

	public Boolean getOverride() {
		return override;
	}

	public void setOverride(Boolean override) {
		this.override = override;
	}

	public List<WrapperBean> getBeans() {
		return beans;
	}

	public void setBeans(List<WrapperBean> beans) {
		this.beans = beans;
	}

	public Long getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Long selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Map<Long, String> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(Map<Long, String> optionsList) {
		this.optionsList = optionsList;
	}

}
