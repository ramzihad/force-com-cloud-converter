package com.modelmetrics.cloudconverter.engine;

import java.sql.Connection;

import com.modelmetrics.cloudconverter.mmimport.services.ExcelWorksheetWrapperBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;

public class PicklistProviderFactory {

	public PicklistProvider build(Connection connection, String sql) {
		return new PicklistProviderSqlImpl(connection, sql);
	}
	
	public PicklistProvider build(MetadataProxy metadataProxy, ExcelWorksheetWrapperBean excelWorksheetWrapperBean) {
		return new PicklistProviderExcelBeanImpl(metadataProxy, excelWorksheetWrapperBean);
	}
}
