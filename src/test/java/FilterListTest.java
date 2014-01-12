import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.FilterList;
import com.genzis.filtro.filters.StringContainsFilter;
import com.genzis.filtro.filters.StringStartsFilter;

public class FilterListTest {
	
	Filter<String> filter;
	List<Filter<String>> filters;
	FilterList<String> list;
	
	public FilterListTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new StringStartsFilter("h");
		filters = new ArrayList<Filter<String>>();
		filters.add(filter);
		filters.add(new StringContainsFilter("ab"));
		
		list = new FilterList<String>();
		list.add("hi abc");
		list.add("hello ac");
		list.add("abc test");
	}
	
	@Test
	public void testSingleFilter() {
		FilterList<String> temp_list = list.filter(filter);
		Assert.assertTrue("String starts filter must filter only 'hi abc' and 'hello ac' results.", temp_list.size() == 2 && temp_list.contains("hi abc") && temp_list.contains("hello ac"));
	}
	
	@Test
	public void testMultipleFilter() {
		FilterList<String> temp_list = list.filter(filters);
		Assert.assertTrue("String starts filter and container filter must filter only 'hi abc' result.", temp_list.size() == 1 && temp_list.contains("hi abc"));
	}

}