/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Pete
 *
 */
public class Q23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("Grapes of Wrath");
		list.add("1984");
		
		list.stream().forEach(System.out::println);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
