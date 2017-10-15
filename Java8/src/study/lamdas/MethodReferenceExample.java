package study.lamdas;

public class MethodReferenceExample {

	public static void main(String... args) {

		Thread t = new Thread(() -> printMessage());
		t.start();

		Thread t2 = new Thread(MethodReferenceExample::printMessage); // method
																		// reference
																		// example
		t2.start();

		// printMessage();
	}

	public static void printMessage() {
		System.out.println("Hello");
	}

}
