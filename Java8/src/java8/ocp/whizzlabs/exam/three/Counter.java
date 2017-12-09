package java8.ocp.whizzlabs.exam.three;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	// private synchronized int count2;

	private int count3 = 0;

	private AtomicInteger count = new AtomicInteger(0);

	public void increment() {

		ThreadLocalRandom.current();

		count.getAndAdd(1);

		// count++;

		count.set(count.get() + 1);

	}

}
