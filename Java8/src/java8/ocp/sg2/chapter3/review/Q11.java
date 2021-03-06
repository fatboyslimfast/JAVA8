/**
 *
 */
package java8.ocp.sg2.chapter3.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pche0001
 *
 */
public class Q11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>(10);
		for (int i = 1; i <= 10; i++) {
			map.put(i, i * i);
		} // [(1,1), (2, 4), (3, 9), (4,16) , (5, 25) ...]
		System.out.println(map.get(4)); // not the index .. key object 4 is passed is so 16 value returned

	}

}
