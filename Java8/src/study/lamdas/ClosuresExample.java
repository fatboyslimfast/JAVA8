package study.lamdas;

public class ClosuresExample {

	public static void main(String... strings) {

		int a = 3;
		int b = 12; // effectively final

		doProcess(a, i -> System.out.println(i + b));

	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}