/**
 *
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayDeque;

/**
 * @author pche0001
 *
 */
public class Q11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayDeque<Integer> d= new ArrayDeque<>();

		d.offer(18); //[18]
		d.offer(5); // [5, 18]
		d.push(13); // [5, 18 , 13]


		System.out.println(d.poll() + " " + d.poll()); //[13, 18]


	}

}
