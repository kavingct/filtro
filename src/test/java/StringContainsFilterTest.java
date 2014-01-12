import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.StringContainsFilter;

public class StringContainsFilterTest {
	
	Filter<String> filter;
	
	public StringContainsFilterTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new StringContainsFilter("hello");
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("String 'hello world' contains the sequence 'hello' and should pass string contains filter.", filter.check("hello world"));
	}
	
	@Test
	public void testFalseValue() {
		Assert.assertFalse("String 'false data' does not contain the sequence 'hello' and should fail string contains filter.", filter.check("false data"));
	}

}