/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
final public class BabyBottle {
	final private int size = 14;

	final protected class Insert {
		private final int size = 25;

		public final int getSize() {
			return BabyBottle.this.size;
		}
	}

	final Insert insert = new Insert();

	final public static void main(String[] feed) {

		System.out.println(new BabyBottle().insert.getSize());
	}

}
