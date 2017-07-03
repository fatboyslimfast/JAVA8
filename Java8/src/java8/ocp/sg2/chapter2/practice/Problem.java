package java8.ocp.sg2.chapter2.practice;

class Problem extends Exception {}

abstract class Danger {
	protected abstract void isDanger() throws Problem;
}

// public class NarrowerProblem extends Problem {}

public class SeriousDanger extends Danger {
	protected void isDanger() throws Problem {
		throw new RuntimeException();
	}

	public static void main(String[] will) throws Throwable {
		new SeriousDanger().isDanger();
	}
}
