package com.modelmetrics.utility.describe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LayoutsSummary {

	private Collection<String> headers = new ArrayList<String>();
	
	private Collection<LayoutsFieldVOV2> rows;
	
	private String recordTypes;
	
	private Map<String, Collection<String>> fieldNamesToRecordTypeNames = new HashMap<String, Collection<String>>();

	public Collection<String> getHeaders() {
		return headers;
	}

	public void setHeaders(Collection<String> headers) {
		this.headers = headers;
	}

	public Collection<LayoutsFieldVOV2> getRows() {
		return rows;
	}

	public void setRows(Collection<LayoutsFieldVOV2> rows) {
		this.rows = rows;
	}

	public String getRecordTypes() {
		return recordTypes;
	}

	public void setRecordTypes(String recordTypes) {
		this.recordTypes = recordTypes;
	}

	public Map<String, Collection<String>> getFieldNamesToRecordTypeNames() {
		return fieldNamesToRecordTypeNames;
	}

	public void setFieldNamesToRecordTypeNames(
			Map<String, Collection<String>> fieldNamesToRecordTypeNames) {
		this.fieldNamesToRecordTypeNames = fieldNamesToRecordTypeNames;
	}
	
}
