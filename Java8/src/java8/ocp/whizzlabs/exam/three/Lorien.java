package java8.ocp.whizzlabs.exam.three;

public class Lorien implements Comparable<Lorien> {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Lorien(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Lorien lorien) {
		return this.getName().compareTo(lorien.getName());
	}

	@Override
	public String toString() {
		return name;
	}

}
