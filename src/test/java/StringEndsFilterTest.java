import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.StringEndsFilter;

public class StringEndsFilterTest {
	
	Filter<String> filter;
	
	public StringEndsFilterTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new StringEndsFilter("world");
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("String 'hello world' ends with the sequence 'world' and should pass string ends filter.", filter.check("hello world"));
	}
	
	@Test
	public void testFalseValue() {
		Assert.assertFalse("String 'false data' does not end with the sequence 'world' and should fail string ends filter.", filter.check("false data"));
	}

}