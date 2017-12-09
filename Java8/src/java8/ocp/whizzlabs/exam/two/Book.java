/**
 * 
 */
package java8.ocp.whizzlabs.exam.two;

/**
 * @author Pete
 *
 */
public class Book {

	private String title;
	private double price;
	private String author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param title
	 * @param price
	 * @param author
	 */
	public Book(String title, double price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}

}
