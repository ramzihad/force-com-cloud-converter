package com.modelmetrics.cloudconverter.mmimport.actions;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractUploadContextAware extends ActionSupport {

	private UploadContext uploadContext;

	public UploadContext getUploadContext() {
		return uploadContext;
	}

	public void setUploadContext(UploadContext uploadContext) {
		this.uploadContext = uploadContext;
	}
	
	
}
