/**
 * 
 */
package java8.ocp.sg2.chapter6.review;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pete
 *
 */
public class QuestionFour {

	/**
	 * @param args
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String readFileText(String[] args) throws FileNotFoundException, IOException {

		String path = "C:\\Temp\\myfile.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}

	}

}
