import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.genzis.filtro.Filter;
import com.genzis.filtro.filters.DateEndFilter;

public class DateEndFilterTest {
	
	Filter<Date> filter;
	
	public DateEndFilterTest() {
	}
	
	@Before
	public void createFilter() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,1);
		filter = new DateEndFilter(cal.getTime());
	}
	
	@Test
	public void testTrueValue() {
		Assert.assertTrue("Date from today should end with tomorrow.", filter.check(new Date()));
	}
	
	@Test
	public void testFalseValue() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,7);
		Assert.assertFalse("Next week should not end with tomorrow.", filter.check(cal.getTime()));
	}

}