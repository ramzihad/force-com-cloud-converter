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

package com.modelmetrics.common.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 2006-03-10 RSC Helper class for all of the excel stuff we need to do.
 * 
 * @author Reid
 */
public class ExcelSupport {

	private HSSFWorkbook workbook;

	private HSSFSheet activeSheet;

	public HSSFCellStyle numericCellStyle;

	public HSSFCellStyle percentageCellStyle;

	public HSSFCellStyle decimalCellStyle;

	public HSSFDataFormat numericData;

	private HSSFCellStyle dollarStyle;

	private HSSFCellStyle headlineStyle;
	
	private HSSFCellStyle boldStyle;

	private HSSFCellStyle multiLineTextStyle;

	private HSSFCellStyle genericStyle;

	private HSSFRow currentRow;

	private int nextRowId;

	private int cellCount;
	
	private HSSFFont boldFont;

	public ExcelSupport() {
		super();
		workbook = new HSSFWorkbook();

		numericCellStyle = workbook.createCellStyle();
		numericData = workbook.createDataFormat();
		numericCellStyle.setDataFormat(numericData.getFormat("#,##0.00"));

		percentageCellStyle = workbook.createCellStyle();
		percentageCellStyle.setDataFormat((short) 4);

		decimalCellStyle = workbook.createCellStyle();
		decimalCellStyle.setDataFormat(workbook.createDataFormat().getFormat(
				"#,##0.0#####"));

		multiLineTextStyle = workbook.createCellStyle();
		multiLineTextStyle.setWrapText(true);
		multiLineTextStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);

		genericStyle = workbook.createCellStyle();
		genericStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);

		dollarStyle = workbook.createCellStyle();
		dollarStyle.setDataFormat((short) 8);

		headlineStyle = workbook.createCellStyle();
		HSSFFont headlineFont = workbook.createFont();

		// set font 1 to 12 point type
		headlineFont.setFontHeightInPoints((short) 24);

		// make it bold
		// arial is the default font
		headlineFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headlineStyle.setFont(headlineFont);
		
		boldFont = workbook.createFont();
		boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		boldStyle = workbook.createCellStyle();
		boldStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		boldStyle.setFont(boldFont);

	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public HSSFSheet getSheet() {
		if (activeSheet == null)
			addSheet("Sheet1"); // default name

		return activeSheet;
	}

	public void addSheet(String name) {
		if (name.length() > 30) {
			name = name.substring(0, 25);
		}

		boolean found = false;

		String tempName = name.replace("/", "-");
		int i = 0;
		while (true) {

			if (i > 1000) {
				break;
			}

			for (int j = 0; j < workbook.getNumberOfSheets(); j++) {
				found = workbook.getSheetName(j).equalsIgnoreCase(tempName);
				if (found) {
					break;
				}
			}

			if (!found) {
				break;
			} else {
				i++;
				tempName = name + " (" + i + ")";
			}

		}

		activeSheet = workbook.createSheet(tempName);

		nextRowId = 0;
	}

	public HSSFRow addRow() {

		HSSFRow ret = this.addRow(nextRowId);
		nextRowId++;
		return ret;
	}

	public HSSFRow addRow(int i) {
		return this.addRow((short) i);
	}

	public HSSFRow addRow(short i) {
		return this.addRow(i, this.getSheet());
	}

	public HSSFRow addRow(short i, HSSFSheet sheet) {
		return sheet.createRow(i);
	}

	public HSSFCell getCell(int cellId, HSSFRow row) {
		HSSFCell ret = row.createCell((short) cellId);
		return ret;
	}

	public void decorateRowWithCell(int cellId, HSSFRow row, Object value) {
		this.decorateRowWithCell((short) cellId, row, value, null);
	}

	public void decorateRowWithCell(short cellId, HSSFRow row, Object value,
			HSSFCellStyle cellStyle) {

		HSSFCell cell = row.createCell(cellId);
		if (value == null) {

		} else if (value instanceof Double) {
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(((Double) value).doubleValue());
		} else if (value instanceof Integer) {
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(((Integer) value).intValue());
		} else {
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(new HSSFRichTextString(value.toString()));
		}

		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		} else {
			cell.setCellStyle(genericStyle);
		}

	}

	public void decorateRowWithHeadlineCell(int cellId, HSSFRow row,
			Object value) {
		this.decorateRowWithCell((short) cellId, row, value, headlineStyle);
	}
	
	public void decorateRowWithBoldCell(int cellId, HSSFRow row,
			Object value) {
		this.decorateRowWithCell((short) cellId, row, value, boldStyle);
	}

	public void decorateRowWithBoldCellBlueBackground(int cellId, HSSFRow row,
			Object value) 
	{
		HSSFCellStyle boldStyleBlueBground = workbook.createCellStyle();
		boldStyleBlueBground.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		boldStyleBlueBground.setFont(boldFont);
		boldStyleBlueBground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND );
		boldStyleBlueBground.setFillForegroundColor(new HSSFColor.LIGHT_TURQUOISE().getIndex());
		boldStyleBlueBground.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		boldStyleBlueBground.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		boldStyleBlueBground.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		boldStyleBlueBground.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);

		this.decorateRowWithCell((short) cellId, row, value, boldStyleBlueBground);
	}
	
	public void decorateRowWithBoldCellYellowBackground(int cellId, HSSFRow row,
			Object value) 
	{
		HSSFCellStyle boldStyleBlueBground = workbook.createCellStyle();
		boldStyleBlueBground.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		boldStyleBlueBground.setFont(boldFont);
		boldStyleBlueBground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND );
		boldStyleBlueBground.setFillForegroundColor(new HSSFColor.LIGHT_YELLOW().getIndex());
//		boldStyleBlueBground.setBorderBottom(HSSFCellStyle.BORDER_HAIR);
//		boldStyleBlueBground.setBorderLeft(HSSFCellStyle.BORDER_HAIR);
//		boldStyleBlueBground.setBorderRight(HSSFCellStyle.BORDER_HAIR);
//		boldStyleBlueBground.setBorderTop(HSSFCellStyle.BORDER_HAIR);

		this.decorateRowWithCell((short) cellId, row, value, boldStyleBlueBground);
	}



	public void decorateRowWithMultilineTextCell(int cellId, HSSFRow row,
			Object value) {
		this
				.decorateRowWithCell((short) cellId, row, value,
						multiLineTextStyle);
	}

	public void decorateRowWithNumericCell(int cellId, HSSFRow row, int value) {
		this.decorateRowWithCell((short) cellId, row, new Integer(value),
				numericCellStyle);
	}

	public void decorateRowWithNumericCell(int cellId, HSSFRow row, double value) {
		this.decorateRowWithCell((short) cellId, row, new Double(value),
				numericCellStyle);
	}

	public void decorateRowWithPercentageCell(int cellId, HSSFRow row,
			Object value) {
		this.decorateRowWithCell((short) cellId, row, value,
				percentageCellStyle);
	}

	public void decorateRowWithDecimalCell(int cellId, HSSFRow row, double value) {
		this.decorateRowWithCell((short) cellId, row, new Double(value),
				decimalCellStyle);
	}

	public void decorateRowWithDecimalCell(int cellId, HSSFRow row, Object value) {
		this.decorateRowWithCell((short) cellId, row, value, decimalCellStyle);
	}

	/**
	 * @return Returns the cellCount.
	 */
	public int getCellCount() {
		return cellCount;
	}

	/**
	 * @return Returns the currentRow.
	 */
	public HSSFRow getCurrentRow() {
		return currentRow;
	}

	public void setColumnWidthAuto(int qty) {
		for (int col = 0; col < qty; col++) {
			activeSheet.autoSizeColumn((short) col);
		}
	}

}
