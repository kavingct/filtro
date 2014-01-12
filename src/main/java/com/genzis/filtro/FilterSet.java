/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Extends HashSet to provide functionality to filter values based on a set of user defined filters.
 * 
 * @author Kavin Subramanian
 *
 * @param <T> Value
 */
public class FilterSet<T> extends HashSet<T> implements Set<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7656123135433258905L;

	/**
	 * Construct an empty FilterSet instance.
	 */
	public FilterSet() {
		super();
	}
	
	/**
	 * Constructs a FilterSet instance with values from the set specified.
	 * 
	 * @param set The set whose values should be added.
	 */
	public FilterSet(Set<T> set) {
		this.addAll(set);
	}
	
	/**
	 * Filter the set keys based on list of filters.
	 * @param filters A list of filters based on which the set should be filtered
	 * @return		  A FilterSet with values after filtering.
	 */
	public FilterSet<T> filter(List<Filter<T>> filters) {
		FilterSet<T> return_set = new FilterSet<T>(this);
		for(Iterator<T> it = return_set.iterator(); it.hasNext();)
		{
			T value = it.next();
			for(Filter<T> filter : filters)
			{
				if(!filter.check(value))
				{
					it.remove();
					break;
				}
			}
		}
		return return_set;
	}
	
	/**
	 * Filter the set based on the filter.
	 * @param filter A filter based on which set should be filtered
	 * @return		 A FilterSet with values after filtering.
	 */
	public FilterSet<T> filter(Filter<T> filter) {
		List<Filter<T>> filters = new ArrayList<Filter<T>>();
		filters.add(filter);
		return this.filter(filters);
	}
	
}