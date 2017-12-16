package java8.ocp.whizzlabs.exam.three;

import java.util.ListResourceBundle;

public class StatsBundle_ja_JP extends ListResourceBundle {

	private Object[][] contents = { { "GDP", new Integer(21300) }, { "Population", new Integer(123123123) },
			{ "Literacy", new Double(0.99) }, { "XY", new Double(99.99) } };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
