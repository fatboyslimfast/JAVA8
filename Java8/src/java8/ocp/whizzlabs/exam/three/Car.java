package java8.ocp.whizzlabs.exam.three;

public interface Car extends Vehicle {

	default String hello() {
		return "I am a vehicle";
	}

}
