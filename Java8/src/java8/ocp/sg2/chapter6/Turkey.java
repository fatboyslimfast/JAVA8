/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class Turkey implements AutoCloseable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Turkey t = new Turkey()) { // DOES NOT COMPILE if class does not implement AutoCloseable
			System.out.println("Put turkeys in ...");
		} 
	}

	@Override
	public void close() {
		System.out.println("Close gate");
		
	}

}
