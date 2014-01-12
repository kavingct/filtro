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
import com.genzis.filtro.exceptions.InvalidRangeException;

/**
 * Filter to check if given date is in the given range.
 * @author Kavin Subramanian
 *
 */
public class DateRangeFilter implements Filter<Date> {
	private Date start;
	private Date end;
	
	/**
	 * Construct a DateRangeFilter object with the specified start and end dates.
	 * @param start Start date in range.
	 * @param end End date in range.
	 */
	public DateRangeFilter(Date start,Date end) throws InvalidRangeException
	{
		if(start.before(end) || start.equals(end))
		{
			this.start = start;
			this.end = end;
		}
		else
		{
			throw new InvalidRangeException("The Start date must be less than or equal to End date");
		}
	}
	
	/**
	 * Get the start date value of this range.
	 * @return The start date value.
	 */
	public Date getStart() {
		return this.start;
	}
	
	/**
	 * Get the end date value of this range.
	 * @return The end date value.
	 */
	public Date getEnd() {
		return this.end;
	}
	
	/**
	 * Set start date value to this range.
	 * @param start The start date value.
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	
	/**
	 * Set end date value to this range.
	 * @param end The end date value.
	 */
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public boolean check(Date date) {
		return (date.equals(start) || date.after(start)) && (date.equals(end) || date.before(end));
	}
}