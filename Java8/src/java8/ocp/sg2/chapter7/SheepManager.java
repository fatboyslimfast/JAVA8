/**
 *
 */
package java8.ocp.sg2.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author pche0001
 *
 */
public class SheepManager {

	private AtomicInteger sheepCount = new AtomicInteger(0);
	private AtomicLongArray longArray = new AtomicLongArray(10);


	private void incrementAndReport() {
		System.out.print(" \n " + sheepCount.incrementAndGet());
//		longArray.set(sheepCount.get() -1, sheepCount.get());
//		System.out.print("\n Array: " + longArray.get(sheepCount.get() -1));
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
