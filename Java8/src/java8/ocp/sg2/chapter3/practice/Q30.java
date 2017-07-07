/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pete
 *
 */
public class Q30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Austin");
		list.add("Boston");
		list.add("San Francisco");
		
		
		list.removeIf(a -> a.length() > 10);
		
		System.out.println(list.size());
		
		
	}

}
