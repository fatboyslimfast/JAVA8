/**
 * 
 */
package study.lamdas;

import java.util.function.BiConsumer;

/**
 * @author Pete
 *
 */
public class ExceptionHandlingExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] someNumbers = { 1, 2, 3, 0 };
		int key = 1;

		process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));

	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {

		for (int i : someNumbers) {
			consumer.accept(i, key);
		}

	}

	private static <T> BiConsumer<T, T> wrapperLambda(BiConsumer<T, T> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch (ArithmeticException ex) {
				System.out.println("Exception caught in wrapper lambda");
			}

		};
	}

}
