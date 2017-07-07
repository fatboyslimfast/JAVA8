/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pete
 *
 */
public class Q20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparator<Integer> c = (x,y) -> y-x; // << descending order
		List<Integer> ints = Arrays.asList(3,1,4);
		Collections.sort(ints, c);
		
		for (Integer myInt : ints){
			System.out.println(myInt);
		}
		
		
		System.out.println(Collections.binarySearch(ints, 1)); // << -1
		
		
		Collections.sort(ints);
		
		for (Integer myInt : ints){
			System.out.println(myInt);
		}
		
		System.out.println(Collections.binarySearch(ints, 1)); // << 0
		
		

	}

}
