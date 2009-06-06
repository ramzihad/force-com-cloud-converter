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

import java.util.ArrayList;
import java.util.List;

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
