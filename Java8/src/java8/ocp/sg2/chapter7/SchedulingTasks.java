package java8.ocp.sg2.chapter7;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		Runnable task1 = () -> System.out.println("Hello Zoo");
		Runnable task3 = () -> System.out.println("Number of Available Processors " + Runtime.getRuntime().availableProcessors());
		Callable<String> task2 = () -> {
			return "Monkey";
		};
		Future<?> result1 = service.scheduleAtFixedRate(task1, 5L, 5L, TimeUnit.SECONDS); // useful
																							// for
																							// tasks
																							// that
																							// need
																							// to
																							// be
																							// run
																							// at
																							// specific
																							// intervals,
		Future<?> result3 = service.scheduleWithFixedDelay(task3, 2L, 1L, TimeUnit.SECONDS); // is
																								// useful
																								// for
																								// processes
																								// that
																								// you
																								// want
																								// to
																								// happen
																								// repeatedly
																								// but
																								// whose
																								// specific
																								// time
																								// is
																								// unimportant.
		Future<?> result2 = service.schedule(task2, 3, TimeUnit.SECONDS);




	}

}
