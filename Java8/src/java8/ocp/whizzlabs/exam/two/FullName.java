package java8.ocp.whizzlabs.exam.two;

public interface FullName {

	void getFullName(Person person);

	default void setFullName(Person person) {
	};

}
