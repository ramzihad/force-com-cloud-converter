package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.modelmetrics.cloudconverter.engine.PicklistProvider;
import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.util.MetadataProxy;

public class CloudConverterObject {

	private ExcelWorksheetWrapperBean originalData;
	
	private List<MetadataProxy> metadataProxies;
	
	private List<LookupSettings> lookupSettings;
	
	private String objectName;
	
	private String objectLabel;
	
	private String objectPlural;
	
	private boolean existsInSalesforce;
	
	private String upsertField;
	
	private Map<String, PicklistProvider> picklistFields = new HashMap<String, PicklistProvider>();
	
	private boolean nameUseAutonumber = true;
	
	private String nameUseField;
	


	public ExcelWorksheetWrapperBean getOriginalData() {
		return originalData;
	}

	public void setOriginalData(ExcelWorksheetWrapperBean originalData) {
		this.originalData = originalData;
	}

	public List<MetadataProxy> getMetadataProxies() {
		return metadataProxies;
	}

	public void setMetadataProxies(List<MetadataProxy> metadataProxies) {
		this.metadataProxies = metadataProxies;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getUpsertField() {
		return upsertField;
	}

	public void setUpsertField(String upsertField) {
		this.upsertField = upsertField;
	}

	public String getObjectLabel() {
		return objectLabel;
	}

	public void setObjectLabel(String objectLabel) {
		this.objectLabel = objectLabel;
	}

	public List<LookupSettings> getLookupSettings() {
		return lookupSettings;
	}

	public void setLookupSettings(List<LookupSettings> lookupSettings) {
		this.lookupSettings = lookupSettings;
	}

	public boolean isExistsInSalesforce() {
		return existsInSalesforce;
	}

	public void setExistsInSalesforce(boolean existsInSalesforce) {
		this.existsInSalesforce = existsInSalesforce;
	}

	public Map<String, PicklistProvider> getPicklistFields() {
		return picklistFields;
	}

	public void setPicklistFields(Map<String, PicklistProvider> picklistFields) {
		this.picklistFields = picklistFields;
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

	public String getObjectPlural() {
		return objectPlural;
	}

	public void setObjectPlural(String objectPlural) {
		this.objectPlural = objectPlural;
	}
	
}
