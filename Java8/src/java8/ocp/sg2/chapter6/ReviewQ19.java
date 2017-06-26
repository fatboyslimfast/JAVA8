/**
 * 
 */
package java8.ocp.sg2.chapter6;

import java.sql.SQLException;

/**
 * @author Pete
 *
 */
public class ReviewQ19 {
	public void read() throws SQLException {
		try {
			readFromDatabase();
		} catch (SQLException | RuntimeException e) {
			throw e;
		}
	}

	private void readFromDatabase() throws SQLException {
	}
}
