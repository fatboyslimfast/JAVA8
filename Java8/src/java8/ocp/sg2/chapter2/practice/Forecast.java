/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public class Forecast {
	
	
	public enum Snow {BLIZZARD, SQUALL, FLURRY}

	/**
	 * @param args
	 */
	public static void main(String[] modelData) {
		System.out.print(Snow.BLIZZARD.ordinal());
		System.out.print(" "+Snow.valueOf("flurry".toUpperCase()).name());
		System.out.print(" "+Snow.valueOf("Blizzard".toUpperCase()).name());
	}

}
