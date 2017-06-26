package java8.ocp.sg2.chapter6;

public class SnowStorm {

	static class Walk implements AutoCloseable {
		public void close() {
			throw new RuntimeException("snow");
		}
	}

	public static void main(String[] args) {
		try (Walk walk1 = new Walk(); Walk walk2 = new Walk();) {
			throw new RuntimeException("rain");
		} catch (Exception e) {
			System.out.println("Main Exception: "+e.getMessage());
			for (Throwable ex : e.getSuppressed()) {
				System.out.println("Suppressed: "+ex.getMessage());
			}

		}
	}
}