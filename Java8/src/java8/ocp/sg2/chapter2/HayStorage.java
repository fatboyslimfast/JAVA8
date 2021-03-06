/**
 *
 */
package java8.ocp.sg2.chapter2;

/**
 * @author pche0001
 *
 */
public class HayStorage {
	private int quantity = 0;

	//all constructors in a singleton class are marked private
	//we have implicitly marked the class final
	private HayStorage() {
	}

	// singletons in Java are created as private static
	// variables within the class, often with the name instance.

	private static final HayStorage instance = new HayStorage();

	/**
	 * @return returns the reference to the
	/* singleton object
	 */
	public static HayStorage getInstance() {
		return instance;
	}

	public synchronized void addHay(int amount) {
		quantity += amount;
	}

	public synchronized boolean removeHay(int amount) {
		if (quantity < amount)
			return false;
		quantity -= amount;
		return true;
	}

	public synchronized int getHayQuantity() {
		return quantity;
	}
}
