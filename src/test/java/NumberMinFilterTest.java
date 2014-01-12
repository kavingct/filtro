import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.NumberMinFilter;

public class NumberMinFilterTest {
	
	Filter<Integer> filter;
	
	public NumberMinFilterTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new NumberMinFilter<Integer>(5);
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("Number 6 is greater than 5 and should pass min filter.", filter.check(6));
	}
	
	@Test
	public void testFalseValue() {
		Assert.assertFalse("Number 3 is less than 5 and should fail min filter.", filter.check(3));
	}
}