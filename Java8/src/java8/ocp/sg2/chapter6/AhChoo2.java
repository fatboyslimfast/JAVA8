/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class AhChoo2 {

	static class SneezeException extends Exception {
	}

	static class SniffleException extends SneezeException {
	}

	public static void main(String[] args) throws SneezeException  {
		try {
			throw new SneezeException();
	//	} catch (SneezeException | SniffleException e) {
		} catch (SneezeException | RuntimeException e) {
			// leave line blank
			//e = new Exception();
			//e = new RuntimeException();
			//e  = new SneezeException();
			//e = new SniffleException();
			throw e;
		}
	}
}
