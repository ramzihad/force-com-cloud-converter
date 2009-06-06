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
package com.modelmetrics.cloudconverter.importxls.services;

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
