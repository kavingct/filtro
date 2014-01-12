/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro.filters;

import com.genzis.filtro.Filter;

/**
 * Filter to check if given number is less than or equal to the given limit.
 * @author Kavin Subramanian
 *
 * @param <T> Filter type
 */
public class NumberMaxFilter<T extends Number> implements Filter<T> {
	private T limit;
	
	/**
	 * Construct a MinFilter object with the specified limit.
	 * @param limit The maximum limit.
	 */
	public NumberMaxFilter(T limit)
	{
		this.limit = limit;
	}
	
	/**
	 * Get the limit in this range.
	 * @return The limit in this range.
	 */
	public T getLimit() {
		return this.limit;
	}
	
	/**
	 * Set limit value to the range.
	 * @param limit The limit which has to be set to this range.
	 */
	public void setLimit(T limit) {
		this.limit = limit;
	}
	
	public boolean check(T value) {
		return value.doubleValue() <= this.limit.doubleValue();
	}
}