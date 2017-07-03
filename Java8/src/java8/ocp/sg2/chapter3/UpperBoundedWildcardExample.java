package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcardExample {

	private static Integer[] myNumbers = { 1, 2, 3 };

	public static void main(String[] args) {
		/*
		 * The upper-bounded wildcard says that any class that extends Number or
		 * Number itself can be used as the formal parameter type:
		 */
		List<? extends Number> numbers = new ArrayList<Integer>(Arrays.asList(myNumbers));
		// numbers.add(Integer.valueOf(44)); // DOES NOT COMPILE .. due to type
		// erasure?

		System.out.println(total(numbers));

		List<? extends Bird> birds = new ArrayList<Sparrow>();

		// birds.add(new Sparrow()); // DOES NOT COMPILE
		// birds.add(new Bird()); // DOES NOT COMPILE
		/*
		 * The problem stems from the fact that Java doesn’t know what type
		 * List<? extends Bird> really is. It could be List<Bird> or
		 * List<Sparrow> or some other generic type that hasn’t even been
		 * written yet. Line 7 doesn’t compile because we can’t add a Sparrow to
		 * List<Bird>, and line 8 doesn’t compile because we can’t add a Bird to
		 * List<Sparrow>. From Java’s point of view, both scenarios are equally
		 * possible so neither is allowed.
		 */

	}

	public static long total(List<? extends Number> list) {
		long count = 0;
		for (Number number : list)
			count += number.longValue();
		return count;
	}
}
