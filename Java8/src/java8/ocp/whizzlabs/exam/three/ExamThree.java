/**
 * 
 */
package java8.ocp.whizzlabs.exam.three;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java8.ocp.whizzlabs.exam.Movie;
import java8.ocp.whizzlabs.exam.Student;

/**
 * @author Pete
 *
 */
public class ExamThree {

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

	public static void Question1() throws Exception {

	}

	private static void Question2() {
		// System.out.println("QXX.");

	}

	private static void Question3() {
		// System.out.println("QXX.");

	}

	private static void Question4() {
		// System.out.println("QXX.");

	}

	private static void Question5() {
		// System.out.println("QXX.");

	}

	private static void Question6() {

		Map<String, List<String>> map = new HashMap<>();
		map.put("key", new ArrayList<>());
		List value = map.get("key");
		// List<> value = map.get("key");
		System.out.println("Q6." + value);
	}

	private static void Question7() {
		StringBuffer uk = new StringBuffer("uk");
		StringBuffer us = new StringBuffer("us");
		List<StringBuffer> list = Arrays.asList(uk, us);
		String output = list.stream().collect(Collectors.joining(" delimiter ", " prefix ", " suffix "));
		System.out.println("Q7." + output);

	}

	private static void Question8() {
		Map<String, Map<String, String>> map = new HashMap<>();
		map.put("key", new HashMap<>());
		Map<?, ?> value = map.get("key");
		// map.put("key", "value"); // not applicable!
		System.out.println("Q8." + value);

	}

	private static void Question9() {
		System.out.println("Q9.");
		List<? extends Vehicle> list1 = new ArrayList<>();
		List<? super Car> list2 = new ArrayList<>();
		// list1.add(new Car());
		// list1.add(new Vehicle());
		// list1.add(new Ford());
		// Ford myFord = (Ford) list1.get(0);

		// list2.add(new Car());
		// list2.add(new Vehicle());
		list2.add(new Ford());

	}

	private static void Question10() {
		System.out.println("Q10.");
		List<Integer> list = Arrays.asList(2, 4, 6, 8);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// numbers.stream().filter(value -> value % 2 ==
		// 0).forEach(System.out::println);

		boolean allEven = list.stream().allMatch(i -> {
			System.out.println(i);
			return i % 2 == 0;
		});

	}

	public static void Question11() throws Exception {
		System.out.println("Q11.");
		List<Integer> list = Arrays.asList(2, 3, 4, 6);

		// Optional<Boolean> result = list.stream().noneMatch(i -> i % 2 == 1);
		boolean result = list.stream().noneMatch(i -> i % 2 == 1);
		System.out.println("None Match; " + result);
		boolean result2 = list.stream().anyMatch(i -> i % 2 == 1);
		System.out.println("Any Match; " + result2);
		boolean result3 = list.stream().allMatch(i -> list.contains(i));
		System.out.println("Any Match; " + result3);

	}

	private static void Question12() {
		System.out.println("Q12.");
		List<Movie> movies = new ArrayList<>(Arrays.asList(new Movie("Casino Royale", 40.0),
				new Movie("Quantum Of Solace", 40.0), new Movie("SkyFall", 60.0), new Movie("Spectre", 60.0)));

		final double total = 0.0;
		// movies.stream().peek(m -> total += m.getTicketPrice()); //
		// effectively
		// final .. nto allowed

		OptionalDouble avg = movies.stream().mapToDouble(m -> m.getTicketPrice()).average();
		System.out.println(avg.getAsDouble());

		ToDoubleFunction<Movie> func = Movie::getTicketPrice;
		Double avg3 = movies.stream().collect(Collectors.averagingDouble(func));
		System.out.println(avg3);

		double avg2 = movies.stream().mapToInt(m -> (int) m.getTicketPrice()).average().orElse(0);
		System.out.println(avg2);

	}

	private static void Question13() throws IOException {

		System.out.println("Q13.");
		MyFileVisitor fileVisitor = new MyFileVisitor();

		Files.walkFileTree(Paths.get("C://Users//Pete//exam"), fileVisitor);

		System.out.println(fileVisitor.count);

	}

	private static void Question14() throws IOException, InterruptedException {
		System.out.println("Q14.");

		Path path = Paths.get("C:", "Users", "Pete", "exam");

		Files.list(path).forEach(System.out::println);

		WatchService watchService = FileSystems.getDefault().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
				StandardWatchEventKinds.ENTRY_DELETE);

		Files.setLastModifiedTime(Paths.get("C:", "Users", "Pete", "exam", "file.txt"),
				FileTime.fromMillis(System.currentTimeMillis()));

		WatchKey key = watchService.take();

		key.reset();
		System.out.println(key.isValid());

		key.cancel();
		System.out.println(key.isValid());

		key.reset();
		System.out.println(key.isValid());

	}

	private static void Question15() {
		System.out.println("Q15.");

		Path path = Paths.get("C:", "Users", "Pete", "exam", "MyClass.java");

		System.out.println(path.toFile().exists());

		System.out.println(path.startsWith("C:/Users"));
		System.out.println(path.endsWith("MyClass.java"));

		Path path2 = Paths.get("/users/java/package/MyClass.java");

		System.out.println(path2.startsWith("users"));
		System.out.println(path2.endsWith("MyClass"));

	}

	private static void Question16() {
		System.out.println("Q16.");

	}

	private static void Question17() {
		System.out.println("Q17.");
		Path path1 = Paths.get("C:", "Users", "Pete", "exam", "file.txt");

		Path path2 = path1.resolveSibling("text.txt");
		System.out.println(path2 + "-" + path2.toFile().exists());

		Path path3 = path1.resolveSibling(Paths.get("text.txt"));
		System.out.println(path3 + "-" + path3.toFile().exists());

		Path path4 = path1.toAbsolutePath().resolveSibling("text.txt");
		System.out.println(path4 + "-" + path4.toFile().exists());

		Path path5 = Paths.get(path1.toAbsolutePath().getParent().toString(), "text.txt");
		System.out.println(path5 + "-" + path5.toFile().exists());

	}

	private static void Question18() {
		// System.out.println("QXX.");

	}

	private static void Question19() {
		// System.out.println("QXX.");

	}

	private static void Question20() {
		System.out.println("Q20.");
		Path path1 = Paths.get("C:", "Users", "Pete", "exam", "file.txt");
		System.out.println(path1.getNameCount());
		for (int i = 0; i < path1.getNameCount(); i++) {
			System.out.println(i + "-" + path1.getName(i));
		}

	}

	public static void Question21() throws Exception {
		System.out.println("Q20.");

		LocalDateTime date1 = LocalDateTime.of(2017, Month.JANUARY, 1, 0, 0);
		LocalDateTime date2 = LocalDateTime.of(2017, Month.JANUARY, 2, 0, 0);

		Duration duration = Duration.between(date1, date2);

		System.out.println(duration);

	}

	private static void Question22() {
		// System.out.println("QXX.");

	}

	private static void Question23() {
		// System.out.println("QXX.");

	}

	private static void Question24() {
		// System.out.println("QXX.");

	}

	private static void Question25() {
		// System.out.println("QXX.");

	}

	private static void Question26() {
		System.out.println("Q26.");
		Path path1 = Paths.get("C:", "Users", "Pete", "noDir");
		Path path2 = path1.resolve("project/src");
		path1.resolve(path2);
		path2.resolve("1ZO813");
		System.out.println(path1);
		System.out.println(path2);

	}

	private static void Question27() {
		System.out.println("Q27.");

		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:?.[!j]*");

		Path dir = Paths.get("C:", "Users", "Pete", "exam");

		for (File file : dir.toFile().listFiles()) {
			System.out.println(file.toPath());
			boolean found = matcher.matches(file.toPath());
			System.out.println(found);
		}

	}

	static Movie reLabel(Movie movie) {
		String oldLabel = movie.getLabel();
		if (oldLabel.equalsIgnoreCase("Adult")) {
			movie.setLabel("18+");
		}
		return movie;
	}

	private static void Question28() {
		System.out.println("Q28.");

		List<Movie> movies = Arrays.asList(new Movie("50 shades", "Adult"),
				new Movie("Shakespeare in Love", "Romance"));

		movies.stream().peek(m -> System.out.println(m.toString("old"))).map(m -> reLabel(m))
				.forEach(m -> System.out.println(m.toString("new")));

	}

	private static void Question29() {
		System.out.println("Q29.");

		List<Lorien> loriens = Arrays.asList(new Lorien(1, "John"), new Lorien(2, "Paul"), new Lorien(3, "George"),
				new Lorien(4, "Ringo"));
		loriens.stream().
		// sorted(Comparator.comparing(l -> l.getName()))
		// sorted(Lorien::compareTo)
		// sorted(new MyComparator()::compare)
				sorted().map(l -> l.getName()).sorted().forEach(System.out::println);
	}

	private static void Question30() {
		System.out.println("Q30.");
		List<Integer> ints = Arrays.asList(1, 2, 3, 4);
		long count = ints.stream().filter(i -> i % 2 == 0).count();
		System.out.println(count);

	}

	public static void Question31() throws Exception {

	}

	private static void Question32() {
		System.out.println("Q32.");

		Student student1 = new Student(1, "John");
		Student student2 = new Student(2, "Ringo");
		Student student3 = new Student(3, "George");
		Student student4 = new Student(4, "Jack");

		Map<Integer, Student> map1 = new HashMap<>();
		map1.put(student1.getId(), student1);
		map1.put(student2.getId(), student2);

		Map<Integer, Student> map2 = new HashMap<>();
		map2.put(student3.getId(), student3);
		map2.put(student4.getId(), student4);

		List<Map<Integer, Student>> students = Arrays.asList(map1, map2);

		students.stream().flatMap(s -> s.values().stream()).filter(s -> s.getName().startsWith("J"))
				.forEach(System.out::println);

	}

	private static void Question33() {
		// System.out.println("QXX.");

	}

	private static void Question34() {
		System.out.println("Q34.");
		IntStream ints = IntStream.range(0, 10);
		IntPredicate even = i -> i % 2 == 0;
		IntPredicate odd = i -> i % 2 == 1;

		int totalEven = ints.filter(even).sum();
		// stream has already been operated upon or closed
		// int totalOdd = ints.filter(odd).sum();

		// System.out.println(totalEven + " " + totalOdd);

	}

	private static void Question35() {
		System.out.println("Q35.");
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		list.stream().filter(x -> {
			System.out.println(x);
			return x % 2 == 0;
		});
		// .forEach(System.out::println);

	}

	private static void Question36() {
		System.out.println("Q36.");

		Supplier<MyClass> func = MyClass::new;
		MyClass myClass = func.get();
		System.out.println(myClass.getName());

		Function<String, MyClass> func2 = MyClass::new;
		MyClass myClass2 = func2.apply("Noname");
		System.out.println(myClass2.getName());

	}

	private static void Question37() {
		System.out.println("Q37.");

		Map<String, List<String>> map = new HashMap<>();

		System.out.println(map);

		map.putIfAbsent("pete", Arrays.asList("a", "b"));

		System.out.println(map);

		map.putIfAbsent("pete", Arrays.asList("c", "d"));

		System.out.println(map);

	}

	public static List<Integer> calculate(List<Integer> oldList, Function<Integer, Integer> function) {
		List<Integer> newList = new ArrayList<Integer>();

		for (Integer e : oldList) {
			newList.add(function.apply(e));
		}

		return newList;

	}

	private static void Question38() {
		System.out.println("Q38.");

		List<Integer> l = Arrays.asList(1, 2, 3, 4);
		List<Integer> result = calculate(l, i -> {
			return i * 2;
		});

		System.out.println(result);

	}

	private static void Question39() {
		System.out.println("Q39.");

		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		BiPredicate<Integer, Integer> predicate = (i, j) -> i % j == 0;

		BiFunction<List<Integer>, Integer, List<Integer>> function = (l1, j) -> {
			List<Integer> l2 = new ArrayList<>();

			for (int i : l1) {
				if (predicate.test(i, j)) {
					l2.add(i / j);
				}
			}

			return l2;

		};

		System.out.println(function.apply(list, 2));

	}

	private static void Question40() {
		System.out.println("Q40.");

		List<Integer> list = Arrays.asList(1, 2, 3, 4);

		list.stream().map(i -> {
			Function<Integer, Data> func = Data::new;
			return func.apply(i);
		}).forEach(Data::output);

	}

	public static void Question41() throws Exception {
		System.out.println("Q41.");

		List<String> letters = Arrays.asList("a", "b", "c", "d");

		letters.forEach(s -> s.toUpperCase());

		letters.stream().filter(s -> s.compareTo("b") > 0).forEach(System.out::println);

	}

	private static void Question42() {
		System.out.println("Q42.");

		Account account1 = new Account(1, 50.0);
		Account account2 = new Account(2, 200.0);

		Map<Integer, Account> accounts = new HashMap<>();
		accounts.put(account1.getAccountNo(), account1);
		accounts.put(account2.getAccountNo(), account2);

		BiFunction<Integer, Account, Account> deposit = (i, a) -> {
			// System.out.println(a.getAccountNo());
			if (a.getBalance() < 100.0)
				return new Account(i, a.getBalance() + 100.0);
			else
				return a;
		};

		accounts.compute(2, deposit);

		Account account = accounts.get(1);

		System.out.println(account);

	}

	private static void Question43() {
		System.out.println("Q43.");

	}

	private static void Question44() {
		// System.out.println("QXX.");

	}

	private static void Question45() {
		System.out.println("Q45.");
		List<Student> students = Arrays.asList(new Student(1, "Alex"), new Student(2, "Max"));

		UnaryOperator<Student> function = s -> new Student(s.getId(), s.getName().toUpperCase());
		students.replaceAll(function);
		System.out.println(students);

	}

	private static void Question46() {
		System.out.println("Q46.");

		List<String> list = Arrays.asList("A", "B", "C");
		UnaryOperator<String> operator = s -> s.toLowerCase();
		Consumer<String> consumer = s -> System.out.print(s);
		list.stream().map(operator).forEach(consumer);

	}

	private static void Question47() {
		System.out.println("Q47.");

		final String comparing = "";
		final String compared = "text";
		switch (comparing) {
		case compared:
			System.out.println("Text are equal");
			break;
		default:
			System.out.println("Unequal");
			break;
		}

	}

	private static void Question48() {
		// System.out.println("QXX.");

	}

	private static void Question49() {

		try {
			System.out.println("Q49.");
			throw new IOException("IO Exception");
		} catch (IOException | RuntimeException e) {
			// e = new RuntimeException();
			e.printStackTrace();
			// throw new RuntimeException(e);
		}

	}

	private static void Question50() {
		System.out.println("Q50.");

		Path path1 = Paths.get("file1.txt");
		Path path2 = Paths.get("file2.txt");

		// try {
		// // Files.move(path1, path2, StandardCopyOption.ATOMIC_MOVE);
		// throw new FileAlreadyExistsException("sasd");
		// } catch (FileAlreadyExistsException | AtomicMoveNotSupportedException
		// | DirectoryNotEmptyException
		// | UnsupportedOperationException | SecurityException e) {
		// e.printStackTrace();
		// }

	}

	public static void Question51() throws Exception {
		System.out.println("Q51.");
		System.out.println(new Saloon() {

			@Override
			public String hello() {
				// TODO Auto-generated method stub
				return "I am no-one";
			}

		}.hello());

	}

	private static void Question52() {
		System.out.println("Q52.");

		try (CustomResource resource = new CustomResource()) {
			throw new SecurityException("sec excepitron ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void Question53() {
		System.out.println("Q53.");

		Set<String> sentence = new TreeSet<String>();
		sentence.add("Welcome");
		sentence.add("to");
		sentence.add("the");
		sentence.add("World");

		for (String word : sentence) {

			switch (word) {

			case "Welcome":
				System.out.println("Welcome");
				break;
			case "to":
				System.out.println("to");
				break;
			case "the":
				System.out.println("the");
				break;
			case "World":
				System.out.println("World");
				break;
			}

		}

	}

	private static void Question54() {
		System.out.println("Q54.");
		double number = 0x1000_D;
		System.out.println(number);

	}

	private static void Question55() {
		System.out.println("Q55.");

		Instant instant = Instant.parse("2017-06-30T12:00:00z");
		instant.plus(1, ChronoUnit.HOURS);
		LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("US/Pacific"));
		System.out.println(instant);
		System.out.println(dateTime);

	}

	private static void Question56() {
		System.out.println("Q56.");
		// ResourceBundle.getBundle("bundle");

	}

	private static void Question57() {
		// System.out.println("QXX.");

	}

	private static void Question58() {
		System.out.println("Q58.");

		Duration seconds = Duration.ofSeconds(90061);
		Duration millis = Duration.ofMillis(1001);

		System.out.println(seconds);
		System.out.println(millis);

	}

	private static void Question59() {
		System.out.println("Q59.");

		Locale locale = new Locale("ja", "JP");
		ResourceBundle bundle = ResourceBundle.getBundle("sample.StatsBundle", locale);
		Object gdp = bundle.getObject("GDP");
		System.out.println(gdp);

	}

	private static void Question60() {
		// System.out.println("QXX.");

	}

}
