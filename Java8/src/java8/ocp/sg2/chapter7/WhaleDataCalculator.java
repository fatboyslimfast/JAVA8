package java8.ocp.sg2.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhaleDataCalculator {
	public int processRecord(int input) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// Handle interrupted exception
		}
		return input + 1;
	}

	public void processAllData(List<Integer> data) {
		// data.stream().map(a -> processRecord(a)).count();
		data.parallelStream().map(a -> processRecord(a)).count();
	}

	public static void main(String[] args) {
		WhaleDataCalculator calculator = new WhaleDataCalculator();
		// Define the data
		List<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < 4000; i++)
			data.add(i);
		// Process the data
		long start = System.currentTimeMillis();
		calculator.processAllData(data);
		double time = (System.currentTimeMillis() - start) / 1000.0;
		// Report results
		System.out.println("\nTasks completed in: " + time + " seconds");


		System.out.println("Understanding Independent Operations");


		Arrays.asList("jackal", "kangaroo", "lemur").parallelStream().map(s -> s.toUpperCase())
				.forEach(System.out::println);

		System.out.println("parallel streams can process results independently, although the order of the results cannot be determined ahead of time");


		Arrays.asList("jackal","kangaroo","lemur")
		.parallelStream()
		.map(s -> {System.out.println(s); return s.toUpperCase();})
		.forEach(System.out::println);

	}

}
