/**
 *
 */
package java8.ocp.sg2.chapter2;

/**
 * @author pche0001
 *
 */
public class Dolphin implements LivesInOcean {

	/*
	 * (non-Javadoc)
	 *
	 * @see java8.ocp.sg2.chapter2.LivesInOcean#makeSound()
	 */
	@Override
	public void makeSound() {
		System.out.println("whistle");
	}

}
