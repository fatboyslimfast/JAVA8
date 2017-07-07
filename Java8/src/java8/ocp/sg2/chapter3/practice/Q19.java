/**
 *
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class Q19 {



	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> q = new ArrayList<>();
		q.add(1);
		q.add(2);
		q.add(10);


		q.forEach(n -> new ArrayList<String>(n));

		q.forEach(ArrayList::new);

	}

}
