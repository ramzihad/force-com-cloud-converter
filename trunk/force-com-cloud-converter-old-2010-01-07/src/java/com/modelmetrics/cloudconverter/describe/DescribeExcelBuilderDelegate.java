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
package com.modelmetrics.cloudconverter.describe;

import java.util.Collection;
import java.util.Set;

import ognl.Ognl;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.PicklistEntry;

public class DescribeExcelBuilderDelegate {

	public void handleBuild(Collection<DisplayableFieldMetadataBean> metadata, ExcelSupport excelSupport, HSSFWorkbook workbook, String sheetName) {
		
		excelSupport.addSheet(sheetName);
		
		
		
		HSSFRow row = excelSupport.addRow();


		Collection<SobjectFieldPropertyBean> beans = SobjectFieldPropertyBean.getFieldBeans();
		
		int i = 0;
		
		for (SobjectFieldPropertyBean current : beans) {
			excelSupport.decorateRowWithCell(i, row, current.getLabel());
			i++;
		}
		
		for (DisplayableFieldMetadataBean current : metadata) {
			i = 0;
			row = excelSupport.addRow();
			for (DisplayableSobjectFieldPropertyBean property : current.getProperties()) {
				if (property.isMultiline()) {
					excelSupport.decorateRowWithMultilineTextCell(i, row, this.getValues(property.getMultilineValue()));
				} else {
					excelSupport.decorateRowWithCell(i, row, property.getValue());
				}
				i++;
			}
		}

		excelSupport.setColumnWidthAuto(i);

	}
	
	private String getValues(String[] target) {

		StringBuffer ret = new StringBuffer();

		if (target != null) {
			for (int i = 0; i < target.length; i++) {
				if (ret.length() > 0) {
					ret.append(", ");
				}
				ret.append(target[i]);
			}
		}

		return ret.toString();
	}
}
