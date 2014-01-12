/**
 * Filtro - Java collections filter library
 * Copyright 2013 Genzis
 * 
 * Website: http://www.genzis.com
 * License: The MIT License
 */

package com.genzis.filtro;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class which provides static methods to filter any map, list or set instance you already have.
 * @author Kavin Subramanian
 *
 */
public class Filters {
	
	/*
	 * Private constructor to avoid unwanted instantiation.
	 */
	private Filters() {
	}
	
	/**
	 * Method to filter map using keys based on the filters provided.
	 * @param map The map to be filtered
	 * @param filters The list of filters.
	 * @param filter_original Flag indicating whether the filter change should be done to the original map passed or a new instance of map should be returned. A true value will remove entries from map which fails a filter. A false value will keep original map intact and will return a new map instance after filter.
	 * @return A map instance with values after filter.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <K,V> Map<K,V> filterMapKeys(Map<K,V> map,List<Filter<K>> filters,boolean filter_original) throws InstantiationException,IllegalAccessException {
		if(!filter_original) {
			@SuppressWarnings("unchecked")
			Map<K,V> new_map = map.getClass().newInstance();
			new_map.putAll(map);
			map = new_map;
		}
		for(Iterator<K> it = map.keySet().iterator();it.hasNext();) {
			K key = it.next();
			for(Filter<K> filter : filters) {
				if(!filter.check(key)) {
					it.remove();
					break;
				}
			}
		}
		return map;
	}
	
	/**
	 * Method to filter map using values based on the filters provided.
	 * @param map The map to be filtered
	 * @param filters The list of filters.
	 * @param filter_original Flag indicating whether the filter change should be done to the original map passed or a new instance of map should be returned. A true value will remove entries from map which fails a filter. A false value will keep original map intact and will return a new map instance after filter.
	 * @return A map instance with values after filter.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <K,V> Map<K,V> filterMapValues(Map<K,V> map,List<Filter<V>> filters,boolean filter_original) throws InstantiationException,IllegalAccessException {
		if(!filter_original) {
			@SuppressWarnings("unchecked")
			Map<K,V> new_map = map.getClass().newInstance();
			new_map.putAll(map);
			map = new_map;
		}
		for(Iterator<V> it = map.values().iterator();it.hasNext();) {
			V value = it.next();
			for(Filter<V> filter : filters) {
				if(!filter.check(value)) {
					it.remove();
					break;
				}
			}
		}
		return map;
	}
	
	/**
	 * Method to filter list based on the filters provided.
	 * @param list The list to be filtered
	 * @param filters The list of filters.
	 * @param filter_original Flag indicating whether the filter change should be done to the original list passed or a new instance of list should be returned. A true value will remove entries from list which fails a filter. A false value will keep original list intact and will return a new list instance after filter.
	 * @return A list instance with values after filter.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> List<T> filterList(List<T> list,List<Filter<T>> filters,boolean filter_original) throws InstantiationException,IllegalAccessException {
		if(!filter_original) {
			@SuppressWarnings("unchecked")
			List<T> new_list = list.getClass().newInstance();
			new_list.addAll(list);
			list = new_list;
		}
		for(Iterator<T> it = list.iterator();it.hasNext();) {
			T value = it.next();
			for(Filter<T> filter : filters) {
				if(!filter.check(value)) {
					it.remove();
					break;
				}
			}
		}
		return list;
	}
	
	/**
	 * Method to filter set based on the filters provided.
	 * @param set The set to be filtered
	 * @param filters The list of filters.
	 * @param filter_original Flag indicating whether the filter change should be done to the original set passed or a new instance of set should be returned. A true value will remove entries from set which fails a filter. A false value will keep original set intact and will return a new set instance after filter.
	 * @return A set instance with values after filter.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> Set<T> filterSet(Set<T> set,List<Filter<T>> filters,boolean filter_original) throws InstantiationException,IllegalAccessException {
		if(!filter_original) {
			@SuppressWarnings("unchecked")
			Set<T> new_set = set.getClass().newInstance();
			new_set.addAll(set);
			set = new_set;
		}
		for(Iterator<T> it = set.iterator();it.hasNext();) {
			T value = it.next();
			for(Filter<T> filter : filters) {
				if(!filter.check(value)) {
					it.remove();
					break;
				}
			}
		}
		return set;
	}
	
}