/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class AhChoo {

	static class SneezeException extends Exception {
	}

	static class SniffleException extends SneezeException {
	}

	public static void main(String[] args) throws SneezeException  {
		try {
			throw new SniffleException();
		} catch (SneezeException e) {
			// leave line blank
			//e = new Exception();
			//e = new RuntimeException();
			e  = new SneezeException();
			//e = new SniffleException();
			throw e;
		}
	}
}
