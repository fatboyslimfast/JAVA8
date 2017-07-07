/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayDeque;

/**
 * @author Pete
 *
 */
public class Q31 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayDeque<Integer> dice = new ArrayDeque<>();
		dice.offer(3);
		dice.offer(2);
		dice.offer(4);
		
		System.out.println(dice.stream().filter(n -> n != 4)); // no terminal operation java.util.stream.ReferencePipeline$2@548c4f57

	}

}
