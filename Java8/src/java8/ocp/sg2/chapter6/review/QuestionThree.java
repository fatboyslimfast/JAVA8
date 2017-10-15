package java8.ocp.sg2.chapter6.review;

import java.io.IOException;

public class QuestionThree {
	public static void main(String... strings) {

		try {
			doStuff();
		} catch (IOException | RuntimeException e) {
			System.out.println("caught excepiton ");
		}

	}

	private static void doStuff() throws IOException {
		System.out.println("Doing stuff ... ");

	}

}
