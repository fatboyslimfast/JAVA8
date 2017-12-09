package java8.ocp.whizzlabs.exam.two;

public class Validator {

	private boolean valid;

	/**
	 * @param valid
	 */
	public Validator(boolean valid) {
		this.valid = valid;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
