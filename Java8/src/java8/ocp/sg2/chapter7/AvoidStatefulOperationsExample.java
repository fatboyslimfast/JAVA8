package java8.ocp.sg2.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AvoidStatefulOperationsExample {
	public static void main(String[] args) {

		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		// List<Integer> data = new ArrayList<>();
		// List<Integer> data = new CopyOnWriteArrayList<>();
		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().map(i -> {
			data.add(i);
			return i;
		}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
				.forEachOrdered(i -> System.out.print(i + " "));
		System.out.println();
		for (Integer e : data) {
			System.out.print(e + " ");
		}

		System.out.println();

		System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).stream().findAny().get());

		System.out.println();

		System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findAny().get()); // the
																							// results
																							// of
																							// findAny()
																							// are
																							// no
																							// longer
																							// predictable
		// the JVM selects the first thread to finish the task and retrieves its data

		System.out.println();

		/*
		 * the results of ordered operations on a parallel stream will be
		 * consistent with a serial stream. For example, calling
		 * skip(5).limit(2).findFirst() will return the same result on ordered
		 * serial and parallel streams.
		 */

		System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findFirst().get());

	}
}
