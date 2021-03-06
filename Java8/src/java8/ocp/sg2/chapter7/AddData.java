/**
 *
 */
package java8.ocp.sg2.chapter7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author pche0001
 *
 */
public class AddData {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 30 + 11); // return type, so Callable used which supports checked exceptions
			System.out.println(result.get());

			service.submit(() -> {
				Thread.sleep(1000);
				return null;
			});
			/*
			 * Recall that Thread. sleep() throws a checked
			 * InterruptedException. Since the first lambda expression has a
			 * return type, the compiler treats this as a Callable expression
			 * that supports checked exceptions.
			 */
			service.submit(() -> {
				Thread.sleep(1000);
			});
			/*
			 * The second lambda expression does not return a value; therefore,
			 * the compiler treats this as a Runnable expression. Since Runnable
			 * methods do not support checked exceptions, the compiler will
			 * report an error trying to compile this code snippet.
			 */

		} finally {
			if (service != null)
				service.shutdown();
		}
	}

}
