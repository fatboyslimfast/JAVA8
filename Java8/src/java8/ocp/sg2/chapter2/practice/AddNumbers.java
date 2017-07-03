/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public interface AddNumbers {
	int add(int x, int y);
	static int subtract (int x, int y) {return x-y;};
	default int multiple (int x, int y) {return x*y;};
	
}
