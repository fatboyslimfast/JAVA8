package study.helloworldapp;

/**
 * The HelloWorldApp class implements an application that
 * simply prints "Hello World!" to standard output.
 *
 * @author Pete
 *
 */
public class HelloWorldApp {

	public static void main(String... args) {
		System.out.println("Hello World!"); // Display the string.
		
		if (args != null) {
			System.out.println("args passed; "+args.length);
			for (String arg : args) {
				System.out.println("arg passed; "+arg);
			}
		} else {
			System.out.println("No args passed"); // Display the string.
		}
		
	}

}
