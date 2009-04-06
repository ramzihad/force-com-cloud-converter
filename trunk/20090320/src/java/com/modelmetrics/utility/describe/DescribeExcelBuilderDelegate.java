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
