/**
 *
 */
package java8.ocp.sg2.chapter3.review;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class Q15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparator<Integer> c = (o1, o2) -> o2 - o1; //sorts descending change to o1-o2 for ascending
		List<Integer> list = Arrays.asList(5, 4, 7, 1);
		System.out.println(list);
		Collections.sort(list, c);
		//Collections.sort(list);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 1)); // The list must be sorted into ascending order .. so -1, if change made above 0 is returned
		System.out.println(Collections.binarySearch(list, 1, c)); // Or pass comparator in if you don't use the natural order with return 3, assuming it's been sorted by c precondition
	}

}
