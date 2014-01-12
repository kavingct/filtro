/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Extends HashMap to provide functionality to filter map based on a set of user defined filters.
 * 
 * @author Kavin Subramanian
 *
 * @param <K> Key
 * @param <V> Value
 */
public class FilterMap<K,V> extends HashMap<K,V> implements Map<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construct an empty FilterMap instance.
	 */
	public FilterMap() {
		super();
	}
	
	/**
	 * Constructs a FilterMap instance with values from the map specified.
	 * 
	 * @param map The map whose values should be added.
	 */
	public FilterMap(Map<K,V> map) {
		this.putAll(map);
	}
	
	/**
	 * Filter the map keys based on list of filters.
	 * @param filters A list of filters based on which result should be returned
	 * @return		  A FilterMap with values after filtering.
	 */
	public FilterMap<K,V> keyFilter(List<Filter<K>> filters) {
		FilterMap<K,V> return_map = new FilterMap<K,V>(this);
		for(Iterator<K> it = return_map.keySet().iterator(); it.hasNext();)
		{
			K key = it.next();
			for(Filter<K> filter : filters)
			{
				if(!filter.check(key))
				{
					it.remove();
					break;
				}
			}
		}
		return return_map;
	}
	
	/**
	 * Filter the map keys based on the filter.
	 * @param filter A filter based on which map should be filtered
	 * @return		 A FilterMap with values after filtering.
	 */
	public FilterMap<K,V> keyFilter(Filter<K> filter) {
		List<Filter<K>> filters = new ArrayList<Filter<K>>();
		filters.add(filter);
		return this.keyFilter(filters);
	}
	
	/**
	 * Filter the map values based on list of filters.
	 * @param filters A list of filters based on which result should be returned
	 * @return		  A FilterMap with values after filtering.
	 */
	public FilterMap<K,V> valueFilter(List<Filter<V>> filters) {
		FilterMap<K,V> return_map = new FilterMap<K,V>(this);
		for(Iterator<V> it = return_map.values().iterator(); it.hasNext();)
		{
			V value = it.next();
			for(Filter<V> filter : filters)
			{
				if(!filter.check(value))
				{
					it.remove();
					break;
				}
			}
		}
		return return_map;
	}
	
	/**
	 * Filter the map values based on the filter.
	 * @param filter A filter based on which map should be filtered
	 * @return		 A FilterMap with values after filtering.
	 */
	public FilterMap<K,V> valueFilter(Filter<V> filter) {
		List<Filter<V>> filters = new ArrayList<Filter<V>>();
		filters.add(filter);
		return this.valueFilter(filters);
	}
	
}