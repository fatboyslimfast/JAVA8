/**
 * 
 */
package java8.ocp.whizzlabs.exam.one;

/**
 * @author Pete
 *
 */
public class Movie {

	private String title;
	private double ticketPrice;

	/**
	 * 
	 */
	public Movie(String title, double price) {
		this.title = title;
		this.ticketPrice = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
