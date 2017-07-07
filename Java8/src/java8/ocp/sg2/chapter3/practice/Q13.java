/**
 *
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class Q13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Monday");
		list.add(0, "Tuesday");
		list.add("Wedneday");

		for (String day : list) {
		//	System.out.println(day);
		}

		list.remove(0);

		for (String day : list) {
		//	System.out.println(day);
		}


		String a = "Pete";
		String b = "Pete";
		String c = new String("Pete");

		System.out.println("a == b " + a == b);
		System.out.println("a == c " + a == c);
		System.out.println("b == c " + b == c);

		System.out.println("a.equals(b) " + a.equals(b));
		System.out.println("a.equals(c) " + a.equals(c));
		System.out.println("b.equals(c) " + b.equals(c));

		a = a.concat(" Cheung");


		System.out.println("a == b" + a == b);
		System.out.println("a == c" + a == c);
		System.out.println("b == c" + b == c);

		System.out.println("a.equals(b) " + a.equals(b));
		System.out.println("a.equals(c) " + a.equals(c));
		System.out.println("b.equals(c) " + b.equals(c));



	}

}
