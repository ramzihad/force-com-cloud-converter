package com.modelmetrics.cloudconverter.mmimport.actions;

public class PicklistInfo {

	private String fieldName;
	
	private String sourceSql;

	public PicklistInfo( ) {
		super();
	}
	public PicklistInfo(String fieldName, String sourceSql) {
		super();
		this.fieldName = fieldName;
		this.sourceSql = sourceSql;
		
	}
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getSourceSql() {
		return sourceSql;
	}

	public void setSourceSql(String sourceSql) {
		this.sourceSql = sourceSql;
	}
	
}
