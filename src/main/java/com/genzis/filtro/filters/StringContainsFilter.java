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
 * Filter to check if given string contains the given sequence.
 * @author Kavin Subramanian
 *
 */
public class StringContainsFilter implements Filter<String> {
	private String sequence;
	
	/**
	 * Construct a StringContainsFilter object with the specified sequence.
	 * @param sequence The sequence that the string should contain.
	 */
	public StringContainsFilter(String sequence)
	{
		this.sequence = sequence;
	}
	
	/**
	 * Get the sequence.
	 * @return The sequence in this filter.
	 */
	public String getSequence() {
		return this.sequence;
	}
	
	/**
	 * Set sequence value to the filter.
	 * @param sequence The sequence which the string should contain.
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	public boolean check(String value) {
		return value.indexOf(this.sequence) != -1;
	}
}