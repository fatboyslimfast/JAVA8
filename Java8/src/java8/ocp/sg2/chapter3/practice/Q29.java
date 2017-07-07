/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.Collection;

/**
 * @author Pete
 *
 */
public class Q29 {

	public class ExtendingGenerics {
		private <T extends Collection<U>, U> U add (T list, U element) {
			list.add(element);
			return element;
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
