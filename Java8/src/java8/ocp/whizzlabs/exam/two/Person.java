package java8.ocp.whizzlabs.exam.two;

public class Person {

	private String firstName;
	private String lastName;

	public Person(String firstName2, String lastName2) {
		this.firstName = firstName2;
		this.lastName = lastName2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
