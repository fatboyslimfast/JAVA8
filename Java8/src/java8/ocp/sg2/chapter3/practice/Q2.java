/**
 *
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author pche0001
 *
 */
public class Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Pete");
		list.add("Mark");
		list.add("Matthew");
		list.add("Amar");

		list.forEach(s -> System.out.println(s));

		System.out.println(list);

		Stream<String> st = list.stream().sorted();

		st.forEach(s -> System.out.println(s));

		list.forEach(s -> {
			int pCount = 0;
			int otherCount= 0;
			if (s.startsWith("P")) {
				System.out.println(++pCount);
			} else {
				System.out.println(++otherCount);
			};
		});

	}

}
