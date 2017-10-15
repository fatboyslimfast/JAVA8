package study.lamdas;

public class ThisReferenceExample {

	// instance method
	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public static void main(String... strings) {
		ThisReferenceExample t = new ThisReferenceExample();
		// System.out.println(this);
		Process p = new Process() {

			@Override
			public void process(int i) {
				System.out.println("Value of i :" + i);
				System.out.println(this);

			}

			@Override
			public String toString() {
				return "Anonymous inner class";
			}

		};

		t.doProcess(10, p);
	}
}
