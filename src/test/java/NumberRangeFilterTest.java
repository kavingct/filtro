import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.exceptions.InvalidRangeException;
import com.genzis.filtro.filters.NumberRangeFilter;

public class NumberRangeFilterTest {
	
	Filter<Integer> filter;
	
	public NumberRangeFilterTest() {
	}
	
	@Before
	public void createFilter() throws InvalidRangeException {
		filter = new NumberRangeFilter<Integer>(3,5);
	}
	
	@Test
	public void testRange() {
		Assert.assertFalse("Number 6 should be out of Range.", filter.check(6));
	}
	
	@Test(expected = InvalidRangeException.class)
	public void expectException() throws InvalidRangeException {
		new NumberRangeFilter<Integer>(5,3);
	}
}