/**
 * 
 */
package java8.ocp.whizzlabs.exam.six;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java8.ocp.whizzlabs.exam.Student;

/**
 * @author Pete
 *
 */
public class ExamSix {

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

	public static void Question1() {
		System.out.println("Q1");
		Stream<String> list = Stream.of("BB", "CCC", "AB", "CCC", "BB");
		System.out.println(list.collect(Collectors.toSet()));

	}

	private static void Question2() {
		// System.out.println("Q2");

	}

	private static void Question3() {
		// System.out.println("Q3");

	}

	private static void Question4() {
		System.out.println("Q4");
		String[] s = new String[2];
		s[1] = "B";

		ConcurrentHashMap<Integer, String> cmap = new ConcurrentHashMap<Integer, String>();
		cmap.put(1, "livera");
		cmap.putIfAbsent(2, "sharma");
		cmap.put(3, "naveen");
		System.out.println(cmap.put(3, "kumar"));
		cmap.putIfAbsent(1, "sanka");

		System.out.println(cmap);

	}

	private static void Question5() {
		System.out.println("Q5");
		List<String> list = new ArrayList<>();
		list.add("and");
		list.add("ant");
		list.add("animal");
		list.add("Ant");
		list.add("an");

		list.removeIf(s -> s.startsWith("an"));

		System.out.println(list);

	}

	private static void Question6() {
		System.out.println("Q6");
		java.util.Map<String, String> map = new HashMap<>();
		System.out.println("map.replace() since 1.8");

	}

	private static void Question7() {
		System.out.println("Q7");
		java.util.Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");

		map.remove("A");
		map.remove(3, "C");
		map.remove(4, "B");
		map.values().forEach(System.out::print);

	}

	private static void Question8() {
		System.out.println("\nQ8");
		java.util.Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");

		/*
		 * System.out.println("Values");
		 * map.values().forEach(System.out::print);
		 * System.out.println("\nKeys");
		 * map.keySet().forEach(System.out::print);
		 * 
		 * System.out.println();
		 */

		map.compute(3, (k, v) -> v.equals("C") ? null : "A");
		System.out.println("Values");
		map.values().forEach(System.out::print);
		System.out.println("\nKeys");
		map.keySet().forEach(System.out::print);

		System.out.println();

	}

	private static void Question9() {
		System.out.println("Q9");
		java.util.Map<String, Integer> map = new HashMap<>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		map.put("5", 5);
		map.merge("4", 4, (k, v) -> v > 0 ? null : 0);
		System.out.println("If the function returns null the mapping is removed. ");
		System.out.println(map.keySet());

	}

	private static void Question10() {
		System.out.println("Q10");

		Stream<String> stream = Stream.of("Java", "OCAJP", "OCAJP");
		// IntStream ins = stream.map(s -> s.length());
		IntStream ins = stream.mapToInt(s -> s.length());
		ins.forEach(System.out::print);
		System.out.println();

	}

	public static void Question11() {
		System.out.println("Q11");
		Stream<Student> students = Stream.of(new Student("Bud"), new Student("Liv"), new Student("Sam"));

		Stream<String> names = students.map(s -> s.getName());

		names.forEach(s -> System.out.println(s));
	}

	private static void Question12() {
		System.out.println("Q12");

		System.out.println(
				"Map \nReturns a stream consisting of the results of applying the given function to the elements of this stream. \n"
						+ "This is an intermediate operation. \n"
						+ "Type Parameters:<R> The element type of the new stream\nParameters:mapper a non-interfering, stateless function to apply to each element\n");

	}

	private static void Question13() {
		System.out.println("Q13");

		DoubleStream stream = DoubleStream.of(2, 4, 6, 1, 5, 9);

		OptionalDouble avg = stream.average();

		System.out.println("Average OptionalDouble = " + avg.orElse(0));

	}

	private static void Question14() {
		System.out.println("Q14");

		Stream<Integer> ints = Stream.of(10, 5, 22, 4, 12);

		System.out.println("ints.noneMatch(i -> i < 4) : " + ints.noneMatch(i -> i < 4));

	}

	private static void Question15() {
		System.out.println("Q15");

		Stream<String> list = Stream.of("ABC", "aBB", "AbCC", "ab", "acC");

		Map<Boolean, List<String>> map = list.collect(Collectors.partitioningBy((String s) -> s.startsWith("ab")));

		System.out.println(map);

	}

	private static void Question16() {
		System.out.println("Q16");
		Stream<String> list = Stream.of("abc", "ab");
		System.out.println(list.max((s1, s2) -> Integer.compare(s2.length(), s1.length())).get());

	}

	private static void Question17() {
		System.out.println("Q17");

		DoubleStream stream = DoubleStream.of(2.0, 4.1, 6.0, 1.4);
		System.out.println(stream.skip(1).limit(3).findFirst());

	}

	private static void Question18() {
		System.out.println("Q18");
		Stream<String> list = Stream.of("A", "B", "C");
		boolean b = list.peek(System.out::print).allMatch(s -> s.length() == 1);
		System.out.println(b);

	}

	private static void Question19() {
		System.out.println("Q19");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("ab");

		list.stream().forEach(s -> System.out.println("Length:" + s.length()));
		// list.forEach(System.out::println);

	}

	private static void Question20() {
		System.out.println("Q20 - see Ttest.class");

	}

	public static void Question21() throws IOException {
		System.out.println("Q21");

		File f = new File("C:\\Users\\Pete\\exam\\file.txt");

		List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath()));

		lines.forEach(System.out::println);

	}

	private static void Question22() throws IOException {
		System.out.println("Q22");

		File f = new File("C:\\Users\\Pete\\exam\\file.txt");

		Stream<String> lines2 = Files.lines(f.toPath());

		lines2.skip(1).forEach(System.out::println);

	}

	private static void Question23() {
		System.out.println("Q23");

		Path path1 = Paths.get("F:\\Users\\Pete\\exam\\");
		System.out.println(path1.subpath(0, 3).toString());
		Path path2 = Paths.get("C:\\Users\\Pete\\nodir\\");

		Path path = Paths.get(path2.getRoot().toString(), path1.subpath(0, 3).toString());

		System.out.println(path.toString());

	}

	private static void Question24() throws IOException {
		System.out.println("Q24");

		File f = new File("C:\\Users\\Pete\\exam\\file.txt");

		Path path1 = f.toPath();
		Path path2 = Paths.get("..\\fileCopy" + System.currentTimeMillis() + ".txt");
		Path success = Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println(success.toFile().exists());
		System.out.println(success.toFile().getAbsolutePath());

	}

	private static void Question25() {
		System.out.println("Q25");
		System.out.println("Path extends Watchable interface in java.nio.file package");

	}

	private static void Question26() {
		System.out.println("Q26");

		System.out.println("Cannot instatiate FileVisitor class");

	}

	private static void Question27() {
		// System.out.println("Q27");

	}

	private static void Question28() {
		System.out.println("Q28");

		IntStream ints = IntStream.rangeClosed(1, 5);
		ints.forEach(s -> System.out.print(s));
		System.out.println(" >> IntStream.rangeClosed(1, 5)");

	}

	private static void Question29() {
		System.out.println("Q29");
		double[] arr = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		DoubleStream dbs = Arrays.stream(arr, 3, 5);
		dbs.forEach(s -> System.out.println(s));
		DoubleStream dbs2 = Arrays.stream(arr, 3, 5);
		System.out.println("Sum : " + dbs2.sum());

	}

	private static void Question30() {
		System.out.println("Q30");
		IntStream ints = IntStream.of(10, 20, 30, 40);
		IntSummaryStatistics stat = ints.summaryStatistics();
		System.out.println(stat.getSum());
		// stat.accept(stat.getCount());
		stat.accept((int) stat.getCount());
		System.out.println(stat.getSum());

	}

	public static void Question31() {
		System.out.println("Q31");
		Stream<String> ints = Stream.of("A", "B", "C", "D");

		long count = ints.peek(System.out::println).skip(2).count();
		// System.out.println(count);

	}

	private static void Question32() {
		System.out.println("Q32");
		System.out.println(
				" A stream pipeline consists of a source (which might be an array, a collection, \n a generator function, an I/O channel, etc), \n zero or more intermediate operations (which transform a stream into another stream, such as filter(Predicate)), \n and a terminal operation (which produces a result or side-effect, such as count() or forEach(Consumer)). ");

	}

	private static void Question33() {
		System.out.println("Q33");
		String[] list = { "1", "2", "3" };

		Arrays.parallelSetAll(list, x -> Integer.toString(x) + list[x]);
		System.out.println("Array length; " + list.length);
		System.out.println("List[0]; " + list[0]);

	}

	private static void Question34() {
		System.out.println("Q34");
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(1);
		list.add(3);
		// Stream<Integer> stream = list.parallel();
		Stream<Integer> stream = list.parallelStream();
		System.out.println("stream.isParallel() : " + stream.isParallel());

	}

	private static void Question35() {
		System.out.println("Question35");
		Stream<Integer> list = Stream.of(0, 1, 2).parallel();
		System.out.println("list.peek(System.out::println).count() : " + list.peek(System.out::println).count());

	}

	private static void Question36() {
		System.out.println("Question36");

		Fun<Integer> fun = System.out::println;

		List<Integer> list = Arrays.asList(1, 2, 3);

		// list.stream().forEach(s -> fun(s));

	}

	private static void Question37() {
		System.out.println("Question37");
		Map<Integer, Double> map = new HashMap<>();
		map.put(1, 1.1);
		map.put(2, 2.2);
		map.put(1, 3.3);

		ToDoubleBiFunction<Double, Integer> tdf = (a, b) -> a + b;
		map.forEach((k, v) -> System.out.println(tdf.applyAsDouble(v, k)));

	}

	private static void Question38() {
		System.out.println("Question38");
		Stream<String> stream = Stream.of("A", "B", "C");
		System.out.println();

	}

	private static void Question39() {
		System.out.println("Question39");

	}

	private static void Question40() {
		System.out.println("Question40");

		Stream<String> stream = Stream.of("A", "B", "C");
		System.out.println(stream.limit(1).skip(1).findAny());
	}

	public static void Question41() {
		System.out.println("Question41");
		ToDoubleBiFunction<Integer, Integer> ob = (f1, f2) -> f1 + f2;
		System.out.println(ob.applyAsDouble(1, 2));

	}

	private static void Question42() {
		System.out.println("Question42");
		BiFunction<Double, Double, String> fun = (f1, f2) -> f1.toString() + ":" + f2.toString();

		System.out.println(fun.apply(1.2, 1.3));

	}

	private static void Question43() {
		System.out.println("Question43");
		Function<String, Double> f = Double::parseDouble;
		System.out.println(f.andThen(s -> s * 2).apply("1"));

	}

	private static void Question44() {
		System.out.println("Question44");
		IntStream ins = IntStream.rangeClosed(1, 5);
		IntConsumer con = System.out::println;

		con.accept(ins.sum());

	}

	private static void Question45() {
		System.out.println("Question45");
		List<Integer> list = new ArrayList<>();
		list.add(21);
		list.add(13);
		list.add(30);
		list.add(11);
		list.removeIf(e -> e % 2 != 0);
		System.out.println(list);

	}

	private static void Question46() {
		System.out.println("Question46");
		IntStream ds = IntStream.of(1, 2, 2, 4);
		// Stream<String> ste = ds.boxed().map(Integer::toString);

	}

	private static void Question47() {
		System.out.println("Question47");
		Comparator<Integer> comp = Integer::compare;
		System.out.println(comp.compare(1, 2));

	}

	private static void Question48() {
		System.out.println("Question48");
		LocalDate ldt = LocalDate.of(2015, 3, 1);

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("d/MM/yyyy");

		System.out.println(ldt.format(dt));

	}

	private static void Question49() {
		System.out.println("Question49");
		Instant now = Instant.now();
		// ZonedDateTime zid = ZonedDateTime.of(now,
		// ZoneId.of("Canada/Atlantic"));
		ZonedDateTime zid = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Canada/Atlantic"));
		System.out.println(zid);
		System.out.println(zid.getHour());
	}

	private static void Question50() {
		System.out.println("Question50");

		LocalDate ldt = LocalDate.of(2012, 2, 29);
		ldt.plusYears(2);
		System.out.println(ldt);

		LocalDate udt = ldt.plusYears(2);
		System.out.println(udt);

	}

	public static void Question51() {
		System.out.println("Question51");

		LocalDate ldt = LocalDate.of(2012, 2, 29);
		System.out.println(ldt.getMonthValue() + " " + ldt.getDayOfWeek());
		System.out.println(ldt.getMonth() + " " + ldt.getEra());
	}

	private static void Question52() {
		System.out.println("Question52");
		Period p = Period.ofMonths(1);
		System.out.println("Period.ofMonths(1) :" + p);
		p = p.plusYears(2);
		System.out.println("Period.plusYears(2) : " + p);
		p = p.withYears(1);
		System.out.println("Period.withYears(1) : " + p);

	}

	private static void Question53() {
		// System.out.println("Question53");

	}

	private static void Question54() {
		System.out.println("Question54 - see EnUs.java");

	}

	private static void Question55() {
		System.out.println("Question55");

		String s = "123.4567";
		Number N;

		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		nf.setMaximumFractionDigits(2);

		try {
			N = nf.parse(s);
			System.out.println(N);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	private static void Question56() {
		System.out.println("Question56 - see Animal.java interface");

	}

	private static void Question57() {
		System.out.println("Question57");
		Move.main("pete");

	}

	private static void Question58() {
		System.out.println("Question58 ... A default method cannot override a method from java.lang.Object ");

	}

	private static void Question59() {
		System.out.println("Question59");
		I i = new I() {
		};
		i.print();
		I.method();

	}

	private static void Question60() {
		System.out.println("Question60");

		try (Resource r = new Resource()) {
			r.print();
		}

		System.out.println("0");

	}

}
