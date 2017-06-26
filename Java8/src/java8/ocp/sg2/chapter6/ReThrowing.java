/**
 * 
 */
package java8.ocp.sg2.chapter6;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

/**
 * @author Pete
 *
 */
public class ReThrowing {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String... args) throws IOException, DateTimeParseException, SQLException {
		// only had to update the method signature. Java is able to infer that
		// Exception in the catch block now includes the additional type.
		try {
			//parseData();
			multiCatch();
		} catch (Exception e) {
			System.err.println(e);
			throw e;
		}

	}

	public static void multiCatch() throws IOException, DateTimeParseException, SQLException {
		try {
			parseData();
		} catch (IOException | DateTimeParseException e) {
			System.err.println(e);
			throw e;
		}
	}

	public static void parseData() throws IOException, DateTimeParseException, SQLException {
		//throw new SQLException("SQL wrong");
		throw new IOException("IO connection lost");
	}

}
