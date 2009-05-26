package com.modelmetrics.cloudconverter.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.mmimport.services.ExcelWorksheetWrapperBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;

public class PicklistProviderExcelBeanImpl implements PicklistProvider {

	private Log log = LogFactory.getLog(PicklistProviderExcelBeanImpl.class);

	private MetadataProxy metadataProxy;
	private ExcelWorksheetWrapperBean excelWorksheetWrapperBean;
	
	public PicklistProviderExcelBeanImpl(MetadataProxy metadataProxy, ExcelWorksheetWrapperBean excelWorksheetWrapperBean) {
		this.metadataProxy = metadataProxy;
	}
	
	public List<String> getPicklistValues() throws Exception {
		
		List<String> ret = new ArrayList<String>();
		
		List<List<Object>> data = excelWorksheetWrapperBean.getData();
		
		for (List<Object> current : data) {
			ret.add(current.get(this.metadataProxy.getIndex()).toString());
		}
		
		return ret;
		
	}

}
