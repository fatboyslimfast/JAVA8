package java8.ocp.sg2.chapter6.review;

public class SnowStorm {
	static class Walk implements AutoCloseable {
		@Override
		public void close() {
			throw new RuntimeException("snow");
		}
	}

	public static void main(String[] args) {
		try (Walk walk1 = new Walk(); Walk walk2 = new Walk();) {
			throw new RuntimeException("rain");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " " + e.getSuppressed().length);
		}
	}
}
