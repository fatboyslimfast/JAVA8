package java8.ocp.whizzlabs.exam.three;

import java.util.Comparator;

public class MyComparator implements Comparator<Lorien> {

	public MyComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Lorien lorien1, Lorien lorien2) {
		return lorien1.compareTo(lorien2);
	}

}
