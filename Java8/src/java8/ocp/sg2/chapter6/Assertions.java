/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class Assertions {

	/*
	 * Assertions are used for debugging purposes, allowing you to verify that
	 * something that you think is true during the coding phase is actually true
	 * at runtime.
	 */

	public enum Seasons {
		SPRING, SUMMER, FALL, WINTER
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numGuests = 5;
		assert numGuests > 0;
		System.out.println(numGuests);

		TestSeasons.test(Seasons.SPRING);
		TestSeasons.test(Seasons.SUMMER);
		TestSeasons.test(Seasons.FALL);
		TestSeasons.test(Seasons.WINTER);
	}
}
