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
public class Q33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("Archie");
		list.add("X-men");
		
		list.stream().forEach(System.out.println); // shoudl be System.out::println static method reference
		list.stream().forEach(System.out.println);
	}

}
