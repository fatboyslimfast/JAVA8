package study.lamdas;

public class ThisReferenceExample2 {

	// instance method
	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public void execute() {
		doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			System.out.println(this);
		});
	}

	public static void main(String... strings) {
		ThisReferenceExample2 t = new ThisReferenceExample2();

		/*
		 * t.doProcess(10, i -> { System.out.println("Value of i is " + i); //
		 * System.out.println(this); });
		 */

		t.execute();
	}

	@Override
	public String toString() {
		return "This is reference example class";
	}
}
