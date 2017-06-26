/**
 * 
 */
package java8.ocp.sg2.chapter6;

import java.io.IOException;

/**
 * @author Pete
 *
 */
public class ReviewQ3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			throw new IOException();
		} catch (IOException | RuntimeException e) {

		}

		//Q4.
		try {System.out.println("PEte");} catch (Exception ex){}
	}

}
