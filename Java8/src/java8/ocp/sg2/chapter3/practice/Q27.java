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
public class Q27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("mancheser");
		list.add("bristol");
		list.add("london");
		list.add("birmingham");
		
		list.stream().filter(String::isEmpty).forEach(System.out::println);
		
		list.stream().filter(s ->s.startsWith("b")).forEach(System.out::println);

	}

}
