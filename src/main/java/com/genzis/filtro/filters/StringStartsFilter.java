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
 * Filter to check if given string starts with the given sequence.
 * @author Kavin Subramanian
 *
 */
public class StringStartsFilter implements Filter<String> {
	private String sequence;
	
	/**
	 * Construct a StringStartsFilter object with the specified sequence.
	 * @param sequence The sequence that the string should starts with.
	 */
	public StringStartsFilter(String sequence)
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
	 * @param sequence The sequence which the string should start with.
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	public boolean check(String value) {
		return value.startsWith(this.sequence);
	}
}