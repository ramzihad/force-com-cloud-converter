package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.List;

import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.opensymphony.xwork2.Action;

/**
 * 
 * @author reidcarlberg
 * @since 2009-05-24
 */
public class AdvancedImportSetOptionsAction extends AbstractUploadContextAware {

	private String submit;
	
	private List<MetadataProxy> metadata;
	
	private List<String> fieldTypes = StringUtils.getAllFieldTypes();

	public String execute() throws Exception {
	
		if (this.getSubmit() == null) {
			metadata = this.getUploadContext().getCurrentCloudConverterObject().getMetadataProxies();
			return Action.INPUT;
		}
		
		this.getUploadContext().getCurrentCloudConverterObject().setMetadataProxies(this.getMetadata());
		
		return Action.SUCCESS;

	}
	
	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	public List<MetadataProxy> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<MetadataProxy> metadata) {
		this.metadata = metadata;
	}

	public List<String> getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(List<String> fieldTypes) {
		this.fieldTypes = fieldTypes;
	}
}
