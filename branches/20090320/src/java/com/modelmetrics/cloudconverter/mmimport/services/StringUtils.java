package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtils {

	public static final String URL_PREFIX_HTTP = "http:";

	public static final String URL_PREFIX_HTTPS = "https:";

	public static final char UNDERSCORE = '_';

	public static final String URL_PREFIX_WWW = "www";

	/**
	 * checks if a string matches a regular expresion for phones with format:
	 * (773) 870-5554
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean isPhoneNumber(String phone) {

		String expression = "^(\\([0-9]{3}\\)) [0-9]{3}-[0-9]{4}$";

		return phone.matches(expression);
	}

	/**
	 * checks if a String has a url format. Eg: www.google.com;
	 * http://google.com
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isURL(String url) {

		if (url.startsWith(URL_PREFIX_HTTP) || url.startsWith(URL_PREFIX_HTTPS)
				|| url.startsWith(URL_PREFIX_WWW)) {
			return true;
		}
		return false;
	}

	/**
	 * leave the input String with only these values:[_0-9A-Za-z]
	 * 
	 * @param name
	 * @return
	 */
	public static String applyConstraints(String name) {

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (Character.isDigit(ch) || Character.isLetter(ch)
					|| ch == UNDERSCORE) {
				buffer.append(ch);
			}
		}

		return buffer.toString();
	}
	
	public static List<ValueId> getUniques() {
		List<ValueId> types = new ArrayList<ValueId>();
		types.add(new ValueId("false","false"));
		types.add(new ValueId("true","true"));
		return types;
	}
	
	public static Map<Long, String> getOptions() {
		 Map<Long, String> optionsList = new HashMap<Long, String>();
		optionsList.put(Long.valueOf(0), "No");
		optionsList.put(Long.valueOf(1), "Yes");
		return optionsList;
	}

	/**
	 * returns a list with all field types
	 * 
	 * @return
	 */
	public static List<ValueId> getAllFieldTypes() {

		List<ValueId> types = new ArrayList<ValueId>();

		types.add(new ValueId(Constants.DATE,Constants.DATE));
		types.add(new ValueId(Constants.DATETIME,Constants.DATETIME));
		types.add(new ValueId(Constants.DOUBLE,Constants.DOUBLE));
		types.add(new ValueId(Constants.FLOAT,Constants.FLOAT));
		types.add(new ValueId(Constants.INT,Constants.INT));
		types.add(new ValueId(Constants.PERCENTAGE,Constants.PERCENTAGE));
		types.add(new ValueId(Constants.CURRENCY,Constants.CURRENCY));
		types.add(new ValueId(Constants.EMAIL,Constants.EMAIL));
		types.add(new ValueId(Constants.PHONE_NUMBER,Constants.PHONE_NUMBER));
		types.add(new ValueId(Constants.STRING,Constants.STRING));
		types.add(new ValueId(Constants.URL,Constants.URL));
		types.add(new ValueId(Constants.EXTERNAL_ID,Constants.EXTERNAL_ID));
		types.add(new ValueId(Constants.LOOKUP,Constants.LOOKUP));
		types.add(new ValueId(Constants.PICKUPLIST,Constants.PICKUPLIST));
		return types;
	}

}
