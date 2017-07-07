/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Pete
 *
 */
public class Q24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Double> list = new LinkedList<Double>();

		
		list.add(Math.random());
		
		list.add(Math.random());
		
		
		list.add(Math.random());
		
		
		for (Double d : list) {
			System.out.println(d);
		}
		
		
		list.forEach((s) -> Math.random());
		
		System.out.println("========================================");
		
		list.forEach(System.out::println);
		
		System.out.println("========================================");
		
		for (Double d : list) {
			System.out.println(d);
		}

		
		
	
		

	}

}
