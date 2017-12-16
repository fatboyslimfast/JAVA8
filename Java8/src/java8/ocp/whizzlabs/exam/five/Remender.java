package java8.ocp.whizzlabs.exam.five;

import java.util.concurrent.RecursiveTask;

public class Remender extends RecursiveTask<Integer> {

	private int num;
	private int devi;

	Remender(int i, int j) {
		this.num = i;
		this.devi = j;
	}

	@Override
	protected Integer compute() {
		return (num % devi);
	}

}
