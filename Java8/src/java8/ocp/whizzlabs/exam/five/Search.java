package java8.ocp.whizzlabs.exam.five;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Search extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:*.txt");
		if (pm.matches(file.getFileName())) {
			System.out.println(file);
		}
		return FileVisitResult.CONTINUE;
	}

}
