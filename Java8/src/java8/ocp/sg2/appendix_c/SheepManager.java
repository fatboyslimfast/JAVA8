/**
 *
 */
package java8.ocp.sg2.appendix_c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pche0001
 *
 */
public class SheepManager {

	private int sheepCount = 0;
	private Lock lock = new ReentrantLock();

	private void incrementAndReport() {

		if (lock.tryLock()) {
			try {
				System.out.print(" " + (++sheepCount));
			} finally {
				lock.unlock();
			}
		} else {
			System.out.print("Lock is locked!!! ");
		}

	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManager manager = new SheepManager();
			for (int i = 0; i < 10; i++)
				service.submit(() -> manager.incrementAndReport());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}