package com.mmimport.services.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.GenericValidator;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

import com.mmimport.beans.WrapperBean;
import com.mmimport.exceptions.ParseException;
import com.mmimport.services.FileService;
import com.mmimport.utils.Constants;
import com.mmimport.utils.StringUtils;

public class POIService implements FileService {

	private static final Log log = LogFactory.getLog(POIService.class);
	
	/**
	 * Parses an XLS file into a WrapperBean
	 * @param file
	 * @return WrapperBean
	 */
	@SuppressWarnings("unchecked")
	public WrapperBean parseXLS(File file) throws ParseException {

		DateFormat finalTimeFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ssZ");
		DateFormat finalCommonFormat = new SimpleDateFormat("yyyy-MM-dd");

		WrapperBean bean = new WrapperBean();
		bean.setNames(new ArrayList<String>());
		bean.setTypes(new ArrayList<String>());
		bean.setObjects(new ArrayList<List<String>>());

		try {

			Workbook workbook = Workbook.getWorkbook(file);

			Sheet sheet = workbook.getSheet(0);

			int totalRows = sheet.getRows();
			for (int i = 0; i < totalRows; i++) {
				Cell[] cells = sheet.getRow(i);

				List<String> list = new ArrayList<String>();
				for (int j = 0; j < cells.length; j++) {

					Cell c = cells[j];
					
//					log.debug("cell format is: (i,j) (" + i + ", " + j + "): " + c.getCellFormat().getFormat().getFormatString());
					
					String value = c.getContents();
					if (i == 0) {
						// parse column names
						bean.getNames().add(value);
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
							} else if (value.contains("www")) {
								bean.getTypes().add(Constants.URL);
							} else {
								bean.getTypes().add(Constants.STRING);
							}
						} else if (type.equals(CellType.NUMBER)) {
							
							if (value.contains("%")) {
								bean.getTypes().add(Constants.FLOAT);
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
							if (value.contains(":")) {
								Date aux = ((DateCell) c).getDate();

								list.add(finalTimeFormat.format(aux));
							} else {
								Date aux = ((DateCell) c).getDate();
								String date = finalCommonFormat.format(aux);
								list.add(date);
							}
						} else if (type.equals(CellType.LABEL)) {
							// parse string value
							list.add(value);
						} else if (type.equals(CellType.NUMBER)) {
							// parse numeric value
							if (value.contains("%")) {
								value = value.replace("%", "");
								value = "0." + value;
								list.add(value);
							} else if (value.contains(",")) {
								value = value.replace(",", ".");
								list.add(value);
							} else {
								list.add(value);
							}
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
