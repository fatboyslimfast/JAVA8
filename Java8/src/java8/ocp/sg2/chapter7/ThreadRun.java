package java8.ocp.sg2.chapter7;

public class ThreadRun {

	/*
	 * This sample uses a total of four threads—the main() user thread and three
	 * additional threads created by the main() method. While the order of
	 * thread execution once the threads have been started is indeterminate, the
	 * order within a single thread is still linear.
	 */

	public static void main(String[] args) {
		System.out.println("begin");
		(new ReadInventoryThread()).start();
		(new Thread(new PrintData())).start();
		(new ReadInventoryThread()).start();
		System.out.println("end");

	}

}
