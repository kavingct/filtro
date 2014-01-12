import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.FilterList;
import com.genzis.filtro.Filters;
import com.genzis.filtro.filters.StringContainsFilter;
import com.genzis.filtro.filters.StringStartsFilter;

public class FiltersTest {
	
	List<Filter<String>> filters;
	List<String> list;
	Set<String> set;
	Map<String,String> map;
	
	public FiltersTest() {
	}
	
	@Before
	public void createFilter() {
		filters = new ArrayList<Filter<String>>();
		filters.add(new StringStartsFilter("h"));
		filters.add(new StringContainsFilter("ab"));
		
		list = new FilterList<String>();
		list.add("hi abc");
		list.add("hello ac");
		list.add("abc test");
		set = new HashSet<String>();
		set.addAll(list);
		map = new HashMap<String,String>();
		map.put("hi abc", "hi abc");
		map.put("hello ac", "hello ac");
		map.put("abc test", "abc test");
	}
	
	@Test
	public void testListFilter() throws InstantiationException, IllegalAccessException {
		List<String> temp_list = Filters.filterList(list, filters, false);
		Assert.assertTrue("List Filter: String starts filter and container filter must filter only 'hi abc' result.", temp_list.size() == 1 && temp_list.contains("hi abc"));
	}
	
	@Test
	public void testListChangeFilter() throws InstantiationException, IllegalAccessException {
		Filters.filterList(list, filters, true);
		Assert.assertTrue("List Filter: String starts filter and container filter must filter only 'hi abc' result.", list.size() == 1 && list.contains("hi abc"));
	}
	
	@Test
	public void testSetFilter() throws InstantiationException, IllegalAccessException {
		Set<String> temp_set = Filters.filterSet(set, filters, false);
		Assert.assertTrue("Set Filter: String starts filter and container filter must filter only 'hi abc' result.", temp_set.size() == 1 && temp_set.contains("hi abc"));
	}
	
	@Test
	public void testSetChangeFilter() throws InstantiationException, IllegalAccessException {
		Filters.filterSet(set, filters, true);
		Assert.assertTrue("Set Filter: String starts filter and container filter must filter only 'hi abc' result.", set.size() == 1 && set.contains("hi abc"));
	}
	
	@Test
	public void testMapKeysFilter() throws InstantiationException, IllegalAccessException {
		Map<String,String> temp_map = Filters.filterMapKeys(map, filters, false);
		Assert.assertTrue("Map Filter: String starts filter and container filter must filter only 'hi abc' result.", temp_map.size() == 1 && temp_map.containsKey("hi abc"));
	}
	
	@Test
	public void testMapKeysChangeFilter() throws InstantiationException, IllegalAccessException {
		Filters.filterMapKeys(map, filters, true);
		Assert.assertTrue("Map Filter: String starts filter and container filter must filter only 'hi abc' result.", map.size() == 1 && map.containsKey("hi abc"));
	}
	
	@Test
	public void testMapValuesFilter() throws InstantiationException, IllegalAccessException {
		Map<String,String> temp_map = Filters.filterMapValues(map, filters, false);
		Assert.assertTrue("Map Filter: String starts filter and container filter must filter only 'hi abc' result.", temp_map.size() == 1 && temp_map.containsKey("hi abc"));
	}
	
	@Test
	public void testMapValuesChangeFilter() throws InstantiationException, IllegalAccessException {
		Filters.filterMapValues(map, filters, true);
		Assert.assertTrue("Map Filter: String starts filter and container filter must filter only 'hi abc' result.", map.size() == 1 && map.containsKey("hi abc"));
	}

}