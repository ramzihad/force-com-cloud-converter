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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import jxl.BooleanCell;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.GenericValidator;

public class ExcelFileParserServiceImpl implements ExcelFileParserService {

	private static final Log log = LogFactory.getLog(ExcelFileParserServiceImpl.class);

	/**
	 * Parses an XLS file into a WrapperBean
	 * 
	 * @param file
	 * @return WrapperBean
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public List<ExcelWorksheetWrapperBean> parseXLS(File file)
			throws ParseException {

		// keeps date fields real.
		TimeZone.setDefault(TimeZone.getTimeZone("-0"));

		List<ExcelWorksheetWrapperBean> wrapperBeans = new ArrayList<ExcelWorksheetWrapperBean>();

		try {

			Workbook workbook;

			workbook = Workbook.getWorkbook(file);

			Sheet[] sheets = workbook.getSheets();
			for (Sheet sheet : sheets) {
				ExcelWorksheetWrapperBean bean = new ExcelWorksheetWrapperBean();

				bean
						.setSheetName(StringUtils.applyConstraints(sheet
								.getName()));

				int totalRows = sheet.getRows();
				for (int i = 0; i < totalRows; i++) {
					Cell[] cells = sheet.getRow(i);

					List<Object> list = new ArrayList<Object>();
					for (int j = 0; j < cells.length; j++) {

						Cell c = cells[j];

						// log.debug("cell format is: (i,j) (" + i + ", " + j +
						// "):
						// " + c.getCellFormat().getFormat().getFormatString());

						String value = c.getContents();
						if (i == 0) {
							// parse column names
							bean.getNames().add(
									StringUtils.applyConstraints(value));
							bean.getLabels().add(value);
						}
						if (i == 1) {
							// parse data types
							CellType type = c.getType();

							if (type.equals(CellType.DATE)
									|| type.equals(CellType.DATE_FORMULA)) {
								if (value.contains(":")) {
									bean.getTypes().add(Constants.DATETIME);
								} else {
									bean.getTypes().add(Constants.DATE);
								}
							} else if (type.equals(CellType.BOOLEAN)
									|| type.equals(CellType.BOOLEAN_FORMULA)) {

								bean.getTypes().add(Constants.CHECKBOX);
							} else if (type.equals(CellType.LABEL)
									|| type.equals(CellType.STRING_FORMULA)) {

								if (GenericValidator.isEmail(value)) {
									bean.getTypes().add(Constants.EMAIL);
								} else if (StringUtils.isPhoneNumber(value)) {
									bean.getTypes().add(Constants.PHONE_NUMBER);
								} else if (StringUtils.isURL(value)) {
									bean.getTypes().add(Constants.URL);
								} else {
									bean.getTypes().add(Constants.TEXT);
								}
							} else if (type.equals(CellType.NUMBER)
									|| type.equals(CellType.NUMBER_FORMULA)) {
								log.debug("Number: "
										+ value
										+ " : format : "
										+ c.getCellFormat().getFormat()
												.getFormatString());
								if (value.contains("%")) {
									bean.getTypes().add(Constants.PERCENTAGE);
								} else if (value.contains("$")) {
									bean.getTypes().add(Constants.CURRENCY);
								} else if (value.contains(",")
										|| value.contains(".")) {
									bean.getTypes().add(Constants.DOUBLE);
								} else {
									bean.getTypes().add(Constants.INT);
								}
							} else {
								// default.
								bean.getTypes().add(Constants.TEXT);
							}
						}
						if (i >= 1) {
							// parse data values
						
							CellType type = c.getType();

							if (type.equals(CellType.BOOLEAN)
									|| type.equals(CellType.BOOLEAN_FORMULA)) {
								list.add(((BooleanCell) c).getValue());
							} else if (type.equals(CellType.DATE)
									|| type.equals(CellType.DATE_FORMULA)) {

								Date aux = ((DateCell) c).getDate();
								list.add(aux);

								// }
							} else if (type.equals(CellType.LABEL)
									|| type.equals(CellType.STRING_FORMULA)) {

								list.add(value);
							} else if (type.equals(CellType.EMPTY)) {

								list.add(null);
							} else if (type.equals(CellType.NUMBER)
									|| type.equals(CellType.NUMBER_FORMULA)) {
								if (value.contains("%")) {
									// otherwise "percentages" show up in SFDC
									// as
									// 0.78 when it should be 78%.
									list.add(((NumberCell) c).getValue() * 100);
								} else {
									list.add(((NumberCell) c).getValue());
								}
							}
							if (i == 1) {
								bean.getExamples().add(value);
							}
						}

					}
					if (i >= 1) {
						/*
						 * RSC 2009-06-02 Check to be sure there is data in a list
						 */
						boolean notEmpty = false;
						for (Object o: list) {
							if (o != null && o.toString().trim().length() != 0) {
								notEmpty = true;
								break;
							}
						}
						if (!notEmpty) {
							throw new RuntimeException("Found an empty row.  Your spreadsheet should not contain an empty row. Check sheet " + sheet.getName() + ", row " + (i+1) + ".");
						}
						bean.getData().add(list);
						bean.setOverride(Boolean.FALSE);
					}
				}
				wrapperBeans.add(bean);

			}

		} catch (BiffException e) {
			throw new ParseException("Could not read file");
		} catch (IOException e) {
			throw new ParseException("Input/Output error");
		} catch (IndexOutOfBoundsException e) {
			throw new ParseException("Columns and data do not match");
		} catch (NullPointerException e) {
			throw new ParseException("A reference in the file has a null value");
		}

		return wrapperBeans;
	}
}
