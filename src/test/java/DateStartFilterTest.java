import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.DateStartFilter;

public class DateStartFilterTest {
	
	Filter<Date> filter;
	
	public DateStartFilterTest() {
	}
	
	@Before
	public void createFilter() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		filter = new DateStartFilter(cal.getTime());
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("Today should start from yesterday.", filter.check(new Date()));
	}
	
	@Test
	public void testFalseValue() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-7);
		Assert.assertFalse("Last week cannot start from yesterday.", filter.check(cal.getTime()));
	}

}