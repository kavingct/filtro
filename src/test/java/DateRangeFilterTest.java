import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.exceptions.InvalidRangeException;
import com.genzis.filtro.filters.DateRangeFilter;

public class DateRangeFilterTest {
	
	Filter<Date> filter;
	
	public DateRangeFilterTest() {
	}
	
	@Before
	public void createFilter() throws InvalidRangeException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		Date start = cal.getTime();
		cal.add(Calendar.DATE,2);
		Date end = cal.getTime();
		filter = new DateRangeFilter(start,end);
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("Today should be between yesterday and tomorrow", filter.check(new Date()));
	}
	
	@Test
	public void testFalseValue() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,7);
		Assert.assertFalse("Next week should not be between yesterday and tomorrow.", filter.check(cal.getTime()));
	}

	@Test(expected=InvalidRangeException.class)
	public void testException() throws InvalidRangeException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		new DateRangeFilter(new Date(),cal.getTime());
	}
}