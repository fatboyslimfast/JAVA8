package java8.upgrade.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PrintPersons {

	private static List<Person> roster = new ArrayList<Person>();

	public static void main(String... args) {

		roster.add(new Person("Pete", LocalDate.of(1970, 9, 24), Person.Sex.MALE, "p_cheung_uk@hotmail.com"));
		roster.add(new Person("Carrie", LocalDate.of(1977, 2, 21), Person.Sex.FEMALE, "carrie.plummer@hotmail.co.uk"));
		roster.add(new Person("Holly", LocalDate.of(1999, 12, 14), Person.Sex.FEMALE, "hplummer@hotmail.com"));
		roster.add(new Person("Olivia", LocalDate.of(2000, 4, 5), Person.Sex.FEMALE, "oliviacheung12k@gmail.com"));
		System.out.println("printPersonsWithPredicate" + System.lineSeparator());
		printPersonsWithPredicate(roster,
				p -> p.getGender() == Person.Sex.FEMALE && p.getAge() >= 12 && p.getAge() <= 65);
		System.out.println("processPersons" + System.lineSeparator());
		processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 65,
				p -> p.printPerson());

		System.out.println("processPersonsWithFunction" + System.lineSeparator());
		processPersonsWithFunction(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 65, p -> p.getEmailAddress(),
				email -> System.out.println(email));

		System.out.println("processElements" + System.lineSeparator());

		processElements(roster, p -> p.getGender() == Person.Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 65,
				p -> p.getEmailAddress(), email -> System.out.println(email));

		System.out
				.println("Aggregate Operations That Accept Lambda Expressions as Parameters" + System.lineSeparator());

		roster.stream().filter(p -> p.getGender() == Person.Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 65)
				.map(p -> p.getName()).forEach(name -> System.out.println(name));

		System.out.println("Pipeline" + System.lineSeparator());

		List<String> females = roster.stream().filter(e -> e.getGender() == Person.Sex.FEMALE).map(e -> e.getName())
				.collect(Collectors.toList());

		females.removeIf(s -> s.startsWith("H"));

		System.out.println(females);

	}

	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
			Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

}
