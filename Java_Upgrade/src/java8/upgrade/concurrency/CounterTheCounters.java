package java8.upgrade.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class CounterTheCounters {

	public static void main(String[] args) {

		Counter c = new Counter();

		Runnable runnable = () -> {

			for (int x = 0; x < 50; x++) {
				c.increment();
				System.out.println("c is " + c.value() + System.lineSeparator());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.decrement();
				System.out.println("c is " + c.value() + System.lineSeparator());

			}

		};

		// for (int y = 0; y < 20; y++) {
		// Thread t = new Thread(runnable);
		// System.out.println(t.getName());
		// t.start();
		//
		// }

		AtomicCounter d = new AtomicCounter();

		Runnable runnable2 = () -> {

			for (int x = 0; x < 50; x++) {
				d.increment();
				System.out.println("c is " + d.value() + System.lineSeparator());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				d.decrement();
				System.out.println("c is " + d.value() + System.lineSeparator());

			}

		};

		Executor e = ExecutorService().xecute(runnable2);

		// for (int y = 0; y < 20; y++) {
		// Thread t = new Thread(runnable2);
		// t.start();
		//
		// }

	}

}
