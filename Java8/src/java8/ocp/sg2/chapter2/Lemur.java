/**
 *
 */
package java8.ocp.sg2.chapter2;

/**
 * @author pche0001
 *
 */
public class Lemur extends Primate implements HasTail {

	public int age = 10;

	/*
	 * (non-Javadoc)
	 *
	 * @see java8.ocp.sg2.chapter2.HasTail#isTailStriped()
	 */
	@Override
	public boolean isTailStriped() {
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lemur lemur = new Lemur(); // only one object, Lemur, is created and
									// referenced.
		System.out.println(lemur.age);
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());
		Primate primate = lemur;
		System.out.println(primate.hasHair());

		// following snippets of code will not compile:
		HasTail hasTail2 = lemur;
	//	System.out.println(hasTail2.age); // DOES NOT COMPILE

		// Explicit cast to Primate reference gains access to method
		System.out.println(((Primate) hasTail2).hasHair()); // DOES COMPILE

	//	System.out.println(hasTail2.hasHair()); // DOES NOT COMPILE
		Primate primate2 = lemur;
	//	System.out.println(primate2.isTailStriped()); // DOES NOT COMPILE

		System.out.println(((HasTail)primate2).isTailStriped()); // DOES COMPILE

		System.out.println(((Lemur)primate2).age); // DOES COMPILE

		Primate pete = new Lemur();
		
		System.out.println(((Lemur) pete).isTailStriped());


	}

}
