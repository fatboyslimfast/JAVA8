/**
 *
 */
package java8.ocp.sg2.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pche0001
 *
 */
public class SynchronizedMethodSheepManager {

	private int sheepCount = 0;

	private synchronized void incrementAndReport() { // synchronized method	modifier.
		System.out.print(" \n " + ++sheepCount);
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SynchronizedMethodSheepManager manager = new SynchronizedMethodSheepManager();
			// synchronized(manager) { // synchronized block ... synchronized
			// the creation of the threads but not the execution of the threads
			for (int i = 0; i < 10; i++)
				service.submit(() -> manager.incrementAndReport());
			// }
		} finally {
			if (service != null)
				service.shutdown();
		}
	}

}
