/**
 * 
 */
package java8.ocp.whizzlabs.exam.four;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java8.ocp.whizzlabs.exam.Data;
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
		List<Number> listNumbers = new ArrayList<>();

		List<? super Integer> numbers = process(listIntegers);

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

	private static void Question13() {
		System.out.println("Q13 ...");
		AtomicInteger counter = new AtomicInteger(0);
		List<String> sentence = Arrays.asList("he", "wants", "to", "see", "the", "sea");

		sentence.parallelStream().allMatch(s -> {
			counter.incrementAndGet();
			return s.contains("e");
		});

		System.out.println("Counter : " + counter);

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
		// System.out.println("QXX ...");

	}

	public static void Question21() throws Exception {

	}

	private static void Question22() {
		// System.out.println("QXX ...");

	}

	private static void Question23() {
		// System.out.println("QXX ...");

	}

	private static void Question24() {
		// System.out.println("QXX ...");

	}

	private static void Question25() {
		// System.out.println("QXX ...");

	}

	private static void Question26() {
		// System.out.println("QXX ...");

	}

	private static void Question27() {
		// System.out.println("QXX ...");

	}

	private static void Question28() {
		// System.out.println("QXX ...");

	}

	private static void Question29() {
		// System.out.println("QXX ...");

	}

	private static void Question30() {
		// System.out.println("QXX ...");

	}

	public static void Question31() throws Exception {

	}

	private static void Question32() {
		// System.out.println("QXX ...");

	}

	private static void Question33() {
		// System.out.println("QXX ...");

	}

	private static void Question34() {
		// System.out.println("QXX ...");

	}

	private static void Question35() {
		// System.out.println("QXX ...");

	}

	private static void Question36() {
		// System.out.println("QXX ...");

	}

	private static void Question37() {
		// System.out.println("QXX ...");

	}

	private static void Question38() {
		// System.out.println("QXX ...");

	}

	private static void Question39() {
		// System.out.println("QXX ...");

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
		// System.out.println("QXX ...");

	}

	private static void Question44() {
		// System.out.println("QXX ...");

	}

	private static void Question45() {
		// System.out.println("QXX ...");

	}

	private static void Question46() {
		// System.out.println("QXX ...");

	}

	private static void Question47() {
		// System.out.println("QXX ...");

	}

	private static void Question48() {
		// System.out.println("QXX ...");

	}

	private static void Question49() {
		// System.out.println("QXX ...");

	}

	private static void Question50() {
		// System.out.println("QXX ...");

	}

	public static void Question51() throws Exception {

	}

	private static void Question52() {
		// System.out.println("QXX ...");

	}

	private static void Question53() {
		// System.out.println("QXX ...");

	}

	private static void Question54() {
		// System.out.println("QXX ...");

	}

	private static void Question55() {
		// System.out.println("QXX ...");

	}

	private static void Question56() {
		// System.out.println("QXX ...");

	}

	private static void Question57() {
		// System.out.println("QXX ...");

	}

	private static void Question58() {
		// System.out.println("QXX ...");

	}

	private static void Question59() {
		// System.out.println("QXX ...");

	}

	private static void Question60() {
		// System.out.println("QXX ...");

	}

}
