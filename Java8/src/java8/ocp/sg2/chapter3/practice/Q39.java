/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.Comparator;

/**
 * @author Pete
 *
 */
public class Q39 {

	/**
	 * @param args
	 * @return 
	 */
	public static int compareCharaters() {
		Comparator<Character> comp = (c1) -> 0;
		
		Comparator<Character> comp1 = (c1) -> {0}; 
		
		Comparator<Character> comp2 = (c1, c2) -> 0; 
		
		Comparator<Character> comp3 = (c1, c2) -> {0}; // return keyword and semi colon required
		
		Comparator<Character> comp4 = (c1, c2) -> {return 0;};

	}

}
