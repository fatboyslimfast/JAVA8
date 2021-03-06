package java8.ocp.sg2.chapter7;

import java.util.Arrays;

public class ReduceExample {

	public static void main(String[] args) {
		System.out
				.println(Arrays.asList('w', 'o', 'l', 'f').stream().reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));

		System.out
		.println(Arrays.asList('w', 'o', 'l', 'f').parallelStream().reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));


	}

}
