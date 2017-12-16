package java8.ocp.whizzlabs.exam.six;

public class Ttest implements Runnable {

	@Override
	public void run() {
		Ttest a1 = new Ttest();
		Thread t = new Thread(a1);
		t.setName("a1");
		t.start();
		System.out.println(Thread.currentThread().getName() + " ");
		try {
			t.join();
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " ");
	}

}
