/**
 * 
 */
package java8.upgrade.file.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Pete
 *
 */
public class CopyAndMove {

	/**
	 * 
	 */
	public CopyAndMove() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		LocalDateTime now = LocalDateTime.now();

		Files.list(Paths.get("C:", "Temp", "pete")).forEach(System.out::println);

		File testFile = Paths.get("C:", "Temp", "pete", "Test.txt").toFile();

		// System.out.println(file.exists());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		Files.copy(testFile.toPath(), Paths.get("C:", "Temp", "pete", "Test-" + now.format(formatter) + ".txt"));

		Files.list(Paths.get("C:", "Temp", "pete")).forEach(System.out::println);

		Files.move(testFile.toPath(), Paths.get("C:", "Temp", "pete", "Test" + now.format(formatter) + ".txt"),
				StandardCopyOption.REPLACE_EXISTING);
	}

}
