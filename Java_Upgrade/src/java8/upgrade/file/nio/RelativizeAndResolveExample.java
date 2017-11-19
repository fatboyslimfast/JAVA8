package java8.upgrade.file.nio;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeAndResolveExample {

	public RelativizeAndResolveExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {

		// relative
		Path path1 = Paths.get("fish.txt");
		Path path2 = Paths.get("birds.txt");
		System.out.println(path1.relativize(path2));
		System.out.println(path2.relativize(path1)); // both are relative so
														// assumes same working
														// directory

		// absolute
		Path path3 = Paths.get("E:\\habitat");
		Path path4 = Paths.get("E:\\sanctuary\\raven");
		System.out.println(path3.relativize(path4));
		System.out.println(path4.relativize(path3));

		final Path path11 = Paths.get("/cats/../panther");
		final Path path12 = Paths.get("food");
		System.out.println(path11.resolve(path12));

		final Path path13 = Paths.get("/turkey/food");
		final Path path14 = Paths.get("/tiger/cage");
		System.out.println(path13.resolve(path14));

		// normalize
		Path path15 = Paths.get("E:\\data");
		Path path16 = Paths.get("E:\\user\\home");

		Path relativePath = path15.relativize(path16);
		System.out.println(path3.resolve(relativePath));
		System.out.println(path3.resolve(relativePath).normalize());

		System.out.println(Paths.get(".").toRealPath(LinkOption.NOFOLLOW_LINKS));

	}

}
