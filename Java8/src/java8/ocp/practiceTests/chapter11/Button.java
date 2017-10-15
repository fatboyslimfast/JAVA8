package java8.ocp.practiceTests.chapter11;

public class Button {

	private String text;

	@Override
	public int hashCode() {
		return text.hashCode();
	}

	@Override
	public boolean equals(Object o) {

		if (!(o instanceof Button))
			return false;
		Button b = (Button) o;
		return text.equals(b.text);

	}

}
