import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.FilterSet;
import com.genzis.filtro.filters.StringContainsFilter;
import com.genzis.filtro.filters.StringStartsFilter;

public class FilterSetTest {
	
	Filter<String> filter;
	List<Filter<String>> filters;
	FilterSet<String> set;
	
	public FilterSetTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new StringStartsFilter("h");
		filters = new ArrayList<Filter<String>>();
		filters.add(filter);
		filters.add(new StringContainsFilter("ab"));
		
		set = new FilterSet<String>();
		set.add("hi abc");
		set.add("hello ac");
		set.add("abc test");
	}
	
	@Test
	public void testSingleFilter() {
		FilterSet<String> temp_set = set.filter(filter);
		Assert.assertTrue("String starts filter must filter only 'hi abc' and 'hello ac' results.", temp_set.size() == 2 && temp_set.contains("hi abc") && temp_set.contains("hello ac"));
	}
	
	@Test
	public void testMultipleFilter() {
		FilterSet<String> temp_set = set.filter(filters);
		Assert.assertTrue("String starts filter and container filter must filter only 'hi abc' result.", temp_set.size() == 1 && temp_set.contains("hi abc"));
	}

}