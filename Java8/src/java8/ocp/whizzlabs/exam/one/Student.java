/**
 * 
 */
package java8.ocp.whizzlabs.exam.one;

/**
 * @author Pete
 *
 */
public class Student {

	private String name;
	private Department department;
	private Gender gender;
	private Faculty faculty;
	private double mark;

	Student(String name, Faculty faculty, double mark) {
		this.name = name;
		this.faculty = faculty;
		this.mark = mark;
	}

	Student(String name, Department department, Gender gender) {
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
	public String toString() {
		return this.name + " is a student member in department " + this.department;
	}

	enum Department {
		BUSINESS, TECHNICAL
	}

	enum Gender {
		MALE, FEMALE
	}

	enum Faculty {
		ENGINEERING, MEDICINE
	}

}
