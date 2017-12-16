package java8.ocp.whizzlabs.exam.four;

public interface Animal {

	default double getWeight() {
		return 0.0;
	}

	static double getLength() {
		return 0.0;
	}
}
