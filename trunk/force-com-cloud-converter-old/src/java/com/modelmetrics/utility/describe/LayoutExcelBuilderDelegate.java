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
