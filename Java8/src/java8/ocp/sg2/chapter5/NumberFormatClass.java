/**
 *
 */
package java8.ocp.sg2.chapter5;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author pche0001
 *
 */
public class NumberFormatClass {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		Locale locale = new Locale("en", "GB");

		Double number = 1123123.3124234D;

		// you can call format() to turn a number into a String

		// A general purpose formatter
		System.out.println(NumberFormat.getInstance().format(number));
		System.out.println(NumberFormat.getInstance(locale).format(number));

		// Same as getInstance
		System.out.println(NumberFormat.getNumberInstance().format(number));
		System.out.println(NumberFormat.getNumberInstance(locale).format(number));
		// For formatting monetary amounts
		System.out.println(NumberFormat.getCurrencyInstance().format(number));
		System.out.println(NumberFormat.getCurrencyInstance(locale).format(number));
		// For formatting percentages
		System.out.println(NumberFormat.getPercentInstance().format(number));
		System.out.println(NumberFormat.getPercentInstance(locale).format(number));
		// Rounds decimal values before displaying (not on the exam)
		System.out.println(NumberFormat.getIntegerInstance().format(number));
		System.out.println(NumberFormat.getIntegerInstance(locale).format(number));

		// parse() to turn a String into a number.
		System.out.println("parsing ..");
		System.out.println(NumberFormat.getNumberInstance(new Locale("de", "DE")).parse("1.123,123"));
		System.out.println(NumberFormat.getNumberInstance(new Locale("en", "GB")).parse("1,123.123"));
		System.out.println(NumberFormat.getNumberInstance(new Locale("en", "GB")).parse("1,123.123xxx"));

		System.out.println("printing out the same number in three different locales: ..");

		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;

		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(attendeesPerMonth));
		NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(g.format(attendeesPerMonth));
		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(attendeesPerMonth));

		System.out.println("Formatting currency works the same way ..");

		double price = 48;
		us = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(us.format(price));
		g = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		System.out.println(g.format(price));
		ca = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(price));

	}

}
