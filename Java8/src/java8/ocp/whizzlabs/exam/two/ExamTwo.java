/**
 * 
 */
package java8.ocp.whizzlabs.exam.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Pete
 *
 */
public class ExamTwo {

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
		// TODO Auto-generated method stub

	}

	private static void Question3() {

		AtomicInteger oldVal = new AtomicInteger();
		int newVal = oldVal.addAndGet(1);
		System.out.println(newVal);
		newVal = oldVal.incrementAndGet();
		System.out.println(newVal);

	}

	private static void Question4() {
		CopyOnWriteArrayList<String> data = new CopyOnWriteArrayList<>(Arrays.asList("a", "B", "c", "D"));
		new Thread() {
			@Override
			public void run() {
				data.set(0, "A");
				data.set(1, "B");
				data.set(2, "C");
				data.set(3, "D");
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				data.set(0, "a");
				data.set(1, "b");
				data.set(2, "c");
				data.set(3, "d");
			}
		}.start();

		System.out.println(data);
	}

	private static void Question5() {
		// TODO Auto-generated method stub

	}

	private static void Question6() {
		// TODO Auto-generated method stub

	}

	private static void Question7() {
		List<? super Number> list1 = new ArrayList<>();

		List<? extends Number> list2 = new ArrayList<>();

		list1.add(1);

		// list2.add(1);

		// int num = list1.get(0);

		// int num2 = list2.get(0);

	}

	private static void Question8() {
		List<String> list = new ArrayList<>();

		List<? super String> subList = new ArrayList<>();

		list.addAll(new ArrayList<>());

		// list.addAll(subList);

	}

	private static void Question9() throws URISyntaxException {
		// Paths.get(new URI(""));

		// IllegalArgumentException - if preconditions on the uri parameter do
		// not hold. The format of the URI is provider specific.

	}

	private static void Question10() {
		Path path = Paths.get("\\one\\two\\three\\four");
		System.out.println(path.getName(2));

	}

	public static void Question11() throws Exception {
		// Path path =
		// Paths.get(ExamTwo.class.getResource("file.txt").getPath());

		// Files.setAttribute(path, "lastModifiedTime",
		// FileTime.fromMillis(System.currentTimeMillis()));

	}

	private static void Question12() {
		// TODO Auto-generated method stub

	}

	private static void Question13() {
		// TODO Auto-generated method stub

	}

	private static void Question14() {
		// TODO Auto-generated method stub

	}

	private static void Question15() throws IOException {
		// Path path = Paths.get("file.txt");
		// Files.delete(path);

	}

	private static void Question16() {
		// TODO Auto-generated method stub

	}

	private static void Question17() {
		// TODO Auto-generated method stub

	}

	private static void Question18() {
		Path path1 = Paths.get("a");
		Path path2 = Paths.get("b");

		System.out.println(path1.resolve(path2));
		System.out.println(path1.relativize(path2));

	}

	private static void Question19() {
		// TODO Auto-generated method stub

	}

	private static void Question20() {
		// TODO Auto-generated method stub

	}

	public static void Question21() throws Exception {

	}

	private static void Question22() {
		IntStream intStream = IntStream.range(1, 6);
		OptionalInt sum = intStream.reduce((a, b) -> a + b);
		System.out.println("OptionalInt:" + sum);

		System.out.println(IntStream.range(1, 6).reduce((a, b) -> a + b).orElse(0));

		System.out.println(IntStream.range(1, 6).average().orElse(0));

		IntStream intStream2 = IntStream.range(1, 6);
		long count = intStream2.count();
		// System.out.println(intStream2.average().orElse(0) * count);
		// //java.lang.IllegalStateException: stream has already been operated
		// upon or closed

	}

	private static void Question23() {
		List<String> letters = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

		for (String letter : letters) {
			System.out.println(letter.compareTo("c") > 0);
		}

		String newLetters = letters.stream().filter(s -> s.compareTo("b") > 0).collect(Collectors.joining("-"));

		System.out.println(newLetters);

		letters.stream().forEach(System.out::println);

	}

	private static void Question24() {
		List<Character> list = new ArrayList<>();

		for (char c = 'z'; c >= 'a'; c--) {
			list.add(c);
		}

		System.out.println(list);

		long amount = list.stream().filter(c -> c.compareTo('u') > 0).count();

		System.out.println(amount);

	}

	private static void Question25() {
		List<AtomicBoolean> bools = Arrays.asList(new AtomicBoolean(false), new AtomicBoolean(true));
		bools.stream().filter(b -> {
			System.out.println("1" + b);
			return b.get();
		}).forEach(b -> System.out.println("2:" + b));

	}

	private static void Question26() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		double sum = list.stream().mapToInt(x -> x).sum();
		System.out.println("Q26: " + sum);
		double sum2 = list.stream().mapToDouble(x -> x).sum();
		System.out.println("Q26: " + sum2);

		Optional<Integer> sum3 = list.stream().reduce((x, y) -> x + y);
		System.out.println("Q26: " + sum3);

		double sum4 = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Q26: " + sum4);

		final double sum5;
		// list.stream().forEach(x -> {sum5 += x;});

	}

	private static void Question27() {
		List<Book> books = Arrays.asList(new Book("Atlas Shrugged", 50.0, "Ayn Rand"),
				new Book("Great Expectations", 30.0, "Charles Dickens"),
				new Book("Oliver Twist", 30.0, "Charles Dickens"), new Book("The Fountainhead", 40.0, "Ayn Rand"));

		books.stream().filter(b -> b.getAuthor().equals("Ayn Rand"))
				.collect(Collectors.toMap(Book::getTitle, b -> b.getPrice()))
				.forEach((k, v) -> System.out.println(k + ": " + v));

	}

	private static void Question28() {
		System.out.println(IntStream.range(3, 1).parallel().findFirst().orElse(0));

	}

	private static void Question29() {
		List<String> strings = Arrays.asList("a", "b", "c", "d");
		List<String> strings2 = Arrays.asList("a", "b", "c", "d");
		List<Integer> integers = Arrays.asList(1, 2, 3, 4);

		Stream.of(strings, integers).flatMap(e -> Stream.of(e)).forEach(System.out::println);

	}

	private static void Question30() {
		List<Integer> integers = Arrays.asList(1, 3, 5);
		Optional<Integer> optional = Optional.of(integers.stream().filter(i -> i % 2 == 0).reduce((i, j) -> i + j));
		System.out.println(optional.get());

	}

	public static void Question31() throws Exception {

		List<Movie> movies = Arrays.asList(new Movie("The Godfather", 9.5), new Movie("The Transporter", 8.5));

		movies.stream().peek(System.out::println).filter(m -> m.getRating() > 9.0)
				.forEach(m -> System.out.println(m.getTitle()));

	}

	private static void Question32() {
		List<Book> books = Arrays.asList(new Book("Atlas Shrugged", 50.0, "Ayn Rand"),
				new Book("Great Expectations", 30.0, "Charles Dickens"),
				new Book("Oliver Twist", 30.0, "Charles Dickens"), new Book("The Fountainhead", 40.0, "Ayn Rand"));

		List<String> titles = new ArrayList<>();

		// books.stream().map(Book::getTitle).collect(Collectors.toList(titles));

		titles = books.stream().map(Book::getTitle).collect(Collectors.toList());

		System.out.println(titles);

		// titles = books.stream().map(Book::getTitle).forEach(x ->
		// titles.add(x));

	}

	private static void Question33() {
		List<Integer> list = Arrays.asList(-2, -1, 0, 1, 2);

		Predicate<Integer> positive = i -> {
			System.out.println("pos: " + i);
			return i > 0;
		};

		Predicate<Integer> negative = i -> {
			System.out.println("neg:" + i);
			return i < 0;
		};

		// list.stream().filter(positive).forEach(System.out::println);

		list.stream().filter(positive).allMatch(negative);

	}

	private static void Question34() {
		// TODO Auto-generated method stub

	}

	private static void Question35() {
		// TODO Auto-generated method stub

	}

	private static void Question36() {
		// TODO Auto-generated method stub

	}

	private static void Question37() {
		System.out.println("Q37");
		List<Integer> list = Arrays.asList(13, 58, 9, 54);
		int max1 = list.stream().reduce((a, b) -> a < b ? a : b).get();
		System.out.println(max1);
		int max2 = list.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
		System.out.println(max2);

		int max3 = list.stream().max(Comparator.comparing(a -> a)).get();
		System.out.println(max3);

		int max4 = list.stream().max(Comparator.comparingInt(a -> a)).get();
		System.out.println(max4);
	}

	private static void Question38() {
		System.out.println("Q38");

		List<Person> people = Arrays.asList(new Person("Peter", "Cheung"), new Person("Carrie", "Plummer"));

		FullName func = p -> System.out.println(p.getFirstName() + " " + p.getLastName());

		people.forEach(p -> func.getFullName(p));
	}

	private static void Question39() {
		System.out.println("Q39");
		class MyApp {
			public void main(String[] args) {
				Validator validator = new Validator(true);
				// System.out.println(new MyApp().validate(validator, validator
				// -> validator.isValid()));

			}

			boolean validate(Validator validator, Predicate<Validator> predicate) {
				return predicate.test(validator);
			}

		}

	}

	private static void Question40() {
		System.out.println("Q40");

		List<Integer> list = Arrays.asList(1, 2, 3, 4);

		list.forEach(i -> {
			i *= 2;
			System.out.println(i);
		});

	}

	public static void Question41() throws Exception {

	}

	private static void Question42() {
		System.out.println("Q42");

		List<Integer> list = Arrays.asList(14, 27, 18, 2);

		System.out.println(list.stream().max(Integer::max).get());
		System.out.println(list.stream().max((a, b) -> a > b ? a : b));

		System.out.println(list.stream().max(Comparator.comparingInt(a -> a)).get());

		System.out.println(list.stream().reduce(Integer.MAX_VALUE, (a, b) -> a > b ? a : b));

	}

	private static void Question43() {
		System.out.println("Q43");

		List<String> list = Arrays.asList("a", "b", "c");

		list.stream().forEach(s -> s.toUpperCase());
		list.stream().forEach(System.out::print);

		list.forEach(s -> s.toUpperCase());
		list.stream().forEach(System.out::print);

		System.out.println("");

	}

	static int calculate(List<String> list, Function<List<String>, Integer> func) {
		return func.apply(list);

	}

	private static void Question44() {
		System.out.println("Q44");

		List<String> list = Arrays.asList("a", "b", "c");

		System.out.println(calculate(list, s -> s.indexOf("b")));
		// System.out.println(calculate(list, list -> list.size()));

		// System.out.println(calculate(list, s -> s.add("b")));

	}

	private static void Question45() {
		System.out.println("Q45");

		List<String> list = Arrays.asList(null, "null");

		for (String s : list) {
			switch (s) {
			case "null":
				System.out.println("null");
				break;
			default:
				System.out.println("not null");
			}
		}

	}

	private static void Question46() {
		// TODO Auto-generated method stub

	}

	private static void Question47() {
		System.out.println("Q47...");
		try (MyResource resource = new MyResource()) {
			resource.open();
			resource.read();
			resource.close();

		} catch (Exception ex) {
			System.out.println("Exception caught");
		}

	}

	private static void Question48() {
		// TODO Auto-generated method stub

	}

	private static void Question49() {
		// TODO Auto-generated method stub

	}

	private static void Question50() {
		System.out.println("Q50");
		try (BufferedReader reader = new BufferedReader(new FileReader("non-existent.txt"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Question51() throws Exception {
		System.out.println("Q51");
		System.out.println(
				LocalDate.now().withMonth(11).withDayOfMonth(1).with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));

		System.out.println(LocalDate.now().withMonth(11).withDayOfMonth(1)
				.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).plusDays(1));

		System.out.println(LocalDate.now().withMonth(11).with(TemporalAdjusters.firstDayOfMonth())
				.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).plusDays(1));

		System.out.println(TemporalAdjusters.next(DayOfWeek.TUESDAY)
				.adjustInto(LocalDate.now().withMonth(11).with(TemporalAdjusters.firstDayOfMonth())));

	}

	private static void Question52() {
		System.out.println(
				"You should always create a default properties file. The name of this file begins with the base name of your ResourceBundle and ends with the .properties ");

	}

	private static void Question53() {
		System.out.println("Q53");
		LocalDateTime dateTime = LocalDateTime.parse("2017-09-24T11:30:15", DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(dateTime);
		// System.out.println(dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

	}

	private static void Question54() {

		NumberFormat nf = NumberFormat.getInstance(Locale.US);

	}

	private static void Question55() {
		System.out.println("Q55");
		SimpleDateFormat df = new SimpleDateFormat("MMMMMMMMM", Locale.US);
		System.out.println(df.format(new Date()));

	}

	private static void Question56() {

		System.out.println("Q56");

		ZonedDateTime timeBeforeChange = ZonedDateTime.of(LocalDateTime.of(2017, Month.MARCH, 12, 2, 29),
				ZoneId.of("US/Pacific"));
		ZonedDateTime timeAfterChange = ZonedDateTime.of(LocalDateTime.of(2017, Month.MARCH, 12, 3, 0),
				ZoneId.of("US/Pacific"));

		System.out.println(ChronoUnit.MINUTES.between(timeBeforeChange, timeAfterChange));

	}

	private static void Question57() {
		// DateFormat df = new DateFormat(Locale.US);
		// Cannot instantiate the type DateFormat

		// DateFormat df2 = DateFormat.getDateInstance(Locale.US);
		// d getDateInstance(int) in the type DateFormat is not applicable for
		// the arguments (Locale)

		// DateFormat df3 = DateFormat.getDateInstance();
		// df3.setLocale(Locale.US);
		// The method setLocale(Locale) is undefined for the type DateFormat
	}

	private static void Question58() {
		System.out.println(Paths.get("\\a", "\\b", "file.txt"));

	}

	private static void Question59() {

		System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDateTime.now()));
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));

	}

	private static void Question60() {
		Period period = Period.ofDays(60);

		Duration duration = Duration.ofDays(60);

		System.out.println(period + " " + duration);

	}

}
