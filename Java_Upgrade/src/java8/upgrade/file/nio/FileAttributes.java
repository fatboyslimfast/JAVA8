package java8.upgrade.file.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class FileAttributes {

	public FileAttributes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {

		File testFile = Paths.get("c:\\Temp\\Pete\\Test.txt").toFile();

		System.out.println("Is File " + Files.isRegularFile(testFile.toPath()));
		System.out.println("Is Directory " + Files.isDirectory(testFile.toPath()));
		System.out.println("Is Symbolic Link " + Files.isSymbolicLink(testFile.toPath()));
		File hiddenTestFile = Paths.get("c:\\Temp\\Pete\\TestHidden.txt").toFile();
		System.out.println("Is Hidden " + Files.isHidden(hiddenTestFile.toPath()));

		System.out.println("Size File (bytes) " + Files.size(testFile.toPath()));

		System.out.println("Last Modified " + Files.getLastModifiedTime(testFile.toPath()));

		Files.setLastModifiedTime(testFile.toPath(), FileTime.fromMillis(System.currentTimeMillis()));

		System.out.println("Last Modified " + Files.getLastModifiedTime(testFile.toPath()));

		// System.out.println(Files.getOwner(testFile.getPath(),
		// Link).getName());

	}
}
