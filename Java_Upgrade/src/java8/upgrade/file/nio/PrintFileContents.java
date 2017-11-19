package java8.upgrade.file.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PrintFileContents {

	private static Path testFilePath = Paths.get("c:\\temp\\pete\\Test.txt");

	public PrintFileContents() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] arg) throws IOException {

		System.out.println("Files.lines ....");

		Files.lines(testFilePath, Charset.forName("UTF-8")).forEach(System.out::println);

		System.out.println("Files.lines filter ....");

		List<String> list = Files.lines(testFilePath).filter(p -> p.startsWith("Line")).map(s -> s.substring(5))
				.collect(Collectors.toList());

		list.stream().forEach(System.out::println);

	}

}
