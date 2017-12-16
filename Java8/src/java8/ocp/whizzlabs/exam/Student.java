/**
 * 
 */
package java8.ocp.whizzlabs.exam;

/**
 * @author Pete
 *
 */
public class Student {

	private int id;
	private String name;
	private Department department;
	private Gender gender;
	private Faculty faculty;
	private double mark;

	public Student() {
		this(0, "noname");
	}

	public Student(String name) {
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(String name, Faculty faculty) {
		this.name = name;
		this.faculty = faculty;
	}

	public Student(String name, Faculty faculty, double mark) {
		this.name = name;
		this.faculty = faculty;
		this.mark = mark;
	}

	public Student(String name, Department department, Gender gender) {
		this.name = name;
		this.department = department;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public double getMark() {
		return mark;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	// public String toString() {
	// return this.name + " is a student member in department " +
	// this.department;
	// }

	public String toString() {
		return name;
	}

	public enum Department {
		BUSINESS, TECHNICAL
	}

	public enum Gender {
		MALE, FEMALE
	}

	public enum Faculty {
		ENGINEERING, MEDICINE, BUSINESS
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
