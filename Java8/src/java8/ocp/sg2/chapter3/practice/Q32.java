/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.Collection;

/**
 * @author Pete
 *
 */
public class Q32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	private void output(Collection<?> x) {
			x.forEach(System.out::println); // method foreach takes one parameter ... 2 parameters can't be used with a method reference
		
	}
	
}
