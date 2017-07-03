/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
interface Alex {
	default void write() {}
	static void publish() {}
	void think();
}
