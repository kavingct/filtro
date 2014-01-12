import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.NumberMaxFilter;

public class NumberMaxFilterTest {
	
	Filter<Integer> filter;
	
	public NumberMaxFilterTest() {
	}
	
	@Before
	public void createFilter() {
		filter = new NumberMaxFilter<Integer>(5);
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("Number 3 is less than 5 and should pass max filter.", filter.check(3));
	}
	
	@Test
	public void testFalseValue() {
		Assert.assertFalse("Number 6 is greater than 5 and should fail max filter.", filter.check(6));
	}

}