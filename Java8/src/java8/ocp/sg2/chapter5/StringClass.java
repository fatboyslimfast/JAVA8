/**
 *
 */
package java8.ocp.sg2.chapter5;

/**
 * @author pche0001
 *
 */
public class StringClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "bunny";
		String s2 = "bunny";
		String s3 = new String("bunny");
		System.out.println(s1 == s2); // true
		System.out.println(s1 == s3); // false
		System.out.println(s1.equals(s3)); // true

		String s4 = "1" + 2 + 3;
		String s5 = 1 + 2 + "3";
		System.out.println(s4); // 123
		System.out.println(s5); // 33

		String s = "abcde ";
		System.out.println(s.trim().length()); // 5
		System.out.println(s.charAt(4)); // e
		System.out.println(s.indexOf('e')); // 4
		System.out.println(s.indexOf("de")); // 3
		System.out.println(s.substring(2, 4).toUpperCase()); // CD
		System.out.println(s.replace('a', '1')); // 1bcde
		System.out.println(s.contains("DE")); // false
		System.out.println(s.startsWith("a")); // true

		// A StringBuilder is mutable, which means
		// that it can change value and increase in capacity.

		StringBuilder b = new StringBuilder();
		b.append(12345).append('-');
		System.out.println(b.length()); // 6
		System.out.println(b.indexOf("-")); // 5
		System.out.println(b.charAt(2)); // 3

		StringBuilder b2 = b.reverse();
		System.out.println(b.toString()); // -54321
		System.out.println(b == b2); // true

		StringBuilder sb = new StringBuilder("abcde");
		sb.insert(1, '-').delete(3, 4);
		System.out.println(sb); // a-bde
		System.out.println(sb.substring(2, 4)); // bd

	}

}
