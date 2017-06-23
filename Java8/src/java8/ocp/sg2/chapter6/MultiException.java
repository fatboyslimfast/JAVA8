/**
 * 
 */
package java8.ocp.sg2.chapter6;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Pete
 *
 */
public class MultiException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			if (true) {
				throw new IOException();
			} else {
				throw new SQLException();
			}
			
		} catch (IOException | SQLException e) {
			// multi catch
			//e = new RuntimeException(e.getMessage()); //DOES NOT COMPILE
		}

	}

}
