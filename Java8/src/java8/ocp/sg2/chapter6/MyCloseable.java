/**
 * 
 */
package java8.ocp.sg2.chapter6;

import java.io.Closeable;

/**
 * @author Pete
 *
 */
public class MyCloseable implements Closeable {

	/* (non-Javadoc)
	 * @see java.io.Closeable#close()
	 */
	@Override
	public void close()  {
		System.out.println("MyCloseable >> close()");

	}

}
