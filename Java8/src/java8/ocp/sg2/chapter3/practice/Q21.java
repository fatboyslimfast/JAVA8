/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Pete
 *
 */
public class Q21 {

	/**
	 *@param args
	 */
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("Archie");
		list.add("X-men");
		
		
		Stream<String> s = list.stream();
		
		s.forEach(o -> System.out.println(o));
		s.forEach(System.out::println); // <<java.lang.IllegalStateException: stream has already been operated upon or closed
		
		list.stream().forEach(o -> System.out.println(o));
		list.stream().forEach(System.out::println);
		
		

	}

}
