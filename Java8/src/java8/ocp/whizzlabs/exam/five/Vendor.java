package java8.ocp.whizzlabs.exam.five;

public class Vendor {
	private int rating;
	private String name;

	/**
	 * @param rating
	 * @param name
	 */
	public Vendor(int rating, String name) {
		this.rating = rating;
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
