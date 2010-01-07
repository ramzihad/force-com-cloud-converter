package com.modelmetrics.cloudconverter.importxls.struts2;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.modelmetrics.cloudconverter.engine.PicklistProviderFactory;
import com.modelmetrics.cloudconverter.importxls.services.StringUtils;
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
	
	private Collection<String> existingObjects;
	
	private boolean nameUseAutonumber;
	
	private boolean upsertUseId;
	
	private String nameUseField;
	
	
	
	private String objectLabel;
	
	private String objectPlural;

	private String existingObject;


	public String execute() throws Exception {

		// general prep
		lookupObjects = new TreeSet<String>();lookupObjects.addAll(this.getUploadContext().getObjectToIdMap().keySet());
		existingObjects = new TreeSet<String>();existingObjects.addAll(this.getUploadContext().getObjectToFieldMap().keySet());

		// first time here?
		if (this.getSubmit() == null) {
			this.setNameUseAutonumber(this.getUploadContext().getCurrentCloudConverterObject().isNameUseAutonumber());
			metadata = this.getUploadContext().getCurrentCloudConverterObject()
					.getMetadataProxies();
			this.setObjectLabel(this.getUploadContext().getCurrentCloudConverterObject().getObjectLabel());
			this.setObjectPlural(this.getUploadContext().getCurrentCloudConverterObject().getObjectPlural());
			return Action.INPUT;
		}
		
		// skip this object?
		if (this.getSubmit().equalsIgnoreCase("skip this object")) {
			return "success-skip";
		}

		// update
		this.getUploadContext().getCurrentCloudConverterObject()
				.setMetadataProxies(this.getMetadata());

		// validate
		if (!this.validateInput()) {
			return Action.INPUT;
		}

		// picklist processing.
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
		
		//populate name information
		if (org.springframework.util.StringUtils.hasText(this.getExistingObject())) {
			this.getUploadContext().getCurrentCloudConverterObject().setExistingObject(this.getExistingObject());
		} else {
			this.getUploadContext().getCurrentCloudConverterObject().setExistingObject(null);
		}
		this.getUploadContext().getCurrentCloudConverterObject().setNameUseAutonumber(this.isNameUseAutonumber());
		this.getUploadContext().getCurrentCloudConverterObject().setNameUseField(this.getNameUseField());
		this.getUploadContext().getCurrentCloudConverterObject().setObjectLabel(this.getObjectLabel());
		this.getUploadContext().getCurrentCloudConverterObject().setObjectPlural(this.getObjectPlural());
		
		// RSC 2009-11-01
		if (this.isUpsertUseId()) {
			this.getUploadContext().getCurrentCloudConverterObject().setUpsertField("id");
		}
		
		return Action.SUCCESS;

	}
	
	public boolean validateInput() throws Exception {
	
		//validate that lookups also include an external ID
		boolean hasLookup = false;
		boolean hasExternalId = false;
		Set<String> relatedObjects = new TreeSet<String>();
		
		for (MetadataProxy metadataProxy : this.getMetadata()) {
			if (metadataProxy.getType() == FieldType.Lookup) {
				hasLookup = true;
				if (relatedObjects.contains(metadataProxy.getLookupObject())) {
					this.addActionMessage("You can only have a one relation to " + metadataProxy.getLookupObject() + " on this object.");
					return false;
				} else {
					relatedObjects.add(metadataProxy.getLookupObject());
				}
			}
			if (metadataProxy.isUniqueExternalId()) {
				hasExternalId = true;
			}
			//2009-12-29 should make this user configurable at some point.
			if (metadataProxy.getType() == FieldType.Checkbox) {
				metadataProxy.setDefaultValue("false");
			}
			
		}
		
		if (hasLookup && !hasExternalId && !this.upsertUseId) {
			this.addActionMessage("If you specify a field as a lookup, you must also specify a different field as an external ID or check 'Use object ID field with upsert'.");
			return false;
		}
		
		//validate individual
		for (MetadataProxy metadataProxy : this.getMetadata()) {
			if (!validateSingle(metadataProxy)) {
				return false;
			}
		}
		
		if (this.isNameUseAutonumber() && this.hasText(this.getNameUseField())) {
			this.addActionMessage("You have specified both 'use autonumber' and a field to use for name data.  You must select one or the other.");
			return false;
		}

		if (!this.isNameUseAutonumber() && !this.hasText(this.getNameUseField()) && !this.hasText(this.getExistingObject())) {
			this.addActionMessage("You have specified neither 'use autonumber' nor a field to use for name data.  You must select one or the other.");
			return false;
		}
		
		if (this.hasText(this.getExistingObject()) & this.isNameUseAutonumber()) {
			this.addActionMessage("You have specified and existing object and use autonumber.  You must select one or the other.");
		}
		
		return true;
		
	}
	
	
	public boolean validateSingle(MetadataProxy metadataProxy) throws Exception {
		boolean ret = true;
		
		//field type is Lookup -- requires additional data.
		if (metadataProxy.getType() == FieldType.Lookup) {
			if (!hasText(metadataProxy.getLookupObject()) || !hasText(metadataProxy.getLookupField())) {
				this.addActionMessage("Lookup fields must have both a lookup object and a lookup field specified. (" + metadataProxy.getLabel() + ")" );
				return false;
			}
		}
		
		if (metadataProxy.getType() == FieldType.Text && metadataProxy.getLength() == 0) {
			this.addActionMessage("Fields with a data type of Text cannot have a length of 0. (" + metadataProxy.getLabel() + ")");
			return false;
		}
		
		if (metadataProxy.isUniqueExternalId() && metadataProxy.getType() != FieldType.Text) {
			this.addActionMessage("Cloud Converter requires fields with the external ID checkbox selected to be of data type Text. (" + metadataProxy.getLabel() + ")");
			return false;			
		}
		
		if ((hasText(metadataProxy.getLookupField()) || hasText(metadataProxy.getLookupField())) && metadataProxy.getType() != FieldType.Lookup) {
			this.addActionMessage("You had a lookup object specified for a field type other than lookup. (" + metadataProxy.getLabel() + ")");
			return false;
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

	public boolean isNameUseAutonumber() {
		return nameUseAutonumber;
	}

	public void setNameUseAutonumber(boolean nameUseAutonumber) {
		this.nameUseAutonumber = nameUseAutonumber;
	}

	public String getNameUseField() {
		return nameUseField;
	}

	public void setNameUseField(String nameUseField) {
		this.nameUseField = nameUseField;
	}
	
	public String getObjectLabel() {
		return objectLabel;
	}

	public void setObjectLabel(String objectLabel) {
		this.objectLabel = objectLabel;
	}

	public String getObjectPlural() {
		return objectPlural;
	}

	public void setObjectPlural(String objectPlural) {
		this.objectPlural = objectPlural;
	}

	public Collection<String> getExistingObjects() {
		return existingObjects;
	}

	public void setExistingObjects(Collection<String> existingObjects) {
		this.existingObjects = existingObjects;
	}

	public String getExistingObject() {
		return existingObject;
	}

	public void setExistingObject(String existingObject) {
		this.existingObject = existingObject;
	}

	public boolean isUpsertUseId() {
		return upsertUseId;
	}

	public void setUpsertUseId(boolean upsertUseId) {
		this.upsertUseId = upsertUseId;
	}


}
