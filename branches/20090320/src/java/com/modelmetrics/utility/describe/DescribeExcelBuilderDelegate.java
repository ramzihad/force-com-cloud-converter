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
package com.modelmetrics.utility.describe;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.PicklistEntry;

public class DescribeExcelBuilderDelegate {

	public void handleBuild(Set<Field> fields, ExcelSupport excelSupport, HSSFWorkbook workbook, String sheetName) {
		
		excelSupport.addSheet(sheetName);
		
		
		
		HSSFRow row = excelSupport.addRow();

		excelSupport.decorateRowWithCell(0, row, "Label");
		excelSupport.decorateRowWithCell(1, row, "Name");
		excelSupport.decorateRowWithCell(2, row, "Type");
		excelSupport.decorateRowWithCell(3, row, "Len");
		excelSupport.decorateRowWithCell(4, row, "Precision");
		excelSupport.decorateRowWithCell(5, row, "Scale");
		excelSupport.decorateRowWithCell(6, row, "Digits");
		excelSupport.decorateRowWithCell(7, row, "Values");
		excelSupport.decorateRowWithCell(8, row, "Calc Formula");
		excelSupport.decorateRowWithCell(9, row, "Default Formula");
		excelSupport.decorateRowWithCell(10, row, "Reference");
		excelSupport.decorateRowWithCell(11, row, "Controller");
		excelSupport.decorateRowWithCell(12, row, "Unique");

		for (Iterator iter = fields.iterator(); iter.hasNext();) {
			Field element = (Field) iter.next();

			row = excelSupport.addRow();
			excelSupport.decorateRowWithCell(0, row, element.getLabel());
			excelSupport.decorateRowWithCell(1, row, element.getName());
			
			String type = element.getType().getValue();
			if (element.getExternalId() != null && element.getExternalId().booleanValue()) {
				type += " (ext id)";
			}
			excelSupport.decorateRowWithCell(2, row, type);
			
			excelSupport.decorateRowWithCell(3, row, element.getLength());
			excelSupport.decorateRowWithCell(4, row, element.getPrecision());
			excelSupport.decorateRowWithCell(5, row, element.getScale());
			excelSupport.decorateRowWithCell(6, row, element.getDigits());
//			excelSupport.decorateRowWithCell(7, row, this.getValues(element
//					.getPicklistValues()));
			excelSupport.decorateRowWithMultilineTextCell(7, row, this.getValues(element
					.getPicklistValues()));
			
			excelSupport.decorateRowWithMultilineTextCell(8, row, element
					.getCalculatedFormula());
			excelSupport.decorateRowWithMultilineTextCell(9, row, element
					.getDefaultValueFormula());
			excelSupport.decorateRowWithMultilineTextCell(10, row, this.getValues(element
					.getReferenceTo()));
			excelSupport.decorateRowWithCell(11, row, element
					.getControllerName());
			excelSupport.decorateRowWithCell(12, row, element
					.isUnique()==true?"Yes":"");

		}

		excelSupport.setColumnWidthAuto(12);

	}
	
	private String getValues(PicklistEntry[] target) {

		StringBuffer ret = new StringBuffer();

		if (target != null) {
			for (int i = 0; i < target.length; i++) {
				if (ret.length() > 0) {
					ret.append("\n");
				}
				ret.append(target[i].getValue());
			}
		}

		return ret.toString();
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
