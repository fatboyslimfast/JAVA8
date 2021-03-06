/**
 *
 */
package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class ArrayListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(); // empty list
		list.add("Fluffy"); // [Fluffy]
		list.add("Webby"); // [Fluffy, Webby]
		String[] array = new String[list.size()]; // empty array

		array[0] = list.get(1); // [Webby]
		array[1] = list.get(0); // [Webby, Fluffy]
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + "-");


		System.out.println();

		String[] array1 = { "gerbil", "mouse" }; // [gerbil, mouse]
		List<String> list1 = Arrays.asList(array1); // returns fixed size list
		list1.set(1, "test"); // [gerbil, test]
		array1[0] = "new"; // [new, test]
		String[] array2 = (String[]) list1.toArray(); // [new, test]
	//	list1.remove(1); // throws UnsupportedOperationException


		int[] numbers = {6,9,1,8};
		Arrays.sort(numbers); // [1,6,8,9]
		System.out.println(Arrays.binarySearch(numbers, 6)); // 1
		System.out.println(Arrays.binarySearch(numbers, 3)); // -2 (prints one less than the negated index of where the requested value would need to be inserted)


		System.out.println(numbers[0]); // 1
		System.out.println(numbers[1]); // 6


		List<Integer> list3 = Arrays.asList(9,7,5,3);
		Collections.sort(list3); // [3, 5, 7, 9]
		System.out.println(Collections.binarySearch(list3, 3)); // 0
		System.out.println(Collections.binarySearch(list3, 2)); // -1


		System.out.println(list3.get(0)); // 3





	}

}
