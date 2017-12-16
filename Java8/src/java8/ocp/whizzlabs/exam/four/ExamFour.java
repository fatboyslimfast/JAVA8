/**
 * 
 */
package java8.ocp.whizzlabs.exam.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.WatchService;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java8.ocp.whizzlabs.exam.Data;
import java8.ocp.whizzlabs.exam.Movie;
import java8.ocp.whizzlabs.exam.Student;
import java8.ocp.whizzlabs.exam.Student.Faculty;

/**
 * @author Pete
 *
 */
public class ExamFour {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Question1();
		Question2();
		Question3();
		Question4();
		Question5();
		Question6();
		Question7();
		Question8();
		Question9();
		Question10();

		Question11();
		Question12();
		Question13();
		Question14();
		Question15();
		Question16();
		Question17();
		Question18();
		Question19();
		Question20();

		Question21();
		Question22();
		Question23();
		Question24();
		Question25();
		Question26();
		Question27();
		Question28();
		Question29();
		Question30();

		Question31();
		Question32();
		Question33();
		Question34();
		Question35();
		Question36();
		Question37();
		Question38();
		Question39();
		Question40();

		Question41();
		Question42();
		Question43();
		Question44();
		Question45();
		Question46();
		Question47();
		Question48();
		Question49();
		Question50();

		Question51();
		Question52();
		Question53();
		Question54();
		Question55();
		Question56();
		Question57();
		Question58();
		Question59();
		Question60();

	}

	public static <T extends Number> List<T> process(List<T> args) {

		return args;
	}

	public static void Question1() throws Exception {
		System.out.println("Q1 ...");

		List<Integer> listIntegers = new ArrayList<>();
		List<? super Integer> numbers = process(listIntegers);

		List<Number> listNumbers = new ArrayList<>();
		List<? extends Number> numbers2 = process(listNumbers);

	}

	private static void Question2() {
		System.out.println("Q2 ...");

		List<Student> students = Arrays.asList(new Student(4, "Donald"), new Student(2, "Barack"),
				new Student(3, "George"), new Student(1, "Bill"));

		for (Student student : students) {
			System.out.println("pre sort : " + student);
		}

		Comparator<Student> tempComp = (s1, s2) -> s1.getName().compareTo(s2.getName());

		Comparator<Student> comparator = tempComp.thenComparing(Student::getId);

		System.out.println(students.stream().sorted(comparator).allMatch(s -> s != null));

		// students.stream().sorted(comparator).forEach(s ->
		// System.out.println(s.getName()));

		for (Student student : students) {
			System.out.println("post sort : " + student);
		}

	}

	private static void Question3() {
		System.out.println("Q3 ...");

		IntStream intStream = IntStream.rangeClosed(1, 4);
		intStream.forEach(i -> System.out.println(i));

		// Object val = intStream.collect(Collectors.partitioningBy(i -> i % 2
		// == 0)).get(true);

		// System.out.println(val);

	}

	private static void Question4() throws InterruptedException, ExecutionException, TimeoutException {
		System.out.println("Q4 ...");

		ExecutorService threadPool = Executors.newFixedThreadPool(1);

		Future<String> future = threadPool.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(2 * 1000);
				return "I have woken from a sleep";
			}

		});

		// Waits if necessary for at most the given time for the computation to
		// complete, and then retrieves its result, if available.
		System.out.println(future.get(3, TimeUnit.SECONDS));

	}

	private static void Question5() {
		System.out.println("Q5 ...");

		// int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] numbers = new int[] { 1, 2, 3, 4, 5 };
		MyTask task = new MyTask(numbers);
		System.out.println(task.compute());

	}

	private static void Question6() {
		System.out.println("Q6");
		System.out.println(
				"The Callable interface is similar to Runnable, in that both are designed for classes whose instances are potentially executed by another thread. \n"
						+ "A Runnable, however, does not return a result and cannot throw a checked exception.\n");

	}

	private static void Question7() {
		System.out.println("Q7 ...");
		ExecutorService threadPool = Executors.newFixedThreadPool(2);

		Runnable runnable = () -> System.out.println("I am a runnable");

		Callable<Object> callable = () -> {
			System.out.println("I am a callable");
			return null;
		};

		Future<?> runnableResult = threadPool.submit(runnable);
		Future<Object> callbaleResult = threadPool.submit(callable);

		Future<Object> runnableResult2 = (Future<Object>) threadPool.submit(runnable);

	}

	private static void Question8() {
		System.out.println("Q8 ...");
		Map<String, String> map = new HashMap<>();
		map.putIfAbsent("key", "value");
		map.putIfAbsent("key", "value2");
		System.out.println(map);

	}

	private static void Question9() {
		System.out.println("Q9 ...");

		Stream<Data> stream = Stream.of(new Data(1), new Data(2), new Data(3), new Data(4));
		// boolean anyMatch = stream.anyMatch(d -> d.getValue() % 2 == 0);
		// System.out.println("anyMatch" + anyMatch);
		Optional<Data> optional =
				// stream.anyMatch(d -> d.getValue() % 2 == 0).filter(d ->
				// getValue() % 2 == 0);
				stream.filter(d -> d.getValue() % 2 == 0).findAny();
		System.out.println(optional.get().getValue());

	}

	private static void Question10() {
		System.out.println("Q10 ...see Data2.class");

	}

	public static void Question11() throws Exception {
		System.out.println("Q11 ...");

		List<Student> students = Arrays.asList(new Student("Alex", Student.Faculty.ENGINEERING),
				new Student("Brian", Student.Faculty.ENGINEERING), new Student("Carmen", Student.Faculty.BUSINESS),
				new Student("Dolores", Student.Faculty.BUSINESS));

		Map<Faculty, List<String>> output = students.stream().collect(
				Collectors.groupingBy(Student::getFaculty, Collectors.mapping(Student::getName, Collectors.toList())));

		System.out.println(output);

	}

	private static void Question12() {
		System.out.println("Q12 ...");
		List<Data> data = Arrays.asList(new Data(1), new Data(2), new Data(3));
		Optional<Data> data1 = data.stream().findFirst();
		Optional<Data> data2 = data.stream().findAny();
		System.out.println(data1.get().getValue());
		System.out.println(data2.get().getValue());

	}

	private static void Question13() throws IOException {
		System.out.println("Q13 ...");
		AtomicInteger counter = new AtomicInteger(0);
		List<String> sentence = Arrays.asList("he", "wants", "to", "see", "the", "sea");

		sentence.parallelStream().allMatch(s -> {
			counter.incrementAndGet();
			return s.contains("e");
		});

		System.out.println("Counter : " + counter);

		Files.newDirectoryStream(Paths.get("."), "glob:*.txt");

	}

	private static void Question14() throws IOException, InterruptedException {
		System.out.println("Q14 ...");
		WatchService watchService = FileSystems.getDefault().newWatchService();
		// WatchKey watchKey = watchService.poll(1, TimeUnit.SECONDS);

	}

	private static void Question15() {
		System.out.println("Q15 ...");
		FileSystem fileSystem = FileSystems.getDefault();

		Iterable<Path> rootDirs = fileSystem.getRootDirectories();
		for (Path path : rootDirs) {
			System.out.println(path);
		}
	}

	private static void Question16() {
		System.out.println("Q16 ...");
		System.out.println(
				"A FileSystem implementation supports the 'glob' and 'regex' syntaxes, \nand may support others. "
						+ "The value of the syntax component is compared without regard to case.");
	}

	private static void Question17() {
		// System.out.println("QXX ...");

	}

	private static void Question18() throws IOException {
		System.out.println("Q18 ...");
		Path path1 = Paths.get("C:\\Users\\Pete\\exam\\file.txt");
		System.out.println(path1.toFile().isFile());
		Path path2 = Paths.get("C:\\Users\\Pete\\exam\\file2.txt");
		System.out.println(path2.toFile().isFile());
		Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);

		if (Files.isSameFile(path1, path2)) {

			System.out.println("Copy Succeeded");
			return;
		}
		System.out.println("Copy Failed");

		Path path3 = Paths.get("C:", "Users", "Pete", "exam", "file.txt");
		if (Files.isSameFile(path1, path3)) {
			System.out.println("path1 and path3 same file");
		} else {
			System.out.println("path1 and path3 NOT same file");
		}

	}

	private static void Question19() {
		System.out.println("Q19 ...");
		Path path = Paths.get("./mydir/..");
		System.out.println(path.normalize());
		Path path3 = Paths.get("C://", "Users", "Pete", "exam", "..", ".", "file.txt");
		System.out.println(path3.normalize());

	}

	private static void Question20() {
		System.out.println("Q20 ...");
		System.out.println(
				"To walk a file tree, you first need to implement a FileVisitor. A FileVisitor specifies the required behavior at key points in the traversal process: when a file is visited, before a directory is accessed, after a directory is accessed, or when a failure occurs. The interface has four methods that correspond to these situations: \n"
						+ "preVisitDirectory – Invoked before a directory's entries are visited.\n"
						+ "postVisitDirectory – Invoked after all the entries in a directory are visited. If any errors are encountered, the specific exception is passed to the method.\n"
						+ "visitFile – Invoked on the file being visited. The file's BasicFileAttributes is passed to the method, or you can use the file attributes package to read a specific set of attributes. For example, you can choose to read the file's DosFileAttributeView to determine if the file has the 'hidden' bit set.\n"
						+ "visitFileFailed – Invoked when the file cannot be accessed. The specific exception is passed to the method. You can choose whether to throw the exception, print it to the console or a log file, and so on.");

	}

	public static void Question21() throws Exception {
		System.out.println("Q21 ...");
		Path source = Paths.get("C:\\Users\\Pete\\exam\\file.txt");
		Files.copy(source, source.resolveSibling("file2.txt"), StandardCopyOption.REPLACE_EXISTING);

	}

	private static void Question22() {
		System.out.println("Q22 ...");
		Path path = Paths.get("C:\\Users\\Pete\\exam\\file.txt");
		try (BufferedWriter bf = Files.newBufferedWriter(path, StandardOpenOption.DSYNC)) {
			bf.write("I am sitting here ...");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void Question23() {
		System.out.println("Q23 ...");
		Path path = Paths.get("\\Users\\Pete\\exam\\file.txt");
		System.out.println(path.subpath(0, 2));
		System.out.println("file.txt ends with txt = " + path.endsWith("txt"));

	}

	private static void Question24() throws IOException {
		System.out.println("Q24 ...");
		Path path = Paths.get("C:\\Users\\Pete\\exam\\");
		Files.find(path, Integer.MAX_VALUE, (p, a) -> p.toString().endsWith("txt")).forEach(System.out::println);

	}

	private static void Question25() throws IOException {
		System.out.println("Q25 ...");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("C:\\Users\\Pete\\exam\\"),
				"glob-*.txt")) {
			stream.forEach(System.out::println);
		}

	}

	private static void Question26() throws IOException {
		System.out.println("Q26 ...");
		try (Stream<String> lines = Files.lines(Paths.get("\\Users\\Pete\\exam\\file.txt"));
				BufferedWriter bw = Files.newBufferedWriter(Paths.get("\\Users\\Pete\\exam\\file_new.txt"))) {
			// lines.forEach(bw::write);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void Question27() {
		System.out.println("Q27 ...");
		// System.out.println(StandardOpenOption.NSYNC);

	}

	private static void Question28() {
		System.out.println("Q28 ...");
		Path path1 = Paths.get("//users/./project//..//..//src//main//resources//config.xml");
		Path path2 = path1.relativize(path1.normalize());
		System.out.println(path1.getNameCount() + " " + path2.getNameCount());

	}

	private static void Question29() {
		System.out.println("Q29...");
		Stream<String> stream = Stream.of("java", "se", "8");
		String output = stream.collect(Collectors.joining(" ", "", "")).toUpperCase();
		System.out.println(output);

	}

	private static void Question30() {
		System.out.println("Q30 ...");
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(2, 4, 6);
		List<Integer> list3 = Arrays.asList(3, 6, 9);

		List<List<Integer>> lists = Arrays.asList(list1, list2, list3);

		lists.stream().flatMap(l -> l.stream()).distinct().peek(System.out::print).noneMatch(l -> l < 0);

	}

	public static class StudentFactory {

		public static Student geStudent(String string) {
			return null;
		}

	}

	public static void Question31() throws Exception {
		System.out.println("Q31 ...");

		Optional<Student> optional = Optional.ofNullable(StudentFactory.geStudent("Student"));
		System.out.println(optional.orElse(new Student("peter")));
		System.out.println(optional.orElseGet(() -> new Student("peter piper")));

	}

	private static void Question32() {
		System.out.println("Q32 ...");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

		int sum = numbers.stream().mapToInt(x -> x).sum();

		System.out.println(sum);

		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4);

		int sum2 = numbers2.stream().collect(Collectors.summingInt(i -> i));

		System.out.println(sum2);

	}

	private static void Question33() {
		System.out.println("Q33 ...");

	}

	private static void Question34() {
		// System.out.println("QXX ...");

	}

	private static void Question35() {
		System.out.println("Q35 ...");

		Movie movie1 = new Movie(9.5, "Casino Royale");
		Movie movie2 = new Movie(6.5, "Quantum of Solace");
		Movie movie3 = new Movie(9.3, "Skyfall");
		Movie movie4 = new Movie(6.5, "Spectre");

		List<Movie> movies = Arrays.asList(movie1, movie2, movie3, movie4);
		List<Movie> movies2 = Arrays.asList(movie1, movie2, movie3, movie4);
		List<Movie> movies3 = Arrays.asList(movie1, movie2, movie3, movie4);

		movies.stream().filter(f -> f.getRating() > 9.0).forEach(f -> System.out.println(f.getTitle()));

		movies2.stream().filter(new Movie.Filter()).forEach(f -> System.out.println(f.getTitle()));

		// movies3.stream().filter(Movie::Filter::isGood).forEach(f ->
		// System.out.println(f.getTitle()));

	}

	private static void Question36() {
		System.out.println("Q36 ...");
		Student student1 = new Student(1, "John");
		Student student2 = new Student(2, "Ringo");
		Student student3 = new Student(3, "George");
		Student student4 = new Student(4, "Jack");

		Stream<Student> stream = Stream.of(student1, student2, student3, student4);

		ToIntFunction<Student> func = s -> s.getId();
		stream.mapToInt(func);
		// stream.forEach(s -> System.out.println(s));

	}

	private static void Question37() {
		// System.out.println("QXX ...");

	}

	private static void Question38() {
		System.out.println("Q38 ...");
		System.out.println("public interface BiConsumer<T,U> \n"
				+ "Represents an operation that accepts two input arguments and returns no result. \n "
				+ "This is the two-arity specialization of Consumer. \n"
				+ "Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects\n");
		System.out.println("public interface BiFunction<T,U,R> \n"
				+ "Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function.\n"
				+ "This is a functional interface whose functional method is apply(Object, Object).\n");
		System.out.println("public interface BinaryOperator<T>\n" + "extends BiFunction<T,T,T>\n"
				+ "Represents an operation upon two operands of the same type, producing a result of the same type as the operands. \n This is a specialization of BiFunction for the case where the operands and the result are all of the same type.\n");

		System.out.println("public interface BiPredicate<T,U>\n"
				+ "Represents a predicate (boolean-valued function) of two arguments. This is the two-arity specialization of Predicate.\n"
				+ "This is a functional interface whose functional method is test(Object, Object).\n");

		System.out.println("public interface Supplier<T>\n" + "Represents a supplier of results.\n"
				+ "There is no requirement that a new or distinct result be returned each time the supplier is invoked.\n"
				+ "This is a functional interface whose functional method is get().");

	}

	private static void Question39() {
		System.out.println("Q39 ...");

		Student student1 = new Student(1, "John");
		Student student2 = new Student(2, "Ringo");
		Student student3 = new Student(3, "George");
		Student student4 = new Student(4, "Jack");

		Map<Integer, String> map = new HashMap<>();
		map.put(student1.getId(), student1.getName());
		map.put(student2.getId(), student2.getName());
		map.put(student3.getId(), student3.getName());
		map.put(student4.getId(), student4.getName());

		map.forEach((k, v) -> System.out.println(k + ":" + v));

	}

	private static void Question40() {
		// System.out.println("QXX ...");

	}

	public static void Question41() throws Exception {

	}

	private static void Question42() {
		// System.out.println("QXX ...");

	}

	private static void Question43() {
		System.out.println("Q43...");
		Stream<String> s = Stream.of("united", "states");
		BinaryOperator<String> operator = (s1, s2) -> s1.concat(s2.toUpperCase());
		String result = s.reduce("-", operator);
		System.out.println(result);

	}

	private static void Question44() {
		System.out.println("Q44 ...");
		Supplier<Student> supplier = () -> new Student();
		// Function<int, String> function = (i) -> new Student(i, n).;

		// Predicate<Student> predicate = s -> s.getId();

		Consumer<Student> consumer = s -> System.out.println(s);

	}

	private static void Question45() {
		System.out.println("Q45 ...");
		Child func = () -> {
			return 0;
		};

	}

	private static void Question46() {
		System.out.println("Q46 ...");

		BinaryOperator<String> func = String::concat;

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");

		map.merge(1, "A", func);
		map.merge(2, "B", func);

		System.out.println(map);

	}

	private static void Question47() {
		System.out.println("Q47");

		try {
			// do something
			method2();
		} catch (Exception e) {
			Throwable[] throwables = e.getSuppressed();
			for (Throwable throwable : throwables) {
				System.out.println("suppressed " + throwable);
			}
		}

	}

	private static void method2() throws Exception {
		try {
			method1();
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			throw new IOException();
		}
	}

	private static void method1() {
		throw new RuntimeException();
	}

	private static void Question48() {
		// System.out.println("QXX ...");

	}

	private static void Question49() {
		System.out.println("Q49 ...");

		String string1 = "java";
		String string2 = "se";
		String string3 = "upgrade";

		Object[] strings = new String[] { string1, string2, string3 };

		for (Object string : strings) {
			switch (string.toString()) {
			case "java":
				System.out.println("JAVA");
			case "se":
				System.out.println("SE");
			case "upgrade":
				System.out.println("UPGRADE");

			}
		}

	}

	private static void Question50(String... strings) {
		System.out.println("Q50 ...");

		final Object val1 = "0";
		final String val2 = "0";
		final Character val3 = '0';
		final Integer val4 = 0;

		for (String string : strings) {

			switch (string) {
			case val2:
				System.out.println("do stuff .... \n");
			}

		}

	}

	public static void Question51() throws Exception {

	}

	private static void Question52() {
		System.out.println("Q52 ...");

		char value = 0b1;
		System.out.println("0b1 : " + value);

		long value1 = 0xb_1;
		System.out.println("long 0xb_1 : " + value1);

		double value2 = 0x1_f;
		System.out.println("double 0x1_f : " + value2);

		long value4 = 0B1;
		System.out.println("long 0B1 : " + value4);

	}

	private static void Question53() {
		// System.out.println("QXX ...");

	}

	private static void Question54() {
		// System.out.println("QXX ...");

	}

	private static void Question55() {
		System.out.println("Q55 ...");
		try (BufferedReader reader = new BufferedReader(new FileReader("file1.txt"))) {

			// reader = new BufferedReader(new FileReader("file2.txt"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void Question56() throws ParseException {
		System.out.println("Q56 ...");

		double frNumber = 1234.5;

		NumberFormat frFormatter = NumberFormat.getInstance(Locale.FRANCE);

		NumberFormat ukFormatter = NumberFormat.getInstance(Locale.UK);

		String formattedNum = frFormatter.format(frNumber);

		System.out.println(formattedNum);

		Number ukNumber = ukFormatter.parse(formattedNum);

		System.out.println(ukNumber);

	}

	private static void Question57() {
		System.out.println("Q57 ...");

		SimpleDateFormat sdf = new SimpleDateFormat("ZZZ");

		System.out.println(sdf.format(new Date()));

	}

	private static void Question58() {
		// System.out.println("QXX ...");

	}

	private static void Question59() {
		System.out.println("Q59 ...");

		LocalDateTime dateTime = LocalDateTime.parse("2018-06-30T23:59:59");

		String output = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);

		System.out.println(output);

	}

	private static void Question60() {
		System.out.println("Q60 ...");

		Instant instant = Instant.now();

		System.out.println(instant);

		instant.truncatedTo(ChronoUnit.SECONDS);

		System.out.println(instant);

	}

}
