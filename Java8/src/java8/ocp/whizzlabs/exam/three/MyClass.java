package java8.ocp.whizzlabs.exam.three;

public class MyClass {

	private String name;

	public MyClass() {
		this("Noname");
	}

	/**
	 * @param name
	 */
	public MyClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
