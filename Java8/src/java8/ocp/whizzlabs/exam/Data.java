package java8.ocp.whizzlabs.exam;

public class Data {

	private int value;

	/**
	 * @param value
	 */
	public Data(int value) {
		this.value = value;
	}

	public void output() {
		System.out.print(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
