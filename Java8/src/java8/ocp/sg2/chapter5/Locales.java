/**
 *
 */
package java8.ocp.sg2.chapter5;

import java.util.Locale;

/**
 * @author pche0001
 *
 */
public class Locales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale);

		System.out.println(Locale.GERMAN); // de
		System.out.println(Locale.GERMANY); // de_DE
		System.out.println(Locale.UK); // en_GB

		System.out.println(new Locale("fr")); // fr
		System.out.println(new Locale("hi", "IN")); // hi_IN

		Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		Locale l2 = new Locale.Builder().setRegion("US").setLanguage("en").build();

		System.out.println(l1);
		System.out.println(l2);

		System.out.println(Locale.getDefault()); // en_IE
		Locale locale1 = new Locale("en", "GB");
		Locale.setDefault(locale1); // change the default
		System.out.println(Locale.getDefault()); // en_GB

	}

}
