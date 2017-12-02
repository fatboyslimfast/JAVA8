/**
 * 
 */
package sybextestbanks.wiley.com.test1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Pete
 *
 */
public class MonkeyCounter {

	private static AtomicInteger monkey1 = new AtomicInteger(1);
	private static AtomicLong monkey2 = new AtomicLong(0);
	private static Future<Integer> ft1;
	private static Future<Long> ft2;

	/**
	 * 
	 */
	public MonkeyCounter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws TimeoutException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();

			for (int i = 0; i < 100; i++) {
				ft1 = service.submit(() -> monkey1.getAndIncrement());

				// System.out.println("1st" + ft1.isDone());
			}

			for (int i = 0; i < 100; i++) {
				ft2 = service.submit(() -> monkey2.getAndIncrement());

				// ft2.get(3, TimeUnit.SECONDS);
			}

			System.out.println(monkey1 + "" + ft1.isDone() + " " + monkey2 + "" + ft2.isDone());

		} finally {
			if (service != null) {
				service.shutdown();
				System.out.println(monkey1 + "" + ft1.isDone() + " " + monkey2 + "" + ft2.isDone());
			}
		}

		if (service != null) {

			service.awaitTermination(10, TimeUnit.SECONDS);

			if (service.isTerminated()) {
				System.out.println("All tasks finished");
			} else {
				System.out.println("At least one task is still running");
			}

			System.out.println(monkey1 + "" + ft1.isDone() + " " + monkey2 + "" + ft2.isDone());
		}

	}

}
