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

import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;

public class LayoutExcelBuilderDelegate {

	public void handleBuild(Collection<LayoutsFieldVO> rows, Collection<String> recordTypes, Collection<String> layoutIds,
			ExcelSupport excelSupport, HSSFWorkbook workbook, String sheetName) {

		HSSFRow row = excelSupport.addRow();

		excelSupport.decorateRowWithCell(0, row, "Label");
		excelSupport.decorateRowWithCell(1, row, "Name");
		excelSupport.decorateRowWithCell(2, row, "Not Found");
		
		int col = 3;
		
		for (Iterator iter = recordTypes.iterator(); iter.hasNext();) {
			String element =  (String) iter.next();
			excelSupport.decorateRowWithCell(col, row, element);
			col++;
		}
		
		row = excelSupport.addRow();
		excelSupport.decorateRowWithCell(0, row, "Layout Ids");
		 col = 3;
		
		for (Iterator iter = layoutIds.iterator(); iter.hasNext();) {
			String element =  (String) iter.next();
			excelSupport.decorateRowWithCell(col, row, element);
			col++;
		}

		for (Iterator iter = rows.iterator(); iter.hasNext();) {
			LayoutsFieldVO element = (LayoutsFieldVO) iter.next();

			row = excelSupport.addRow();
			excelSupport.decorateRowWithCell(0, row, element.getLabel());
			excelSupport.decorateRowWithCell(1, row, element.getName());
			
			if (element.isNotFound()) {
				excelSupport.decorateRowWithCell(2, row, element.isNotFound());
			}
			
			col = 3;
			
			for (Iterator iterator = element.getPresent().iterator(); iterator.hasNext();) {
				Boolean present = (Boolean) iterator.next();
				if (present.booleanValue()) {
					excelSupport.decorateRowWithCell(col, row, present.booleanValue());
				}
				col++;
			}

		}

		excelSupport.setColumnWidthAuto(recordTypes.size() + 3);
	}

}
