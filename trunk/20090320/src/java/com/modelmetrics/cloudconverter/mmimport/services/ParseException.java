package com.modelmetrics.cloudconverter.mmimport.services;

/**
 * ParseException.
 */

public class ParseException extends Exception {

	/**
	 * serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ParseException.
	 */
	public ParseException() {
		super();
	}

	/**
	 * ParseException.
	 * 
	 * @param message
	 *            String
	 * @param cause
	 *            Throwable
	 */
	public ParseException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * ParseException.
	 * 
	 * @param message
	 *            String
	 */
	public ParseException(final String message) {
		super(message);
	}

	/**
	 * ParseException.
	 * 
	 * @param cause
	 *            Throwable
	 */
	public ParseException(final Throwable cause) {
		super(cause);
	}

}
