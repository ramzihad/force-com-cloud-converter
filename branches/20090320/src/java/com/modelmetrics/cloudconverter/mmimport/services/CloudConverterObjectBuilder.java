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
		
		for (ExcelWorksheetWrapperBean singleWorksheet: workbookBeans) {
			
			CloudConverterObject current = new CloudConverterObject();
			
			current.setOriginalData(singleWorksheet);
			
			current.setObjectName(singleWorksheet.getSheetName());
			
			List<MetadataProxy> metadataProxies = new MetadataProxyCollectionBuilder()
					.build(singleWorksheet);

			current.setMetadataProxies(metadataProxies);
			
			ret.add(current);
		}
		
		
		return ret;
		
	}
	

}
