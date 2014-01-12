/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro;

/**
 * Interface which all filters must implement.
 * @author Kavin Subramanian
 *
 * @param <T> Filter Type
 */
public interface Filter<T> {
	/**
	 * Check the given value and return true if filter succeeds or false if fails.
	 * @param value The individual map item which should be checked whether it passes the filter check.
	 * @return		Returns true if filter check succeeds and false if fails.
	 */
	boolean check(T value);
}