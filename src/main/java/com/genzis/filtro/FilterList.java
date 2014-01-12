/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Extends ArrayList to provide functionality to filter values based on a set of user defined filters.
 * 
 * @author Kavin Subramanian
 *
 * @param <T> Value
 */
public class FilterList<T> extends ArrayList<T> implements List<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2940339037339872880L;

	/**
	 * Construct an empty FilterList instance.
	 */
	public FilterList() {
		super();
	}
	
	/**
	 * Constructs a FilterList instance with values from the list specified.
	 * 
	 * @param list The list whose values should be added.
	 */
	public FilterList(List<T> list) {
		this.addAll(list);
	}
	
	/**
	 * Filter the list keys based on list of filters.
	 * @param filters A list of filters based on which list should be filtered
	 * @return		  A FilterList with values after filtering.
	 */
	public FilterList<T> filter(List<Filter<T>> filters) {
		FilterList<T> return_list = new FilterList<T>(this);
		for(Iterator<T> it = return_list.iterator(); it.hasNext();)
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
		return return_list;
	}
	
	/**
	 * Filter the list based on the filter.
	 * @param filter A filter based on which list should be filtered
	 * @return		 A FilterList with values after filtering.
	 */
	public FilterList<T> filter(Filter<T> filter) {
		List<Filter<T>> filters = new ArrayList<Filter<T>>();
		filters.add(filter);
		return this.filter(filters);
	}
	
}