/**
 * 
 */
package java8.ocp.sg2.appendix_c;

import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Pete
 *
 */
public class FindTextFiles extends SimpleFileVisitor<Path> {
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("File: " + file.toAbsolutePath());
		if (file.getFileName().toString().endsWith("txt")) {
			System.out.println("Found file: " + file.toAbsolutePath());
		}
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		if (exc instanceof FileSystemLoopException) {
			System.err.println("Circular reference detected: " + file.toString());
		} else if (exc != null) {
			throw exc;
		}
		return FileVisitResult.CONTINUE;
	}
}



