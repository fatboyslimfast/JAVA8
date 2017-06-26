/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class ReviewQ9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = -1;
		assert n < 0: "OhNo"; // no syntax error but will only print out if assert is false
		//assert n < 0, "OhNo";
		//assert n < 0 ("OhNo");
		assert(n < 0): "OhNo"; // no syntax error but will only print out if assert is false
		//assert(n < 0, "OhNo");

	}

}
