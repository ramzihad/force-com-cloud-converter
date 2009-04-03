package com.modelmetrics.cloudconverter.mmimport.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.GenericValidator;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.JodaTimePermission;
import org.joda.time.LocalDateTime;


public class FileServiceImpl implements FileService {

	private static final Log log = LogFactory.getLog(FileServiceImpl.class);

	/**
	 * Parses an XLS file into a WrapperBean
	 * 
	 * @param file
	 * @return WrapperBean
	 */
	@SuppressWarnings("unchecked")
	public WrapperBean parseXLS(File file) throws ParseException {

		//keeps date fields real.
		TimeZone.setDefault(TimeZone.getTimeZone("-0"));
		
		// DateFormat finalTimeFormat = new SimpleDateFormat(
		// "yyyy-MM-dd'T'HH:mm:ssZ");
		// DateFormat finalCommonFormat = new SimpleDateFormat("yyyy-MM-dd");

		WrapperBean bean = new WrapperBean();
		bean.setNames(new ArrayList<String>());
		bean.setTypes(new ArrayList<String>());
		bean.setObjects(new ArrayList<List<Object>>());

		
		try {

			Workbook workbook = Workbook.getWorkbook(file);

			
			Sheet sheet = workbook.getSheet(0);

			bean.setSheetName(StringUtils.applyConstraints(sheet.getName()));

			int totalRows = sheet.getRows();
			for (int i = 0; i < totalRows; i++) {
				Cell[] cells = sheet.getRow(i);

				List<Object> list = new ArrayList<Object>();
				for (int j = 0; j < cells.length; j++) {

					Cell c = cells[j];

					// log.debug("cell format is: (i,j) (" + i + ", " + j + "):
					// " + c.getCellFormat().getFormat().getFormatString());

					String value = c.getContents();
					if (i == 0) {
						// parse column names
						bean.getNames()
								.add(StringUtils.applyConstraints(value));
					}
					if (i == 1) {
						// parse data types
						CellType type = c.getType();

						if (type.equals(CellType.DATE)) {
							if (value.contains(":")) {
								bean.getTypes().add(Constants.DATETIME);
							} else {
								bean.getTypes().add(Constants.DATE);
							}
						} else if (type.equals(CellType.LABEL)) {

							if (GenericValidator.isEmail(value)) {
								bean.getTypes().add(Constants.EMAIL);
							} else if (StringUtils.isPhoneNumber(value)) {
								bean.getTypes().add(Constants.PHONE_NUMBER);
							} else if (StringUtils.isURL(value)) {
								bean.getTypes().add(Constants.URL);
							} else {
								bean.getTypes().add(Constants.STRING);
							}
						} else if (type.equals(CellType.NUMBER)) {
							log.debug("Number: " + value + " : format : " + c.getCellFormat().getFormat().getFormatString());
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
						}

					}
					if (i >= 1) {
						// parse data values
						CellType type = c.getType();
						if (type.equals(CellType.DATE)) {
							// parse date value
							// if (value.contains(":")) {
							// Date aux = ((DateCell) c).getDate();
							//
							// list.add(aux);
							// } else {
							Date aux = ((DateCell) c).getDate();
							// String date = finalCommonFormat.format(aux);
							
							list.add(aux);

							// }
						} else if (type.equals(CellType.LABEL)) {
							// parse string value
							list.add(value);
						} else if (type.equals(CellType.EMPTY)) {
							// parse string value
							list.add(null);
						}  
						else if (type.equals(CellType.NUMBER)) {
							// parse numeric value
							//							
							// if (value.contains("%")) {
							// // value = value.replace("%", "");
							// // value = "0." + value;
							// list.add(((NumberCell) c).getValue());
							// list.add(value);
							// } else if (value.contains(",")) {
							// value = value.replace(",", ".");
							// list.add(value);
							// } else {
							if (value.contains("%")) {
								//otherwise "percentages" show up in SFDC as 0.78 when it should be 78%.
								list.add(((NumberCell) c).getValue() * 100);
							} else {
								list.add(((NumberCell) c).getValue());
							}
							// }
						}
					}
				}
				if (i >= 1) {
					bean.getObjects().add(list);
				}
			}

		} catch (Exception e) {
			throw new ParseException(e);
		}

		return bean;
	}
}
