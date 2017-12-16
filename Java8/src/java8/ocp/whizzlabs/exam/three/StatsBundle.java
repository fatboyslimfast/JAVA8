package java8.ocp.whizzlabs.exam.three;

import java.util.ListResourceBundle;

public class StatsBundle extends ListResourceBundle {

	private Object[][] contents = { { "XY", new Integer(100) } };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
