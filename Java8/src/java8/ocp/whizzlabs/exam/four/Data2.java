package java8.ocp.whizzlabs.exam.four;

import java.util.ArrayList;
import java.util.List;

public class Data2 {

	private List<Integer> value;

	/**
	 * @param value
	 */
	public Data2(List<Integer> value) {
		this.value = value;
	}

	public List<Integer> getValue() {
		return new ArrayList<>(value);
	}

	public void setValue(List<Integer> value) {
		this.value = new ArrayList<>(value);
	}

}
