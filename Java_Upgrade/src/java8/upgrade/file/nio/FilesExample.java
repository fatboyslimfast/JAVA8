package java8.upgrade.file.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesExample {

	public FilesExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {

		System.out.println(Files.exists(Paths.get("../test.png")));

		System.out.println(Files.isSameFile(Paths.get("."), Paths.get("C:\\OmnixDev\\Java 8\\JAVA8\\Java_Upgrade")));

		Files.createDirectories(Paths.get("c://Temp//pete"));

		System.out.println("pete dir? " + Files.exists(Paths.get("c://Temp//pete")));

		Files.createDirectories(Paths.get("c://Temp//peteA//peteB"));

		System.out.println("peteA\\peteB dir" + Files.exists(Paths.get("c:\\Temp\\peteA\\peteB")));

		// Files.createFile(Paths.get("c:", "Temp", "pete", "Test1.txt"),
		// StandardCopyOption.REPLACE_EXISTING);

		System.out.println("Test1.txt " + Files.exists(Paths.get("c:", "Temp", "pete", "Test1.txt")));

		Files.copy(Paths.get("c:", "Temp", "pete", "Test1.txt"), Paths.get("c:", "Temp", "pete", "Test2.txt"),
				StandardCopyOption.REPLACE_EXISTING);

		System.out.println("Test2.txt " + Files.exists(Paths.get("c:", "Temp", "pete", "Test2.txt")));

	}

}
