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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
		this.excelWorksheetWrapperBean = excelWorksheetWrapperBean;
	}
	
	public List<String> getPicklistValues() throws Exception {
		
		Set<String> uniques = new TreeSet<String>();
		
		List<List<Object>> data = excelWorksheetWrapperBean.getData();
		
		for (List<Object> current : data) {
			if (this.metadataProxy.getIndex() == current.size() ) {
				log.info("too big.");
			}
			uniques.add(current.get(this.metadataProxy.getIndex()).toString());
		}
		
		List<String> ret = new ArrayList<String>();
		
		ret.addAll(uniques);
		
		return ret;
		
	}

}
