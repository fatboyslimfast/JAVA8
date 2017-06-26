/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class MyAutoCloseable implements AutoCloseable {

	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws IllegalStateException {
		System.out.println("MyAutoCloseable >> close()");

	}

}
