package java8.ocp.whizzlabs.exam.four;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Integer> {

	private int[] intArray;
	private final int THRESHOLD = 4;

	public MyTask(int[] intArray) {
		this.intArray = intArray;
	}

	public int calculate(int number) {

		return 2 * number;
	}

	@Override
	protected Integer compute() {
		if (intArray.length < THRESHOLD) {
			int summary = 0;
			for (int i = 0; i < intArray.length; i++) {
				summary = summary + calculate(intArray[i]);
			}

			return summary;
		} else {
			int middle = intArray.length / 2;
			MyTask newTask1 = new MyTask(Arrays.copyOfRange(intArray, 0, middle));
			MyTask newTask2 = new MyTask(Arrays.copyOfRange(intArray, middle, intArray.length));
			newTask1.fork();
			int firstResult = newTask1.join();
			int secondResult = newTask2.compute();
			return firstResult = secondResult;
		}
	}

}
