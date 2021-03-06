package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.List;

public class WrapperExample {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1); // relies on autoboxing
		numbers.add(new Integer(3));
		numbers.add(new Integer(5));
		numbers.remove(1); // an int as the index of the element to remove
		numbers.remove(new Integer(5)); // takes an Object that should be removed
		System.out.println(numbers);

	}

}
