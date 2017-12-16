/**
 * 
 */
package java8.ocp.whizzlabs.exam;

import java.util.function.Predicate;

/**
 * @author Pete
 *
 */
public class Movie {

	private String title;
	private double ticketPrice;
	private String label;
	private double rating;

	public Movie(double rating, String title) {
		this.title = title;
		this.rating = rating;
	}

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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String toString(String timing) {
		return title + " " + label + "(" + timing + ")";
	}

	public static class Filter implements Predicate<Movie> {

		@Override
		public boolean test(Movie t) {
			return t.getRating() > 9.0;
		}

	}

	public static class Filter2 {
		boolean isGood(Movie movie) {
			return movie.getRating() > 9.0;

		}
	}

}
