/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class JammedTurkeyCage implements AutoCloseable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws IllegalStateException {
		//Resources are closed after the try clause ends and before any catch/finally clauses.
		// Resources are closed in the reverse order from which they were created.
		throw new IllegalStateException("Cage door does not close");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (JammedTurkeyCage t1 = new JammedTurkeyCage(); JammedTurkeyCage t2 = new JammedTurkeyCage()) {
			System.out.println("put turkeys in");
			// throw new RuntimeException("turkeys ran off");
		} catch (IllegalStateException e) {
			System.out.println("caught: " + e.getMessage());
			// all but
			// the first are called suppressed exceptions
			for (Throwable t : e.getSuppressed())
				System.out.println(t.getMessage());
		}

		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new IllegalStateException("turkeys ran off");
		} finally {
			throw new RuntimeException("and we couldn't find them");
		}

	}

}
