package java8.ocp.sg2.chapter6.review;

public class AddOne {

	private final int addPlusOne(int a, int b) {
		// boolean assert = false;
		assert a++ > 0;
		assert b > 0;
		return a + b;
	}
}
