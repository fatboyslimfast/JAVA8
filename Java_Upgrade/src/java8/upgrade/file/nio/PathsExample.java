/**
 * 
 */
package java8.upgrade.file.nio;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Pete
 *
 */
public class PathsExample {

	/**
	 * 
	 */
	public PathsExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {
		Path path = Paths.get("tmp/test.png");

		Path path2 = Paths.get("tmp", "test.png");

		Path path3 = Paths.get(new URI("file://tmp/test.png")); // runtime
																// exception
																// must be
																// absolute path
																// only

		Path path4 = FileSystems.getDefault().getPath("tmp/test.png"); // can
																		// connect
																		// to
																		// remote
																		// filesystem

		File file1 = Paths.get("tmp/test.png").toFile();

		URI uri = Paths.get("tmp/test.png").toUri();

		Path path5 = Paths.get("tmp/test.png").getParent().normalize().toAbsolutePath();

	}

}
