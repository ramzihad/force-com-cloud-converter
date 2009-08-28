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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.modelmetrics.common.poi.ExcelSupport;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.PicklistEntry;

public class DescribeExcelBuilderDelegateTemplateImpl implements DescribeExcelBuilderDelegate {

	private SalesforceSession salesforceSession;
	private ExcelSupport excelSupport;
	private HSSFWorkbook workbook;
	
	public DescribeExcelBuilderDelegateTemplateImpl (ExcelSupport excelSupport, HSSFWorkbook workbook, SalesforceSession salesforceSession) {
		this.excelSupport = excelSupport;
		this.workbook = workbook;
		this.salesforceSession = salesforceSession;
	}
	
	private Collection<String> requiredFields = new ArrayList<String>();
	
	public void handleBuild(Collection<DisplayableFieldMetadataBean> metadata, String sheetName) throws Exception  {
		
		LayoutsBuilderV2 builder = new LayoutsBuilderV2();
		LayoutsSummary summary = builder.execute(salesforceSession, sheetName);

		Map<String, Collection<String>> fieldNamesToRecordTypeNames =  summary.getFieldNamesToRecordTypeNames();
		excelSupport.addSheet(sheetName);
		
		addRequiredFields(summary);
		
		HSSFRow fieldNameRow = excelSupport.addRow();
		excelSupport.decorateRowWithBoldCellBlueBackground(0, fieldNameRow, "FIELD NAME");
		
		HSSFRow fieldTypeRow = excelSupport.addRow();
		excelSupport.decorateRowWithBoldCellBlueBackground(0, fieldTypeRow, "FIELD TYPE");
		
//		HSSFRow requiredRow = excelSupport.addRow();
//		excelSupport.decorateRowWithBoldCellBlueBackground(0, requiredRow, "REQUIRED?");
		
		HSSFRow dependenciesRow = excelSupport.addRow();
		excelSupport.decorateRowWithBoldCellBlueBackground(0, dependenciesRow, "DEPENDENCIES");


		for(int i=0; i < 7; i++)
			excelSupport.addRow();
		
		HSSFRow picklistValuesRow = excelSupport.addRow();
		excelSupport.decorateRowWithBoldCellBlueBackground(0, picklistValuesRow, "PICKLIST VALUES");

		HSSFRow associatedRecordTypesRow = excelSupport.addRow();
		excelSupport.decorateRowWithBoldCellBlueBackground(0, associatedRecordTypesRow, "ASSOCIATED RECORD TYPES");
		
		int column = 1;
		

		for (DisplayableFieldMetadataBean current: metadata) 
		{
			Field element = current.getField();
			
			if (!element.getType().getValue().equals("id"))
			{	
				if(!element.getLabel().equals("Created By ID") && !element.getLabel().equals("Created Date") && !element.getLabel().equals("Last Modified By ID") && !element.getLabel().equals("Last Modified Date") && !element.getLabel().equals("System Modstamp") && !element.getLabel().equals("Last Activity") && !element.getLabel().equals("Master Record ID") && !element.isCalculated())
				{
					if(requiredFields.contains(element.getName()) || element.getLabel().equals("Owner ID"))
						excelSupport.decorateRowWithBoldCellYellowBackground(column, fieldNameRow, element.getLabel());
					
					else
						excelSupport.decorateRowWithBoldCell(column, fieldNameRow, element.getLabel());
					
					String dataType = element.getType().getValue();
					
					if(dataType.equals("string"))
						dataType = "Text";
					
					String type;
					
					if(dataType.equals("currency") || dataType.equals("double"))
						type = "Number(" + (element.getPrecision() - element.getScale())  + ", " + element.getScale() + ")";
					else
						type = dataType + "(" + element.getLength() + ")";
					
					if (element.getExternalId() != null && element.getExternalId().booleanValue())
						type += " (ext id)";
					
					if(type.equals("boolean(0)"))
						type = "Checkbox";
					
					if(type.equals("date(0)"))
						type = "Date";
					
					if(type.contains("picklist("))
						type = "Picklist";
	
					excelSupport.decorateRowWithCell(column, fieldTypeRow, type);
					
	//				if(requiredFields.contains(element.getName()) || element.getLabel().equals("Owner ID"))
	//					excelSupport.decorateRowWithCell(column, requiredRow, "true");
						
					excelSupport.decorateRowWithCell(column, dependenciesRow, element.getControllerName());
					
					excelSupport.decorateRowWithMultilineTextCell(column, picklistValuesRow, this.getValues(element.getPicklistValues()));
					
					if(type.equals("Checkbox"))
						excelSupport.decorateRowWithMultilineTextCell(column, picklistValuesRow, "True\nFalse");					
					
					
					if(element.getLabel().equals("Record Type ID"))
					{
						System.out.println("RecTypes" + summary.getRecordTypes());
						
						excelSupport.decorateRowWithMultilineTextCell(column, picklistValuesRow, summary.getRecordTypes());					
					}
					
					Collection<String> recordTypes = fieldNamesToRecordTypeNames.get(element.getName());
					String recordTypeNames = "";
					
					if(recordTypes != null)
					{
						for (Iterator iterator = recordTypes.iterator(); iterator.hasNext();) 
							recordTypeNames = recordTypeNames + (String) iterator.next() + "\n";
						
						excelSupport.decorateRowWithMultilineTextCell(column, associatedRecordTypesRow, recordTypeNames);
					}
					
//					if(type.equals("Record Type ID"))
					//Set<Field> fields, LayoutsSummary summary, ExcelSupport excelSupport, HSSFWorkbook workbook, String sheetName) {
					
					column++;
				}
			}
			excelSupport.setColumnWidthAuto(column);
		}
			
	}
	
//	public void handleBuild(Set<Field> fields, LayoutsSummary summary, ExcelSupport excelSupport, HSSFWorkbook workbook, String sheetName) {
//		
//
////			row = excelSupport.addRow();
//			
////			excelSupport.decorateRowWithCell(1, row, element.getName());
////			
////			String type = element.getType().getValue();
////			if (element.getExternalId() != null && element.getExternalId().booleanValue()) {
////				type += " (ext id)";
////			}
////			excelSupport.decorateRowWithCell(2, row, type);
////			
////			excelSupport.decorateRowWithCell(3, row, element.getLength());
////			excelSupport.decorateRowWithCell(4, row, element.getPrecision());
////			excelSupport.decorateRowWithCell(5, row, element.getScale());
////			excelSupport.decorateRowWithCell(6, row, element.getDigits());
//////			excelSupport.decorateRowWithCell(7, row, this.getValues(element
//////					.getPicklistValues()));
////			excelSupport.decorateRowWithMultilineTextCell(7, row, this.getValues(element
////					.getPicklistValues()));
////			
////			excelSupport.decorateRowWithMultilineTextCell(8, row, element
////					.getCalculatedFormula());
////			excelSupport.decorateRowWithMultilineTextCell(9, row, element
////					.getDefaultValueFormula());
////			excelSupport.decorateRowWithMultilineTextCell(10, row, this.getValues(element
////					.getReferenceTo()));
////			excelSupport.decorateRowWithCell(11, row, element
////					.getControllerName());
//
//		}
//
//		excelSupport.setColumnWidthAuto(column);
//
//	}
	
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
	
	public void addRequiredFields(LayoutsSummary summary)
	{
		for (Iterator iter = summary.getRows().iterator(); iter.hasNext();) 
		{
			LayoutsFieldVOV2 element = (LayoutsFieldVOV2) iter.next();

			for (Iterator iterator = element.getLayouts().iterator(); iterator.hasNext();) 
			{
				FieldItemVO layoutElement = (FieldItemVO) iterator.next();
				if (layoutElement.isRequired()) 
				{
					requiredFields.add(element.getField().getName());
					break;
				}
			}
		}
	}
}
