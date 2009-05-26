package com.modelmetrics.cloudconverter.mmimport.actions;

import java.util.Collection;
import java.util.List;

import com.modelmetrics.cloudconverter.engine.PicklistProviderFactory;
import com.modelmetrics.cloudconverter.mmimport.services.StringUtils;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.opensymphony.xwork2.Action;
import com.sforce.soap._2006._04.metadata.FieldType;

/**
 * 
 * @author reidcarlberg
 * @since 2009-05-24
 */
public class AdvancedImportSetOptionsAction extends AbstractUploadContextAware {

	private String submit;

	private List<MetadataProxy> metadata;

	private List<String> fieldTypes = StringUtils.getAllFieldTypes();

	private Collection<String> lookupObjects;

	public String execute() throws Exception {

		// general prep
		lookupObjects = this.getUploadContext().getObjectToIdMap().keySet();

		// first time here?
		if (this.getSubmit() == null) {
			metadata = this.getUploadContext().getCurrentCloudConverterObject()
					.getMetadataProxies();
			return Action.INPUT;
		}

		// update
		this.getUploadContext().getCurrentCloudConverterObject()
				.setMetadataProxies(this.getMetadata());

		// validate
		for (MetadataProxy metadataProxy : this.getMetadata()) {
			if (!validate(metadataProxy)) {
				return Action.INPUT;
			}
		}

		// picklists
		for (MetadataProxy metadataProxy : this.getMetadata()) {
			if (metadataProxy.getType() == FieldType.Picklist) {
				this.getUploadContext().getCurrentCloudConverterObject().getPicklistFields().put(
						metadataProxy.getName(),
						new PicklistProviderFactory().build(metadataProxy, this
								.getUploadContext()
								.getCurrentCloudConverterObject()
								.getOriginalData()));
			}
		}

		return Action.SUCCESS;

	}
	
	public boolean validate(MetadataProxy metadataProxy) throws Exception {
		boolean ret = true;
		
		//field type
		if (metadataProxy.getType() == FieldType.Lookup) {
			if (!hasText(metadataProxy.getLookupObject()) || !hasText(metadataProxy.getLookupField())) {
				this.addActionMessage("Lookup fields must have both a lookup object and a lookup field specified.");
				return false;
			}
		}
		
		
		return ret;
	}

	public boolean hasText(String string) {
		return org.springframework.util.StringUtils.hasText(string);
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

	public Collection<String> getLookupObjects() {
		return lookupObjects;
	}

	public void setLookupObjects(Collection<String> lookupObjects) {
		this.lookupObjects = lookupObjects;
	}
}
