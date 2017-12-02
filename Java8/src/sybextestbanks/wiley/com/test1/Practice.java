/**
 * 
 */
package sybextestbanks.wiley.com.test1;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;

/**
 * @author Pete
 *
 */
public class Practice {

	/**
	 * 
	 */
	public Practice() {
		// TODO Auto-generated constructor stub
	}

	public enum Fruit {
		APPLE("red"), BANANA("yellow"), ORANGE("orange"), PLUM("purple");
		private Fruit(String color) {
			this.color = color;
		}

		public String color;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		final byte[] buffer = new byte[100];
		int lengthRead;
		InputStream in;
		OutputStream out;
		// while ((lengthRead = in.read(buffer)) > 0) {
		//
		// out.write(buffer, lengthRead);
		// out.flush();
		// }

		//
		LocalDate dt = LocalDate.of(2014, 11, 4);

		//
		Fruit one = Fruit.PLUM;
		System.out.println("a " + one + " is " + one.color);

	}

}
