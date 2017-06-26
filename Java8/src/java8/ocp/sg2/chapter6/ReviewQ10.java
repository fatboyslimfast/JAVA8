package java8.ocp.sg2.chapter6;

public class ReviewQ10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addPlusOne(-1,-2));
	}

	private static int addPlusOne(int a, int b) {
		boolean assert = false;  // keyword???
		assert a++ > 0;
		assert b > 0;
		return a + b;
	}

}
