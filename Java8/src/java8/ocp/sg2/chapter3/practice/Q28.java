/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.TreeMap;

/**
 * @author Pete
 *
 */
public class Q28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("3", 3);
		map.put("three", 3);
		map.put("THREE", 3);
		System.out.println(map.firstKey()+" "+map.lastKey()); // 3 three
		
	}

}
