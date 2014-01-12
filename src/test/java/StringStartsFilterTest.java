import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.StringStartsFilter;

public class StringStartsFilterTest {
	
	Filter<String> filter;
	
	public StringStartsFilterTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new StringStartsFilter("hello");
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("String 'hello world' starts with the sequence 'hello' and should pass string starts filter.", filter.check("hello world"));
	}
	
	@Test
	public void testFalseValue() {
		Assert.assertFalse("String 'false data' does not start with the sequence 'hello' and should fail string starts filter.", filter.check("false data"));
	}

}