/**
 *
 */
package java8.ocp.sg2.appendix_c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pche0001
 *
 */
public class MyLock {

	private static int birdCount;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		Lock lock = new ReentrantLock();

		try {
			lock.lock();
			// do stuff ...

		} finally {
			lock.unlock();
		}

		if (lock.tryLock()) {

			try {
				// lock aquired .. do stuff
			} finally {
				lock.unlock();
			}

		} else {
			// unable to acquire lock do other stuff
		}

		// waits up to a specified
		//amount of time trying to acquire a lock

		if (lock.tryLock(10, TimeUnit.SECONDS)) {
			try {
				System.out.print(" " + (++birdCount));
			} finally {
				lock.unlock();
			}
		} else {
			System.out.println("Unable to acquire lock, doing something else");
		}

	}

}
