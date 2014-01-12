/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro.filters;

import java.util.Date;

import com.genzis.filtro.Filter;

/**
 * Filter to check if given date starts with a specified limit.
 * @author Kavin Subramanian
 *
 */
public class DateStartFilter implements Filter<Date> {
	private Date limit;
	
	/**
	 * Construct a DateStartFilter object with the specified start limit.
	 * @param limit Start limit.
	 */
	public DateStartFilter(Date limit)
	{
		this.limit = limit;
	}
	
	/**
	 * Get the date limit of this filter.
	 * @return The date limit of this filter.
	 */
	public Date getLimit() {
		return this.limit;
	}
	
	/**
	 * Set date limit of this filter.
	 * @param limit The date limit to set.
	 */
	public void setLimit(Date limit) {
		this.limit = limit;
	}
	
	public boolean check(Date date) {
		return date.equals(limit) || date.after(limit);
	}
}