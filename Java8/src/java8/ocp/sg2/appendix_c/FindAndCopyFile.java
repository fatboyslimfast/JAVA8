/**
 *
 */
package java8.ocp.sg2.appendix_c;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author pche0001
 *
 */
public class FindAndCopyFile implements FileVisitor<Path> {

	//the FileVisitor<T> interface is used to visit an entire directory tree


	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		if (file.getFileName().toString().equals("FindAndCopyFile.java")) {
			System.out.println("File found " + file.getFileName());
			System.out.println("Skip Siblings File Walk!!");
			return FileVisitResult.SKIP_SIBLINGS;
		} else {
			System.out.println("File found " + file.getFileName());
			System.out.println("Continuing File Walk!!");
			return FileVisitResult.CONTINUE;
		}
	}

	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.TERMINATE;
	}

	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	/**
	 *
	 *
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		FindAndCopyFile fc = new FindAndCopyFile();

		Files.walkFileTree(Paths.get("c:\\OmnixDev\\Java8_Prep\\"), fc);


	}



}
