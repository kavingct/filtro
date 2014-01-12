/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro.filters;

import com.genzis.filtro.Filter;
import com.genzis.filtro.exceptions.InvalidRangeException;

/**
 * Filter to check if given number is in the given range.
 * @author Kavin Subramanian
 *
 * @param <T> Filter type
 */
public class NumberRangeFilter<T extends Number> implements Filter<T> {
	private T min;
	private T max;
	
	/**
	 * Construct a RangeFilter object with the specified min and max values.
	 * @param min Minimum value in range.
	 * @param max Maximum value in range.
	 */
	public NumberRangeFilter(T min,T max) throws InvalidRangeException
	{
		if(min.doubleValue() <= max.doubleValue())
		{
			this.min = min;
			this.max = max;
		}
		else
		{
			throw new InvalidRangeException("The Min number must be less than or equal to Max number");
		}
	}
	
	/**
	 * Get the minimum value in this range.
	 * @return The minimum value in this range.
	 */
	public T getMin() {
		return this.min;
	}
	
	/**
	 * Get the maximum value in this range.
	 * @return The maximum value in this range.
	 */
	public T getMax() {
		return this.max;
	}
	
	/**
	 * Sets the minimum range value.
	 * @param min The minimum range value.
	 */
	public void setMin(T min) {
		this.min = min;
	}
	
	/**
	 * Sets the maximum range value.
	 * @param max The maximum range value.
	 */
	public void setMax(T max) {
		this.max = max;
	}
	
	public boolean check(T value) {
		return (value.doubleValue() >= this.min.doubleValue()) && (value.doubleValue() <= this.max.doubleValue());
	}
}