/**
 * 
 */
package java8.ocp.whizzlabs.exam.five;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.OptionalInt;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Pete
 *
 */
public class ExamFive {

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
		System.out.println("Q1");

		// ConcurrentHashMap<Integer, String> cmap = new
		// ConcurrentHashMap<Integer, String>();
		// HashMap<Integer, String> cmap = new HashMap<Integer, String>();
		// Map<Integer, String> cmap = new ConcurrentHashMap<Integer, String>();
		ConcurrentMap<Integer, String> cmap = new ConcurrentHashMap<Integer, String>();
		cmap.put(1, "livera");
		cmap.replace(1, "livera", "pete");

		cmap.remove(1, "pete");

		System.out.println(cmap);

	}

	private static void Question2() {
		System.out.println("Q12");

		ConcurrentHashMap pcmap = new ConcurrentHashMap(15, 100);

	}

	private static void Question3() {
		System.out.println("Q3");

		ForkJoinPool fPool = new ForkJoinPool();

		Remender rem = new Remender(10, 3);

		// int i = fPool.invoke(rem);
		int i = rem.compute();

		System.out.println(i);

	}

	private static void Question4() {
		// System.out.println("QXX");

	}

	private static void Question5() {
		// System.out.println("QXX");

	}

	private static void Question6() {
		// System.out.println("QXX");

	}

	private static void Question7() {
		System.out.println("Q7");

		Stream<Integer> stream = Stream.of(2, 0, 4, 1);

		// System.out.println(stream.peek(x -> x++).sum());

	}

	private static void Question8() {
		System.out.println("Q8");

		Stream<Integer> stream = Stream.of(2, 0, 4, 1);
		// System.out.println(stream.skip(2).limit(1).toArray()[0]);

	}

	private static void Question9() {
		System.out.println("Q9");

		IntStream ints = IntStream.of(2, 4, 6);

		System.out.println(ints.filter(x -> x < 0).findFirst());

	}

	private static void Question10() {
		System.out.println("Q10");
		List<String> strings = Arrays.asList("Oracle", "Java", "1ZO-808", "Test");
		Map<Boolean, List<String>> map = strings.stream().collect(Collectors.partitioningBy(s -> s.length() > 4));

		System.out.println(map);

	}

	public static void Question11() throws Exception {
		System.out.println("Q11");
		List<String> ints = Arrays.asList("x", "y", "z");
		System.out.println(ints.stream().collect(Collectors.joining()));
	}

	private static void Question12() {
		System.out.println("Q12");
		Stream<String> stream = Stream.of("Cat", "Dog", "Rat");
		Stream<Integer> list = stream.flatMap(s -> Stream.of(s.length()));
		System.out.println(list.collect(Collectors.toSet()));

	}

	private static void Question13() {
		System.out.println("Q13");

		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		map.put("A", 1);
		map.put("B", 2);

		map2.put("B", 2);
		map2.put("C", 3);

		map.forEach((key, value) -> map2.merge(key, value, (i, j) -> j));

		map.keySet().forEach(System.out::print);

		map2.values().forEach(System.out::print);

	}

	private static void Question14() {
		System.out.println("Q14");
		Stream<String> stream = Stream.of("1.0", "1.2", "1.6", "1.4", "1.3");
		DoubleStream ds = stream.mapToDouble(s -> Double.valueOf(s)).filter(d -> d > 1.3);
		System.out.println(ds.sum());
	}

	private static void Question15() {
		System.out.println("Q15");
		List<String> list = Arrays.asList("A", "a", "Ba");

		list.forEach(s -> System.out.print(s));

	}

	private static void Question16() {
		System.out.println("Q16");
		List<String> list = Arrays.asList("1", "2", "3", "4");
		System.out.println(list.set(3, "3"));

	}

	private static void Question17() {
		System.out.println("Q17");
		List<Integer> list = Arrays.asList(1, 2, 3);
		list.replaceAll(i -> i / 2);
		list.forEach(s -> System.out.println(s));
	}

	private static void Question18() {
		System.out.println("Q18");

	}

	private static void Question19() throws IOException {
		System.out.println("Q19");

		Path path = Paths.get("C:\\Users\\Pete\\exam");

		FileVisitor<Path> searcher = new Search();

		Files.walkFileTree(path, searcher);

	}

	private static void Question20() {
		// System.out.println("QXX");

	}

	public static void Question21() throws Exception {
		System.out.println("Q21");

		Path path = Paths.get("C:\\Users\\Pete\\exam");

		// Stream<String> out = Files.list(path);
		Stream<Path> out = Files.list(path);
		out.forEach(s -> System.out.print(s.getFileName() + " | "));

	}

	private static void Question22() {
		System.out.println("Q22");

	}

	private static void Question23() throws IOException, InterruptedException {
		System.out.println("Q23");
		Path path = Paths.get("C:\\Users\\Pete\\exam");
		Path path2 = Paths.get("C:\\Users\\Pete\\exam\\exam_subdir");
		WatchService ws = FileSystems.getDefault().newWatchService();

		/*
		 * path.register(ws, StandardWatchEventKinds.ENTRY_CREATE);
		 * path2.register(ws, StandardWatchEventKinds.ENTRY_MODIFY);
		 * 
		 * WatchKey wk = ws.take(); wk.reset();
		 */

	}

	private static void Question24() throws IOException {
		System.out.println("Q24");
		Path path = Paths.get("C:\\Users\\Pete\\exam\\fileNew.txt");

		File myFile = new File(path.toString());

		System.out.println("File: " + myFile.createNewFile());

	}

	private static void Question25() {
		System.out.println("Q25");

		Stream<Vendor> vendors = Stream.of(new Vendor(7, "Dell"), new Vendor(9, "HP"), new Vendor(6, "Cisco"));

		ToIntFunction<Vendor> toInt = p -> p.getRating();

		IntStream out = vendors.mapToInt(toInt);

		System.out.println(out.skip(1).sum());

	}

	private static void Question26() {
		System.out.println("Q26");

		IntStream ints = IntStream.of(11, 2, 7, 32, 4, 8, 21, 9);

		// int out = ints.filter(in -> in % 2 == 0).reduce(Integer::sum);

		OptionalInt out = ints.filter(in -> in % 2 == 0).reduce(Integer::sum);

		System.out.println(out.orElse(0));

	}

	private static void Question27() {
		System.out.println("Q27");
		Stream<String> ins = Stream.of("1", "2", "3", "2", "1").distinct();
		String result = ins.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

		System.out.println(result);

	}

	private static void Question28() {
		System.out.println("Q28");
		IntStream.Builder b = IntStream.builder();

		b.add(0);
		b.accept(1);
		b.add(2);

		IntStream ins = b.build();

		// b.accept(3);

		ins.forEach(System.out::println);

	}

	private static void Question29() {
		System.out.println("Q29");

	}

	private static void Question30() {

		System.out.println("Q30");

		IntStream ins = IntStream.iterate(10, n -> n * 2).limit(3);

		// ins.forEach(s -> System.out.println(s));

		System.out.println(ins.sum());

	}

	public static void Question31() throws Exception {
		System.out.println("Q30");

		IntStream ins = IntStream.of(4, 2, 3);

		IntSummaryStatistics stat = ins.summaryStatistics();
		stat.accept(7);

		System.out.println(stat.getAverage());
		stat.accept(9);
		System.out.println(stat.getAverage());

	}

	private static void Question32() {
		System.out.println("Q32");

		System.out.println("Q16");
		List<String> list = Arrays.asList("1", "2", "3", "4", "5");

		Stream<Integer> ins = list.stream().map(s -> {
			System.out.print(s);
			return Integer.parseInt(s);
		});

		System.out.println("Count: ");
		System.out.println(ins.count());

	}

	private static void Question33() {
		System.out.println("Q33");

		Function<Double, Integer> mul = d -> d.intValue();
		Function<Integer, String> f = in -> in.toString();
		Function<Double, String> func = f.compose(mul);

		System.out.println(func.apply(12.6).length());

	}

	private static void Question34() {
		System.out.println("Q34");

		List<Integer> ints = Arrays.asList(10, 20, 30, 40);

		Consumer<Integer> cons = System.out::print;
		Consumer<Integer> con = e -> System.out.print(" " + e * 2 + " ");

		cons.andThen(con);

		ints.forEach(cons);
		System.out.println();

	}

	private static void Question35() {
		System.out.println("Q35");
		UnaryOperator<String> s = UnaryOperator.identity();
		System.out.println(s.apply("2"));

	}

	private static void Question36() {
		System.out.println("Q36");
		IntBinaryOperator ibo = Integer::compare;

		int x = ibo.applyAsInt(12, 11);

		System.out.println(x);

	}

	private static void Question37() {
		System.out.println("Q37");

		LongStream is = LongStream.of(1, 2, 3, 4);
		LongFunction lnf = l -> l;
		Stream<Integer> ins = is.mapToObj(lnf);
		// ins.forEach(s -> System.out.print(s));
	}

	private static void Question38() {
		System.out.println("Q38");
		Function<Object, Object> f = Function.identity();
		System.out.println(f.apply(10.0));

	}

	private static void Question39() {
		System.out.println("Q39");

		Changer<String> changer = String::toLowerCase;

	}

	private static void Question40() {
		// System.out.println("QXX");

	}

	public static void Question41() throws Exception {

	}

	private static void Question42() {
		System.out.println("Q42");
		IntStream ins = IntStream.of(5, 10, 15);

		// Stream<String> stngs = ins.boxed().map(Integer::toString);

	}

	private static void Question43() {
		// System.out.println("QXX");

	}

	private static void Question44() {
		// System.out.println("QXX");

	}

	private static void Question45() {
		// System.out.println("QXX");

	}

	private static void Question46() {
		// System.out.println("QXX");

	}

	private static void Question47() {
		System.out.println("Q47");

		int x = 10, y = 0;

		try {

			int c = x / y;

		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println("Multi");
		} catch (Exception e) {
			System.out.println("Exec");
		}
	}

	private static void Question48() {
		System.out.println("Q48");
		l2.print();
		l1.print();

	}

	private static void Question49() {
		// System.out.println("QXX");

	}

	private static void Question50() {
		System.out.println("Q50");

		Locale loc = new Locale.Builder().setLanguage("zh").build();

		System.out.println("loc: " + loc.getLanguage() + " " + loc.getCountry());

		Locale loc2 = new Locale.Builder().setLanguage("zh").setRegion("CN").build();

		System.out.println("loc2: " + loc2.getLanguage() + " " + loc2.getCountry());

		// Locale(String language, String country)
		Locale loc3 = new Locale("CN", "zh");
		System.out.println("loc3: " + loc3.getLanguage() + " " + loc3.getCountry());

		Locale loc4 = Locale.CHINA;
		System.out.println("loc4: " + loc4.getLanguage() + " " + loc4.getCountry());

		Locale loc5 = Locale.CHINESE;
		System.out.println("loc5: " + loc5.getLanguage() + " " + loc5.getCountry());

	}

	public static void Question51() throws Exception {

		System.out.println("Q51");
		ResourceBundle.Control rbc = ResourceBundle.Control.getControl(Control.FORMAT_DEFAULT);

		Locale locale = new Locale("de");

		// ResourceBundle rb = ResourceBundle.getBundle("SRBundle", locale,
		// rbc);

		// System.out.println(rb.getString("Table"));
	}

	private static void Question52() {
		// System.out.println("QXX");

	}

	private static void Question53() {
		System.out.println("Q53");
		LocalDate id1 = LocalDate.of(2015, 11, 28);
		LocalDate id2 = LocalDate.of(2015, 11, 29);

		long l = id1.until(id2, ChronoUnit.DAYS);
		System.out.println(l);

	}

	private static void Question54() {
		System.out.println("Q54");
		System.out.println(Period.ZERO.getUnits());

	}

	private static void Question55() {
		System.out.println("Q55");
		LocalDate ld = LocalDate.of(2015, 2, 27).plusDays(3);
		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getMonth());
		System.out.println(ld.getYear());

	}

	private static void Question56() {
		System.out.println("Q56");
		Period p = Period.ofMonths(13);
		System.out.println(p.normalized());

	}

	private static void Question57() {
		System.out.println("Q57");
		Year y = Year.of(2015);
		LocalDate ym = y.atMonthDay(MonthDay.of(4, 10));
		System.out.println(ym);

	}

	private static void Question58() {
		System.out.println("Q58");
		LocalDate ldt = LocalDate.of(2000, 3, 1);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/M/yyyy");
		System.out.println(ldt.format(format));

	}

	private static void Question59() {
		System.out.println("Q59");
		LocalDate ldt = LocalDate.of(2015, 12, 25);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMM uuuu");
		System.out.println(ldt.format(format));

	}

	private static void Question60() {
		System.out.println("Q60");

		Locale CAN = new Locale.Builder().setLanguage("en").setRegion("CA").build();
		Locale CAN2 = Locale.CANADA;
		System.out.println(CAN.getDisplayCountry());
		System.out.println(CAN2.getDisplayCountry());

	}

}
