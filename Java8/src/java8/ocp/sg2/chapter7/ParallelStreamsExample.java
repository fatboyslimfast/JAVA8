package java8.ocp.sg2.chapter7;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelStreamsExample {

	public static void main(String[] args) {
		Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
		Stream<Integer> parallelStream = stream.parallel();

		Stream<Integer> parallelStream2 = Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream();

		Arrays.asList(1, 2, 3, 4, 5, 6).stream().forEach(s -> System.out.print(s + " "));
		// the results are ordered and predictable because we are using a serial
		// stream.

		System.out.println();

		// the results are no longer ordered or predictable
		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEach(s -> System.out.print(s + " "));

		System.out.println();

		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEachOrdered(s -> System.out.print(s + " "));

	}

}
