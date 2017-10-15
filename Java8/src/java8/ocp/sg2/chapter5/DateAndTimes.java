/**
 *
 */
package java8.ocp.sg2.chapter5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author pche0001
 *
 */
public class DateAndTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());

		LocalDate date2 = LocalDate.of(2015, 1, 20);

		Month month = Month.JANUARY;
		// boolean b1 = month == 1; // DOES NOT COMPILE Incompatible operand
		// types Month and int
		boolean b2 = month == Month.APRIL; // false

		zoneIds();

		// LocalDate d = new LocalDate(); // DOES NOT COMPILE

		// LocalDate x = LocalDate.of(2015, Month.JANUARY, 32);
		// //java.time.DateTimeException: Invalid value for DayOfMonth (valid
		// values 1 - 28/31): 32

		localDate();

		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(5, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println(dateTime); // 2020–01–20T05:15
		dateTime = dateTime.minusDays(1);
		System.out.println(dateTime); // 2020–01–19T05:15
		dateTime = dateTime.minusHours(10);
		System.out.println(dateTime); // 2020–01–18T19:15
		dateTime = dateTime.minusSeconds(30);
		System.out.println(dateTime); // 2020–01–18T19:14:30

		LocalDateTime sameDateTime = LocalDateTime.of(date, time).minusDays(1).minusHours(10).minusSeconds(30);
		System.out.println(sameDateTime); // 2020–01–18T19:14:30

		// date = date.plusMinutes(1); // DOES NOT COMPILE ... he method
		// plusMinutes(int) is undefined for the type LocalDate

		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
		Period period = Period.ofMonths(1); // create a period
		performAnimalEnrichment(start, end);
		performAnimalEnrichment(start, end, period);

		Period annually = Period.ofYears(1); // every 1 year
		Period quarterly = Period.ofMonths(3); // every 3 months
		Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
		Period everyOtherDay = Period.ofDays(2); // every 2 days
		Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

		Period wrong = Period.ofYears(1).ofWeeks(1); // every week

		System.out.println(Period.ofMonths(3));

		System.out.println(Period.of(0, 20, 47));

		System.out.println(Period.ofWeeks(3));

		LocalDate date4 = LocalDate.of(2015, 1, 20);
		LocalTime time4 = LocalTime.of(6, 15);
		LocalDateTime dateTime4 = LocalDateTime.of(date, time);
		period = Period.ofMonths(1);
		System.out.println(date4.plus(period)); // 2015–02–20
		System.out.println(dateTime4.plus(period)); // 2015–02–20T06:15
		// System.out.println(time4.plus(period)); //
		// java.time.temporal.UnsupportedTemporalTypeException:
		// Unsupported unit: Months

		Duration daily = Duration.ofDays(1); // PT24H
		Duration hourly = Duration.ofHours(1); // PT1H
		Duration everyMinute = Duration.ofMinutes(1); // PT1M
		Duration everyTenSeconds = Duration.ofSeconds(10); // PT10S
		Duration everyMilli = Duration.ofMillis(1); // PT0.001S
		Duration everyNano = Duration.ofNanos(1); // PT0.000000001S

		Duration sameDaily = Duration.of(1, ChronoUnit.DAYS);
		Duration sameHourly = Duration.of(1, ChronoUnit.HOURS);
		Duration sameEveryMinute = Duration.of(1, ChronoUnit.MINUTES);
		Duration sameEveryTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
		Duration sameEveryMilli = Duration.of(1, ChronoUnit.MILLIS);
		Duration sameEveryNano = Duration.of(1, ChronoUnit.NANOS);

		Duration halfDaily = Duration.of(1, ChronoUnit.HALF_DAYS);

		// Duration weekly = Duration.of(1, ChronoUnit.WEEKS); // anything
		// greater
		// than DAYS
		// java.time.temporal.UnsupportedTemporalTypeException:
		// Unit must not
		// have an estimated
		// duration

		LocalTime one = LocalTime.of(5, 15);
		LocalTime two = LocalTime.of(6, 30);
		LocalDate aDate = LocalDate.of(2016, 1, 20);
		System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
		System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
		// System.out.println(ChronoUnit.MINUTES.between(one, aDate)); //
		// DateTimeException
		// Unable to
		// obtain
		// LocalTime
		// from
		// TemporalAccessor:
		// 2016-01-20
		// of type
		// java.time.LocalDate

		Duration duration = Duration.ofHours(6);
		System.out.println(dateTime.plus(duration)); // 2019-02-27T01:14:30
		System.out.println(time.plus(duration)); // 11:15
		// System.out.println(date.plus(duration)); //
		// UnsupportedTemporalException
		// Unsupported unit: Seconds

		durationPlus();

		durationAndPeriod();

		System.out.println("\t\t" + "|Can Use with Period?" + "\t" + "|Can Use with Duration?");
		System.out.println("LocalDate" + "\t" + "|Yes" + "\t\t\t" + "|No");
		System.out.println("LocalDateTime" + "\t" + "|Yes" + "\t\t\t" + "|Yes");
		System.out.println("LocalTime" + "\t" + "|No" + "\t\t\t" + "|Yes");
		System.out.println("ZonedDateTime" + "\t" + "|Yes" + "\t\t\t" + "|Yes");

		instant();

	}

	private static void instant() {
		LocalDate date = LocalDate.of(2015, 5, 25);
		LocalTime time = LocalTime.of(11, 55, 00);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
		Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
		System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
		System.out.println(instant); // 2015–05–25T15:55:00Z //Instant of time
										// in GMT.

		Instant instant2 = Instant.ofEpochSecond(zonedDateTime.toEpochSecond());
		System.out.println(instant2); // 2015–05–25T15:55:00Z

		Instant nextDay = instant2.plus(1, ChronoUnit.DAYS);
		System.out.println(nextDay); // 2015–05–26T15:55:00Z
		Instant nextHour = instant2.plus(1, ChronoUnit.HOURS);
		System.out.println(nextHour); // 2015–05–25T16:55:00Z
		// Instant nextWeek = instant2.plus(1, ChronoUnit.WEEKS); //
		// java.time.temporal.UnsupportedTemporalTypeException: Unsupported
		// unit: Weeks

	}

	private static void durationAndPeriod() {
		LocalDate date = LocalDate.of(2015, 5, 25);
		Period period = Period.ofDays(1);
		Duration days = Duration.ofDays(1);
		System.out.println(date.plus(period)); // 2015–05–26
		try {
			System.out.println(date.plus(days)); // Unsupported unit: Seconds
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static void durationPlus() {
		LocalDate date = LocalDate.of(2015, 1, 20);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Duration duration = Duration.ofHours(23);
		System.out.println(dateTime.plus(duration)); // 2015–01–21T05:15
		System.out.println(time.plus(duration)); // 05:15
		// System.out.println(date.plus(duration)); //
		// UnsupportedTemporalException
	}

	private static void localDate() {
		LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
		System.out.println(date); // 2014–01–20
		date = date.plusDays(2);
		System.out.println(date); // 2014–01–22
		date = date.plusWeeks(1);
		System.out.println(date); // 2014–01–29
		date = date.plusMonths(1);
		System.out.println(date); // 2014–02–28
		date = date.plusYears(5);
		System.out.println(date); // 2019–02–28
	}

	private static void zoneIds() {
		LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
		LocalTime time1 = LocalTime.of(6, 15); // hour and minute
		LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
		LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

		LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
		LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20, 6, 15, 30, 200, zone);
		ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
		ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);

		ZoneId.getAvailableZoneIds().stream().filter(z -> z.contains("US") || z.contains("America")).sorted()
				.forEach(System.out::println);
	}

	private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) { // check if still before end
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plusMonths(1); // add a month
		}
	}

	private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) { // uses
																									// the
																									// generic
																									// period
		LocalDate upTo = start;
		while (upTo.isBefore(end)) {
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plus(period); // adds the period
		}
	}

}
