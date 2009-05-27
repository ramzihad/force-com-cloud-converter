package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.modelmetrics.cloudconverter.util.MetadataProxyCollectionBuilder;

/**
 * Enables better handling of multiple worksheet excel files.
 * 
 * @author reidcarlberg
 * @since 2009-05-24
 */

public class CloudConverterObjectBuilder {

	public List<CloudConverterObject> buildFromExcelFile(Collection<ExcelWorksheetWrapperBean> workbookBeans) throws Exception {
		
		List<CloudConverterObject> ret = new ArrayList<CloudConverterObject>();
		
		for (ExcelWorksheetWrapperBean currentWorksheet: workbookBeans) {
			
			CloudConverterObject current = new CloudConverterObject();
			
			current.setOriginalData(currentWorksheet);
			
			current.setObjectName(currentWorksheet.getSheetName());
			
			current.setObjectLabel(currentWorksheet.getSheetName());
			
			if (currentWorksheet.getSheetName().endsWith("s")) {
				current.setObjectPlural(currentWorksheet.getSheetName());
			} else {
				current.setObjectPlural(currentWorksheet.getSheetName() + "s");
			}
			
			List<MetadataProxy> metadataProxies = new MetadataProxyCollectionBuilder()
					.build(currentWorksheet);

			current.setMetadataProxies(metadataProxies);
			
			ret.add(current);
		}
		
		
		return ret;
		
	}
	

}
