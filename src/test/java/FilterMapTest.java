import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.FilterMap;
import com.genzis.filtro.filters.StringContainsFilter;
import com.genzis.filtro.filters.StringStartsFilter;

public class FilterMapTest {
	
	Filter<String> key_filter;
	List<Filter<String>> key_filters;
	Filter<String> value_filter;
	List<Filter<String>> value_filters;
	FilterMap<String,String> map;
	
	public FilterMapTest() {
	}
	
	@Before
	public void createFilter() {
		key_filter = new StringStartsFilter("h");
		key_filters = new ArrayList<Filter<String>>();
		key_filters.add(key_filter);
		key_filters.add(new StringContainsFilter("ab"));
		
		value_filter = new StringStartsFilter("val");
		value_filters = new ArrayList<Filter<String>>();
		value_filters.add(value_filter);
		value_filters.add(new StringContainsFilter("3"));
		
		map = new FilterMap<String,String>();
		map.put("hi abc","value 1");
		map.put("hello ac","2 value");
		map.put("abc test","value 3");
	}
	
	@Test
	public void testSingleKeyFilter() {
		FilterMap<String,String> temp_map = map.keyFilter(key_filter);
		Assert.assertTrue("String starts filter must filter only 'hi abc' and 'hello ac' results.", temp_map.size() == 2 && temp_map.containsKey("hi abc") && temp_map.containsKey("hello ac"));
	}
	
	@Test
	public void testMultipleKeyFilter() {
		FilterMap<String,String> temp_map = map.keyFilter(key_filters);
		Assert.assertTrue("String starts filter and container filter must filter only 'hi abc' result.", temp_map.size() == 1 && temp_map.containsKey("hi abc"));
	}
	
	@Test
	public void testSingleValueFilter() {
		FilterMap<String,String> temp_map = map.valueFilter(value_filter);
		Assert.assertTrue("String starts filter must filter only 'value 1' and 'value 3' results.", temp_map.size() == 2 && temp_map.containsValue("value 1") && temp_map.containsValue("value 3"));
	}
	
	@Test
	public void testMultipleValueFilter() {
		FilterMap<String,String> temp_map = map.valueFilter(value_filters);
		Assert.assertTrue("String starts filter and container filter must filter only 'value 3' result.", temp_map.size() == 1 && temp_map.containsValue("value 3"));
	}

}