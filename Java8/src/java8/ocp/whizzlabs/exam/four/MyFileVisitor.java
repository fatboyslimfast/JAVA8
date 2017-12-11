package java8.ocp.whizzlabs.exam.four;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{java,txt}");

	public static void main(String[] args) throws IOException {
		MyFileVisitor fileVisitor = new MyFileVisitor();
		Path path = Paths.get("C:", "Users", "Pete", "exam");
		System.out.println(path.toFile().isDirectory());
		Files.walkFileTree(path, fileVisitor);

	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		if (matcher.matches(file.getFileName())) {
			System.out.println("Found java/txt file " + file.getFileName());
		}
		return FileVisitResult.CONTINUE;
	}

}
