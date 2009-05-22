package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.FileService;
import com.modelmetrics.cloudconverter.mmimport.services.SalesforceService;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;

public class UploadActionCompositeOverride extends AbstractUploadContextAware {

	private static final long serialVersionUID = 1760991341958287065L;

	private FileService fileService;

	private SalesforceService salesforceService;

	private Boolean override;

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
		List<WrapperBean> beans = this.getUploadContext().getWrapperBeans();

		for (WrapperBean wrapperBean : beans) {
			wrapperBean.setOverride(Boolean.TRUE);
		}
		return SUCCESS;

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

}
