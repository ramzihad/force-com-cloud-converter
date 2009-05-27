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
	


	/**
	 * returns a list with all field types
	 * 
	 * @return
	 */
	public static List<String> getAllFieldTypes() {

		List<String> types = new ArrayList<String>();

		types.add(Constants.DATE);
		types.add(Constants.DATETIME);
		types.add(Constants.NUMBER);
		types.add(Constants.PERCENTAGE);
		types.add(Constants.CURRENCY);
		types.add(Constants.EMAIL);
		types.add(Constants.PHONE_NUMBER);
		types.add(Constants.TEXT);
		types.add(Constants.CHECKBOX);
		types.add(Constants.URL);
		types.add(Constants.LOOKUP);
		types.add(Constants.PICKLIST);
		return types;
	}

}
