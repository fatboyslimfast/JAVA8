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
public class Doggies {

	List<String> names; // instance variable

	/**
	 *
	 */
	Doggies() {
		names = new ArrayList<>(); // matches instance variable declaration
	}

	public void copyNames() {
		ArrayList<String> copyOfNames; // local variable
		copyOfNames = new ArrayList<>(); // matches local variable declaration
	}
}
