/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class StuckTurkeyCage implements AutoCloseable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() throws Exception {
		throw new Exception("Cage door does not close");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (StuckTurkeyCage t = new StuckTurkeyCage()) {
			System.out.println("put turkeys in");
		} catch (Exception e) {
			
		}

	}

}
