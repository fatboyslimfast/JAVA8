package java8.ocp.sg2.chapter6.review;

public class AhChoo {
	static class SneezeException extends Exception {
	}

	static class SniffleException extends SneezeException {
	}

	public static void main(String[] args) throws SneezeException {
		try {
			throw new SneezeException();
		} catch (SneezeException e) {
			e = new SniffleException();
			throw e;
		}
	}

	public static void main2(String[] args) throws SneezeException {
		try {
			throw new SneezeException();
		} catch (SneezeException | SniffleException e) {

			throw e;
		}
	}
}