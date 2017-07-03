package java8.ocp.sg2.chapter2.practice;

public class Twins implements Alex, Michael {

	@Override
	public void write() {
		System.out.println("Writing ...");
	}
	
//	@Override
	public static void publish() {
		System.out.println("Publishing ...");
	}
	
	
	@Override
	public void think() {
		System.out.println("Thinking ...");

	}

}
