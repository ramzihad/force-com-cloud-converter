package com.modelmetrics.cloudconverter.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.importxls.svcs.ExcelWorksheetWrapperBean;
import com.modelmetrics.cloudconverter.util.MetadataProxy;

public class PicklistProviderExcelBeanImpl implements PicklistProvider {

	private Log log = LogFactory.getLog(PicklistProviderExcelBeanImpl.class);

	private MetadataProxy metadataProxy;
	private ExcelWorksheetWrapperBean excelWorksheetWrapperBean;

	public PicklistProviderExcelBeanImpl(MetadataProxy metadataProxy,
			ExcelWorksheetWrapperBean excelWorksheetWrapperBean) {
		this.metadataProxy = metadataProxy;
		this.excelWorksheetWrapperBean = excelWorksheetWrapperBean;
	}

	public List<String> getPicklistValues() throws Exception {

		Set<String> uniques = new TreeSet<String>();

		List<List<Object>> data = excelWorksheetWrapperBean.getData();

		for (List<Object> current : data) {
			if (current != null && metadataProxy != null) {
				if (this.metadataProxy.getIndex() == current.size()) {
					log.info("too big.");
				}
				if (current.get(this.metadataProxy.getIndex()) != null) {
					uniques.add(current.get(this.metadataProxy.getIndex())
							.toString());
				}
			} else {
				//RSC 2009-06-02
				throw new RuntimeException("Invalid picklist data -- be sure to follow your Excel file formatting tip and try again.");
			}
		}

		List<String> ret = new ArrayList<String>();

		ret.addAll(uniques);

		return ret;

	}

}
