/**
 * 
 */
package java8.upgrade.lambda;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Pete
 *
 */
public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	/**
	 * @param name
	 * @param birthday
	 * @param gender
	 * @param emailAddress
	 */
	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public int getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public void printPerson() {
		System.out.println(name + " " + gender + " " + emailAddress + " " + getAge());
	}

	@Override
	public String toString() {
		return name + " " + gender + " " + emailAddress + " " + getAge();
	}

}
