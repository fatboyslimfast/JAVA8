package java8.upgrade.file.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class DirectoryWalking {

	private static Path testDir = Paths.get("c:\\temp\\");

	public DirectoryWalking() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Files.walk .... ");
		Files.walk(testDir, 3).filter(p -> p.toString().endsWith(".txt")).forEach(System.out::println);

		FileTime dateFilter = FileTime.fromMillis(System.currentTimeMillis() - 10000000);

		System.out.println("Files.find ....");

		Files.find(testDir, 3,
				(p, a) -> p.toString().endsWith(".txt") && a.lastModifiedTime().toMillis() > dateFilter.toMillis())
				.forEach(System.out::println);

		System.out.println("Files.list ....");

		Files.list(testDir).filter(p -> Files.isDirectory(p)).map(p -> p.toAbsolutePath()).forEach(System.out::println);

	}

}
