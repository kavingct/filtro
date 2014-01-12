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
 * Filter to check if given string matches with the given regex sequence.
 * @author Kavin Subramanian
 *
 */
public class StringMatchesFilter implements Filter<String> {
	private String sequence;
	
	/**
	 * Construct a StringMatchesFilter object with the specified regex sequence.
	 * @param sequence The regex sequence that the string should match.
	 */
	public StringMatchesFilter(String sequence)
	{
		this.sequence = sequence;
	}
	
	/**
	 * Get the regex sequence.
	 * @return The sequence in this filter.
	 */
	public String getSequence() {
		return this.sequence;
	}
	
	/**
	 * Set regex sequence value to the filter.
	 * @param sequence The sequence which the string should match.
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	public boolean check(String value) {
		return value.matches(this.sequence);
	}
}