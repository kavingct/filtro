/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro.exceptions;

/**
 * Exception throws when a range filter receives invalid range
 * @author Kavin Subramanian
 *
 */
public class InvalidRangeException extends Exception {
	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = 2969242266081916193L;

	/**
	 * Construct a InvalidRangeException object with the message specified
	 * @param message The exception message
	 */
	public InvalidRangeException(String message) {
		super(message);
	}
}