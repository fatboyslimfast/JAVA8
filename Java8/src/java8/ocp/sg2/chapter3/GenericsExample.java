/**
 *
 */
package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class GenericsExample {

	/**
	 *
	 */
	public GenericsExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List names = new ArrayList();
		//List<String> names = new ArrayList<>();
		names.add(new StringBuilder("Webby")); // produces a compiler error if ln 27 used
		printNames(names);

	}

	static void printNames(List list) {
		for (int i = 0; i < list.size(); i++) {
			String name = (String) list.get(i); // class cast exception here (java.lang.StringBuilder cannot be cast to java.lang.String)
			System.out.println(name);
		}
	}

}
