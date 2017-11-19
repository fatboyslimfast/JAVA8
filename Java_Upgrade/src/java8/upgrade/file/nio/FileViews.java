package java8.upgrade.file.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileViews {

	public FileViews() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		try {
			// Files.list(Paths.get("C:", "Temp",
			// "pete")).forEach(System.out::println);

			File testFile = Paths.get("C:", "Temp", "pete", "Test.txt").toFile();

			BasicFileAttributes data = Files.readAttributes(testFile.toPath(), BasicFileAttributes.class);

			System.out.println("Is path a directory? " + data.isDirectory());
			System.out.println("Is path a regular file? " + data.isRegularFile());
			System.out.println("Is path a symbolic link? " + data.isSymbolicLink());
			System.out.println("Path not a file, directory, nor symbolic link? " + data.isOther());
			System.out.println("Size (in bytes): " + data.size());
			System.out.println("Creation date/time: " + data.creationTime());
			System.out.println("Last modified date/time: " + data.lastModifiedTime());
			System.out.println("Last accessed date/time: " + data.lastAccessTime());
			System.out.println("Unique file identifier (if available): " + data.fileKey());

			BasicFileAttributeView view = Files.getFileAttributeView(testFile.getPath(), BasicFileAttributeView.class,
					LinkOption.NOFOLLOW_LINKS);
			BasicFileAttributes data2 = view.readAttributes();
			FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 10_000);
			view.setTimes(lastModifiedTime, null, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
