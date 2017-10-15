/**
 *
 */
package java8.ocp.sg2.chapter5;

import java.util.ListResourceBundle;

/**
 * @author pche0001
 *
 */
public class Zoo_en extends ListResourceBundle {

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "hello", "Hello" }, { "open", "The zoo is open" } };
	}
}
