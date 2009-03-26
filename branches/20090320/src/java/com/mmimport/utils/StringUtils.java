package com.mmimport.utils;

public class StringUtils {

	/**
	 * checks if a string matches a regular expresion for phones with format: (773) 870-5554
	 * @param phone
	 * @return
	 */
	public static boolean isPhoneNumber(String phone) {

		
		String expression = "^(\\([0-9]{3}\\)) [0-9]{3}-[0-9]{4}$";
		
		return phone.matches(expression);
	}

}
