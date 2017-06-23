/**
 * 
 */
package java8.ocp.sg2.appendix_c;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;

/**
 * @author Pete
 *
 */
public class FindTextFilesSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Files.walkFileTree(Paths.get("C:\\OmnixDev\\Java 8"), 
				EnumSet.of(FileVisitOption.FOLLOW_LINKS), 
				5, new FindTextFiles());
	}

}
