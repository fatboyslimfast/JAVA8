/**
 *
 */
package java8.ocp.sg2.appendix_c;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author pche0001
 *
 */
public class MyDateFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// The DateFormat class provides
		// factory methods to get the desired formatter.
		DateFormat s = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat m = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat l = DateFormat.getDateInstance(DateFormat.LONG);
		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
		Date d = new GregorianCalendar(2015, Calendar.JULY, 4).getTime();

		System.out.println(s.format(d)); // 7/4/15
		System.out.println(m.format(d)); // Jul 4, 2015
		System.out.println(l.format(d)); // July 4, 2015
		System.out.println(f.format(d)); // Saturday, July 4, 2015

		// To include the time in the format of a date, use a DateFormat
		DateFormat dtf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL);
		System.out.println(dtf.format(d));

		DateFormat dtfuk = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL, Locale.ENGLISH);
		System.out.println(dtfuk.format(d));

		// parsing
		DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
		String myDateString = "01/31/1984";
		Date date = shortFormat.parse(myDateString);
		DateFormat fullFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
		System.out.println(fullFormat.format(date));

		// custom date formats
		/*
		 * When you want to specify a custom format pattern, you use the
		 * SimpleDateFormat subclass. As with DecimalFormat , you use a
		 * constructor and pass in the desired format pattern. There are many
		 * symbols for date formats. The most that you will need to do is to
		 * recognize the date and time parts.
		 */

		SimpleDateFormat f1 = new SimpleDateFormat("MM dd yyyy hh:mm:ss");
		SimpleDateFormat f2 = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat f3 = new SimpleDateFormat("hh");
		Date date2 = f1.parse("01 26 2016 01:22:33");
		System.out.println(f2.format(date2)); // January 2016
		System.out.println(f3.format(date2)); // 01

	}

}
