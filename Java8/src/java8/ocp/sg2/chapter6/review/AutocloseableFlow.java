package java8.ocp.sg2.chapter6.review;

import java.io.Closeable;

public class AutocloseableFlow {
	static class Door implements AutoCloseable {
		@Override
		public void close() {
			System.out.print("D");
		}
	}

	static class Window implements Closeable {
		@Override
		public void close() {
			System.out.print("W");
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		try (Door d = new Door(); Window w = new Window()) {
			System.out.print("T");
		} catch (Exception e) {
			System.out.print("E");
		} finally {
			System.out.print("F");
		}
	}
}
