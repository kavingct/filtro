import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.StringMatchesFilter;

public class StringMatchesFilterTest {
	
	Filter<String> filter;
	
	public StringMatchesFilterTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new StringMatchesFilter("[0-9]+");
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("String '12345' is numeric and matches '[0-9]+' regex. So it should pass string matches filter.", filter.check("12345"));
	}
	
	@Test
	public void testFalseValue() {
		Assert.assertFalse("String 'ab123' is not numeric and does not match '[0-9]+' regex. So it should fail string matches filter.", filter.check("ab123"));
	}

}