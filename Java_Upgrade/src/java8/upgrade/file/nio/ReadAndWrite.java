package java8.upgrade.file.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadAndWrite {

	public ReadAndWrite() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Path path = Paths.get("c:/Temp/pete/Test.txt");
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			// Read from the stream
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null)
				System.out.println(currentLine);
		} catch (IOException e) {
			// Handle file I/O exception...
		}

		Path path2 = Paths.get("c:/Temp/pete/TestWrite.txt");
		// List<String> data = new ArrayList();
		try (BufferedWriter writer = Files.newBufferedWriter(path2, Charset.forName("UTF-16"))) {
			writer.write("Hello World");
		} catch (IOException e) {
			// Handle file I/O exception...
		}

		try {
			List<String> allLines = Files.readAllLines(path, Charset.forName("UTF-8"));

			for (String line : allLines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
