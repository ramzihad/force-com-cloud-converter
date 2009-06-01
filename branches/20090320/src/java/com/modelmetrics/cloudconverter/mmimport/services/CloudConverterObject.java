/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
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
