package java8.ocp.whizzlabs.exam.five;

import java.util.concurrent.atomic.AtomicInteger;

public class ATest2 {

	int val = 10;
	int x;

	public ATest2(int i) {
		val = i;
	}

	private AtomicInteger value = new AtomicInteger(val);

	public static void main(String[] args) {
		ATest2 aTest2 = new ATest2(5);
		System.out.println(aTest2.value.decrementAndGet());

	}

}
