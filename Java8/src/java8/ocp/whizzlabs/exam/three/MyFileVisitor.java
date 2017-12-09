package java8.ocp.whizzlabs.exam.three;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor implements FileVisitor<Path> {

	private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/exam");
	int count = 0;

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException arg1) throws IOException {
		if (matcher.matches(dir)) {
			return FileVisitResult.CONTINUE;
		} else {
			return FileVisitResult.SKIP_SUBTREE;
		}
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes arg1) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes arg1) throws IOException {
		count++;
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException arg1) throws IOException {
		return FileVisitResult.CONTINUE;
	}

}
