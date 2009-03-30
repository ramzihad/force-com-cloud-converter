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

package com.modelmetrics.cloudconverter.engine;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.dirtdb.DirtConnectionIF;
import com.modelmetrics.cloudconverter.forceutil.LookupSettings;
import com.modelmetrics.cloudconverter.mmimport.services.WrapperBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.common.sforce.SalesforceCredentials;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.modelmetrics.common.sforce.SalesforceSessionFactory;
import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;

/**
 * Tracks information about the migration.
 * 
 */
public class MigrationContext {

	private static final Log log = LogFactory.getLog(MigrationContext.class);
	
	private SalesforceCredentials salesforceCredentials;
	
	private SalesforceSession salesforceSession;
	
	private Map<String, String> fieldMap;
	
	private CustomObject customObject;
	
	private CustomField[] customFields;
	
	private CustomField[] customLookupFields;
	
	private String[] customFieldShortNames;
	
	private ResultSet resultSet;
	
	private ResultSetMetaData resultSetMetaData;
	
	private DirtConnectionIF dirtConnection;
	
	private Map<String, String> picklistFields;
	
	private Map<String, LookupSettings> lookupFields;
	
	private Collection<String> externalIds;
	
	private String externalIdForUpsert;
	
	private List<MetadataProxy> metadataProxies;

	private WrapperBean wrapperBean;
	
	public String getExternalIdForUpsert() {
		return externalIdForUpsert;
	}

	public void setExternalIdForUpsert(String externalIdForUpsert) {
		this.externalIdForUpsert = externalIdForUpsert;
	}

	public ResultSetMetaData getResultSetMetaData() {
		return resultSetMetaData;
	}

	public void setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
		this.resultSetMetaData = resultSetMetaData;
	}

	public CustomObject getCustomObject() {
		return customObject;
	}

	public void setCustomObject(CustomObject customObject) {
		this.customObject = customObject;
	}

	public Map<String, String> getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(Map<String, String> fieldMap) {
		this.fieldMap = fieldMap;
	}


	public SalesforceSession getSalesforceSession() {
		return salesforceSession;
	}

	public void setSalesforceSession(SalesforceSession salesforceSession) {
		this.salesforceSession = salesforceSession;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public SalesforceCredentials getSalesforceCredentials() {
		return salesforceCredentials;
	}

	public void setSalesforceCredentials(SalesforceCredentials salesforceCredentials) {
		this.salesforceCredentials = salesforceCredentials;
	}
	


	public CustomField[] getCustomFields() {
		return customFields;
	}

	public void setCustomFields(CustomField[] customFields) {
		this.customFields = customFields;
	}

	public String[] getCustomFieldShortNames() {
		return customFieldShortNames;
	}

	public void setCustomFieldShortNames(String[] customFieldShortNames) {
		this.customFieldShortNames = customFieldShortNames;
	}

	public Map<String, String> getPicklistFields() {
		return picklistFields;
	}

	public void setPicklistFields(Map<String, String> picklistFields) {
		this.picklistFields = picklistFields;
	}

	public Map<String, LookupSettings> getLookupFields() {
		return lookupFields;
	}

	public void setLookupFields(Map<String, LookupSettings> lookupFields) {
		this.lookupFields = lookupFields;
	}

	public Collection<String> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(Collection<String> externalIds) {
		this.externalIds = externalIds;
	}

	public DirtConnectionIF getDirtConnection() {
		return dirtConnection;
	}

	public void setDirtConnection(DirtConnectionIF dirtConnection) {
		this.dirtConnection = dirtConnection;
	}

	public CustomField[] getCustomLookupFields() {
		return customLookupFields;
	}

	public void setCustomLookupFields(CustomField[] customLookupFields) {
		this.customLookupFields = customLookupFields;
	}

	public List<MetadataProxy> getMetadataProxies() {
		return metadataProxies;
	}

	public void setMetadataProxies(List<MetadataProxy> metadataProxies) {
		this.metadataProxies = metadataProxies;
	}

	public WrapperBean getWrapperBean() {
		return wrapperBean;
	}

	public void setWrapperBean(WrapperBean wrapperBean) {
		this.wrapperBean = wrapperBean;
	}
}
