package java8.ocp.whizzlabs.exam.five;

import java.util.concurrent.atomic.AtomicInteger;

public class CStore implements Runnable {

	int x = 1;
	private AtomicInteger cps = new AtomicInteger(10);

	@Override
	public void run() {
		while (x > 0) {
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
				System.out.println(ex);
			}
			synchronized (this) {
				x = cps.decrementAndGet();
			}

			System.out.println(cps);

		}

	}

	public static void main(String... strings) {

		CStore cs = new CStore();

		Thread th1 = new Thread(cs);
		Thread th2 = new Thread(cs);

		th1.start();
		th2.start();

	}

}
