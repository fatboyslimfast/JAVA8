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
public class Q37 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Austin");
		list.add("Boston");
		list.add("San Francisco");
		
		long c = list.stream().filter(a -> a.length() > 10).count(); // 10 characters or smaller , creates a new stream , underlying list unaffected
		
		long d = list.stream().filter(a -> a.length() > 1).count(); // 1 characters or smaller
		
		System.out.println(c +" " +list.size()); //1 3 
		
	}

}
