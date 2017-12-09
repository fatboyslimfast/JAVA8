/**
 * 
 */
package java8.ocp.whizzlabs.exam;

/**
 * @author Pete
 *
 */
public class Movie {

	private String title;
	private double ticketPrice;
	private String label;

	/**
	 * 
	 */
	public Movie(String title, double price) {
		this.title = title;
		this.ticketPrice = price;
	}

	public Movie(String title, String label) {
		this.title = title;
		this.label = label;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String toString(String timing) {
		return title + " " + label + "(" + timing + ")";
	}

}
