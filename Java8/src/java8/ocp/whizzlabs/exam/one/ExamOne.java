/**
 * 
 */
package java8.ocp.whizzlabs.exam.one;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java8.ocp.whizzlabs.exam.Movie;
import java8.ocp.whizzlabs.exam.Person;
import java8.ocp.whizzlabs.exam.Student;

/**
 * @author Pete
 *
 */
public class ExamOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<Student> students = Arrays.asList(new Student("Alison", Student.Faculty.MEDICINE, 7.0),
				new Student("Bob", Student.Faculty.MEDICINE, 9.0),
				new Student("Christine", Student.Faculty.ENGINEERING, 8.0),
				new Student("Daniel", Student.Faculty.ENGINEERING, 8.0));

		ToDoubleFunction<Student> markFunc = Student::getMark;
		// System.out.println(markFunc);
		students.stream().collect(Collectors.groupingBy(Student::getFaculty)).forEach((a, b) -> {
			double average = b.stream().collect(Collectors.averagingDouble(markFunc));
			System.out.println(average);
		});

		Question1();

		Question4();

		Question6();

		Question10();

		Question11();

		Question13();

		Question14();

		Question16();

		Question18();

		Question19();

		Question20();

		// Question21();

		Question22();

		Question26();

		Question27();

		Question30();

		Question31();

		Question33();

		Question34();

		Question37();

		Question38();

		Question41();

		Question42();

		Question43();

		Question44();

		Question45();

		Question47();

		Question48();

		Question49();

		Question51();

		Question53();

		Question54();

		Question57();

		Question59();

	}

	public static void Question1() throws Exception {
		LocalTime now = LocalTime.now();
		LocalTime earlierTime = LocalTime.of(8, 30).withMinute(now.getMinute());
		LocalTime laterTime = LocalTime.of(12, 30).withMinute(now.getMinute());
		long timePassed = now.until(earlierTime, ChronoUnit.HOURS);
		long timeToPass = now.until(laterTime, ChronoUnit.HOURS);
		System.out.println("Q1: " + timePassed + " " + timeToPass);

		Lock lock = new ReentrantLock();
		if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
			try {
				lock.lock();
				System.out.println("I am a lock");
			} finally {
				lock.unlock();
			}

		}

		// try (FileReader fileReader = new FileReader("file.txt"); FileWriter
		// fileWriter = new FileWriter("file.txt")) {
		// throw new IOException();
		// }

	}

	public static void Question4() throws Exception {

		System.out.println("Q4...");

		int _123 = 123;
		System.out.println("int _123 = 123 ; " + _123);
		int x = 1_2_3;
		System.out.println("int x = 1_2_3 ; " + x);
		int y = _123;
		System.out.println("int y = _123 ; " + y);

		long z = 0x123F_F;
		System.out.println("long z = 0x123F_F ; " + z);

	}

	public static void Question6() throws Exception {
		System.out.println("Q6");
		DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
		System.out.println(
				"DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault()) = " + df.format(new Date()));

		df = DateFormat.getDateInstance();
		System.out.println("DateFormat.getDateInstance() = " + df.format(new Date()));

		df = DateFormat.getDateInstance(DateFormat.DEFAULT);

		System.out.println("DateFormat.getDateInstance(DateFormat.DEFAULT) = " + df.format(new Date()));

	}

	public static void Question10() {
		System.out.println("Q10");
		List<String> names = Arrays.asList("a", "b", "cd", "ef", "ghij");
		Map<Integer, String> data = names.stream().collect(Collectors.groupingBy(String::length, Collectors.joining()));
		System.out.println(data.values());

	}

	public static void Question11() {
		System.out.println("Q11");

		AtomicInteger map = new AtomicInteger(3);

		int oldValue = map.get();
		int newValue = 3;
		System.out.println("map.compareAndSet(3, 3)");
		map.compareAndSet(oldValue, newValue);
		System.out.println(map.get());
		System.out.println("map.addAndGet(3)");
		map.addAndGet(newValue);
		System.out.println(map.get());
		System.out.println("map.updateAndGet(s -> s * s)");
		map.updateAndGet(s -> s * s);
		System.out.println(map.get());
		System.out.println("map.incrementAndGet()");
		map.incrementAndGet();
		System.out.println("map.getAndDecrement()");
		map.getAndDecrement();
		System.out.println(map.get());

	}

	public static void Question13() {
		System.out.println("Q13");
		LocalDate d1 = LocalDate.of(1970, 1, 1);
		System.out.println(d1);
		LocalDate d2 = LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE);
		System.out.println(d2);
		LocalDate d3 = LocalDate.now().withDayOfMonth(1).withMonth(1).withYear(1970);
		System.out.println(d3);

		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));
		System.out.println(d2.equals(d3));

	}

	public static void Question14() {

		LocalDate lastYear = LocalDate.now().minus(Period.of(1, 0, 0));
		System.out.println(lastYear);
		LocalDate lastYear2 = LocalDate.now().minus(1, ChronoUnit.YEARS);
		System.out.println(lastYear2);
		LocalDate lastYear3 = LocalDate.now().minus(365, ChronoUnit.DAYS);
		System.out.println(lastYear3);
		LocalDate lastYear4 = LocalDate.now().minusYears(1);
		System.out.println(lastYear4);

	}

	public static void Question16() {
		System.out.println("Q16");

		List<Person> people = Arrays.asList(new Person("Andrew", Person.GENDER.MALE),
				new Person("Beatrice", Person.GENDER.FEMALE), new Person("Chris", Person.GENDER.MALE),
				new Person("Diana", Person.GENDER.FEMALE));

		try {
			System.out.println(people.stream().collect(Collectors.toMap(Person::getGender, Person::getName)));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void Question17() {

		Predicate<Integer> even = (Integer i) -> i % 2 == 0;
		// Predicate even2 = (Integer i) -> i %2 == 0;
		// Predicate even3 = (Integer i) -> i % 2 == 0;
		Predicate even4 = i -> (Integer) i % 2 == 0;

	}

	public static void Question18() {
		System.out.println("Q18 ...");

		LocalDateTime localDateTime = LocalDateTime.of(2016, Month.NOVEMBER, 6, 12, 0);
		ZonedDateTime dateTime1 = ZonedDateTime.of(localDateTime, ZoneId.of("US/Pacific")).plus(Period.ofDays(1));
		ZonedDateTime dateTime2 = ZonedDateTime.of(localDateTime, ZoneId.of("US/Pacific")).plus(Duration.ofDays(1));

		System.out.println(dateTime1.getHour());
		System.out.println(dateTime2.getHour());

	}

	public static void Question19() {
		System.out.println("Q19 ...");
		Map<String, String> countries = new HashMap<>();
		countries.put("America", "US");
		countries.put("Europe", "Germany");

		countries.merge("Europe", "France", (i1, i2) -> i1 + i2);

		System.out.println(countries);

		countries.merge("Africa", "South Africa", String::concat);

		System.out.println(countries);

		countries.merge("America", "Canada", String::concat);

		System.out.println(countries);

	}

	public static void Question20() {
		System.out.println("Q20...");
		Stream<String> stream = Arrays.stream(new String[] { "a", "b", "c", "d" });

		System.out.println("a".compareTo("abc"));
		System.out.println("b".compareTo("abc"));
		System.out.println("c".compareTo("abc"));
		System.out.println("d".compareTo("abc"));

		String output = stream.filter(s -> {
			if (s.compareTo("abc") > 0)
				return true;
			else
				return false;
		}).peek(System.out::println).collect(Collectors.joining());
		System.out.println(output);

	}

	public static void Question21() throws IOException {

		BufferedWriter writer1 = Files.newBufferedWriter(Paths.get("file1.txt"),
				new OpenOption[] { StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE });

		BufferedWriter writer2 = Files.newBufferedWriter(Paths.get("file2.txt"),
				new OpenOption[] { StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE_NEW });

		BufferedWriter writer3 = Files.newBufferedWriter(Paths.get("file3.txt"),
				new OpenOption[] { StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE });

		BufferedWriter writer4 = Files.newBufferedWriter(Paths.get("file4.txt"),
				new OpenOption[] { StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.APPEND });

		BufferedWriter writer5 = Files.newBufferedWriter(Paths.get("file5.txt"),
				new OpenOption[] { StandardOpenOption.TRUNCATE_EXISTING });

	}

	public static void Question22() throws IOException {

		System.out.println("Q22");

		Locale locale = Locale.getDefault();
		System.out.println(locale.getCountry() + " " + locale.getLanguage() + System.lineSeparator());

		// DateFormat dfFormat1 = DateFormat.getInstance(DateFormat.DEFAULT);
		DateFormat dfFormat1 = DateFormat.getDateInstance(DateFormat.DEFAULT);
		System.out.println(locale + " " + dfFormat1.format(new Date()));

		DateFormat dfFormat2 = DateFormat.getDateInstance();
		System.out.println(locale + " " + dfFormat2.format(new Date()));

		DateFormat dfFormat3 = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.US);
		System.out.println(locale + " " + dfFormat3.format(new Date()));

	}

	public static void Question24() throws IOException {

		System.out.println("Q24");

	}

	public static void Question26() {
		// LocalDate date = new LocalDate();

		// LocalDate date2 = LocalDate.parse("2017-1-1");
		// System.out.println(date2);

		LocalDate date3 = LocalDate.of(2017, 1, 1);
		System.out.println(date3);

		LocalDate date4 = LocalDate.of(2017, Month.JANUARY, 1);
		System.out.println(date4);

		// LocalDate date5 = LocalDate.of(2017, "JANUARY", 1);
		// System.out.println(date5);

		// LocalDate date6 = LocalDate.of(2017, 1);
		// System.out.println(date6);

	}

	public static void Question27() {

		System.out.println("Q27...");

		Stream.of("Hot", "Yellow", "Shining").map(e -> e.concat("sun")).forEach(System.out::println);

		// Stream.of("Hot", "Yellow", "Shining").join(e ->
		// e.concat("sun")).forEach(System.out::println);

		// Stream.of("Hot", "Yellow",
		// "Shining").peek(System.out::println).collect(Collectors.joining());

		// Stream.of("Hot", "Yellow",
		// "Shining").collect(Collectors.mapping(String::concat, "sun"));

	}

	public static void Question30() {

		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));

		List<Set<Integer>> list = new ArrayList<>(Arrays.asList(set1, set2));

		Optional<?> data = list.stream().flatMap(s -> s.stream()).reduce(Integer::sum);

		System.out.println(data.get());

	}

	public static void Question31() {

		System.out.println("Calc 1,2,3,4 = " + calculate(Arrays.asList(1, 2, 3, 4), (i, j) -> i + j));
		System.out.println("Calc 1,2,3,4 = " + calculate(Arrays.asList(1, 2, 3, 4), (Integer i, Integer j) -> i + j));
		System.out.println("Calc 1,2,3,4 = " + calculate(Arrays.asList(1, 2, 3, 4), (Integer i, Integer j) -> {
			return i + j;
		}));

	}

	static int calculate(List<Integer> intList, BiFunction<Integer, Integer, Integer> biFunc) {
		if (intList.isEmpty()) {
			return 0;
		} else if (intList.size() == 1) {
			return intList.get(0);
		}

		int result = intList.get(0);
		for (int i = 1; i < intList.size(); i++) {
			result = biFunc.apply(result, intList.get(i));
		}
		return result;

	}

	public static void Question34() {

		System.out.println("Q34");

		Student student1 = new Student("Alice", Student.Department.BUSINESS, Student.Gender.FEMALE);
		Student student2 = new Student("Bob", Student.Department.BUSINESS, Student.Gender.MALE);
		Student student3 = new Student("Carmen", Student.Department.TECHNICAL, Student.Gender.FEMALE);
		Student student4 = new Student("Daniel", Student.Department.TECHNICAL, Student.Gender.MALE);

		List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4));

		Map<Student.Gender, Map<Student.Department, List<Student>>> groups = students.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.groupingBy(Student::getDepartment)));

		System.out.println(groups);

	}

	public static void Question33() {

		MyClass c = new MyClass<>(0, "", null);

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

		list.parallelStream().peek(System.out::println).forEachOrdered(System.out::println);

		System.out.println(new SimpleDateFormat("YY-MM-dd").format(new Date()));

	}

	public static void Question37() {
		System.out.println("Q37");

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		list.parallelStream().peek(System.out::print).forEachOrdered(System.out::print);
		System.out.println();

	}

	public static void Question38() {
		System.out.println("Q38");

		System.out.println(new SimpleDateFormat("yy-MM-dd").format(new Date()));

	}

	public static void Question41() {

		System.out.println("Q41");

		List<Student> students = Arrays.asList(new Student("Alison", Student.Faculty.MEDICINE, 8.0),
				new Student("Bob", Student.Faculty.ENGINEERING, 6.0),
				new Student("Christine", Student.Faculty.ENGINEERING, 6.0),
				new Student("Daniel", Student.Faculty.MEDICINE, 8.0));

		try {
			double avg = students.stream()
					.filter(s -> s.getFaculty() == Student.Faculty.ENGINEERING && s.getMark() >= 7.0)
					.mapToDouble(s -> s.getMark()).average().getAsDouble();

			students.stream().filter(s -> s.getFaculty() == Student.Faculty.ENGINEERING && s.getMark() >= 8.0)
					.map(s -> s.getName()).forEach(System.out::println);

			System.out.println(avg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void Question42() {

		System.out.println("Q42");

		System.out.println("0 % 2 =" + 0 % 2);
		System.out.println("1 % 2 =" + 1 % 2);

		System.out.println();

		System.out.println(IntStream.range(0, 1).allMatch(i -> i % 2 == 0));
		System.out.println(IntStream.range(0, 1).anyMatch(i -> i % 2 == 0));
		System.out.println(IntStream.range(0, 1).noneMatch(i -> i % 2 == 0));

		System.out.println("rangeClosed");

		System.out.println(IntStream.rangeClosed(0, 1).allMatch(i -> i % 2 == 0));
		System.out.println(IntStream.rangeClosed(0, 1).anyMatch(i -> i % 2 == 0));
		System.out.println(IntStream.rangeClosed(0, 1).noneMatch(i -> i % 2 == 0));

	}

	public static void Question43() {
		System.out.println("Q43");

		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(Arrays.asList("a", "b"));

		new Thread() { // thread 1
			@Override
			public void run() {
				Iterator<String> it = list.iterator();
				it.next();
				list.remove(0);
				System.out.println(list);
			}

		}.start();

		new Thread() { // thread 2
			@Override
			public void run() {
				Iterator<String> it = list.iterator();
				it.next();
				list.add("c");
				System.out.println(list);
			}

		}.start();

	}

	public static void Question44() {

		Path path = Paths.get("src" + File.separator + "main" + File.separator + "java" + File.separator + "package");

		System.out.println(path.getRoot() + " " + path.getParent() + " " + path.getName(3));

	}

	public static void Question45() {

		System.out.println("Q45");

		int base = 2;
		System.out.println(calculate(base, x -> base * x.longValue()));
		// System.out.println(calculate(base, x -> base * x));

	}

	static long calculate(int base, Function<Integer, Long> func) {
		return func.apply(base);
	}

	public static void Question47() {

		System.out.println("Q47");

		Period period = Period.between(LocalDate.of(2016, 2, 3), LocalDate.of(2016, Month.JANUARY, 1));
		System.out.println(period);
		Duration duration = Duration.between(LocalTime.of(1, 2, 3), LocalDateTime.of(2016, Month.JANUARY, 1, 1, 1, 1));
		// This calculates the duration between two temporal objects. If the
		// objects are of different types, then the duration is calculated based
		// on the type of the first object. For example, if the first argument
		// is a LocalTime then the second argument is converted to a LocalTime.
		System.out.println(duration);

	}

	public static void Question48() {

		System.out.println("Q48");

		List<Integer> initialList = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {

			initialList.add(i);
		}

		List<Integer> finalList = initialList.stream().filter(i -> i % 2 == 0).filter(i -> i % 3 == 0)
				.filter(i -> i % 5 == 0).filter(i -> i % 7 == 0).collect(Collectors.toList());

		System.out.println(finalList);

	}

	public static void Question49() {

		System.out.println("Q49");

		try (FileReader reader = new FileReader("C:\\Users\\Pete\\exam\\file.txt");
				FileWriter writer = new FileWriter("C:\\Users\\Pete\\exam\\fileExamOne.txt");) {
			throw new IOException();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void Question51() {
		System.out.println("Q51");

		double amount = 12.34;
		NumberFormat nf = new DecimalFormat("\u0024#.00");
		System.out.println(nf.format(amount));
		Format f = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(f.format(amount));
	}

	public static void Question53() {
		System.out.println("Q53 ....");

		double benchMark = 60;
		System.out.println("Benchmark: " + benchMark);

		List<Movie> movies = new ArrayList<>(Arrays.asList(new Movie("Casino Royale", 40.0),
				new Movie("Quantum Of Solace", 40.0), new Movie("SkyFall", 60.0), new Movie("Spectre", 60.0)));

		// movies.stream().filter(b -> b.getTicketPrice() > benchMark).forEach(s
		// -> System.out.println(s.getTitle()));

		double avgPrice = movies.stream().filter(b -> b.getTicketPrice() > benchMark)
				.mapToDouble(b -> b.getTicketPrice()).average().orElse(50);

		System.out.println("Average Ticket Price: " + avgPrice);

	}

	public static void Question54() {
		System.out.println("Q54");

		Student student = new Student("Bob", Student.Faculty.MEDICINE, 6.0);

		Consumer<Student> consumerfFunc = p -> System.out.println(p.getName());

		consumerfFunc.accept(student);

		Consumer<Student> consumerfFunc2 = p -> {
			System.out.println(p.toString());
		};

		consumerfFunc2.accept(student);

	}

	public static void Question57() {
		System.out.println("Q57");
		System.out.println("Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).distinct()");
		System.out.println(Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).distinct());
		System.out.println("Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).limit(1)");
		System.out.println(Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).limit(1));
		System.out.println("Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).sorted()");
		System.out.println(Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).sorted());

		System.out.println("Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).count()");
		System.out.println(Stream.of(1, 2, 3, 4).map(a -> a + 1).peek(System.out::print).count());

	}

	public static void Question58() {

		System.out.println("Q58");
		CopyOnWriteArrayList<MyClass> myClassList = new CopyOnWriteArrayList<>();
		myClassList.add(null);
		myClassList.add(new MyClass(new Object(), "String", new Object()));

	}

	public static void Question59() {
		System.out.println("Q59");

		DateFormat df = new SimpleDateFormat("d MMM ''yy");
		System.out.println(df.format(new Date()));

	}

}
