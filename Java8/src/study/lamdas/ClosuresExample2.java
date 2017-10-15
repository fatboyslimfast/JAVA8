package study.lamdas;

public class ClosuresExample2 {

	public static void main(String... strings) {

		int a = 3;
		int b = 12; // effectively final

		doProcess(a, new Process() {

			@Override
			public void process(int i) {
				System.out.println(i + b);

			}

		});

	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}
