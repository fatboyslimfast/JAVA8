package java8.ocp.sg2.chapter3.practice;

public class Q22 {
	
	class Wash<T> {
		T item;
		public void clean(T item) {
			System.out.println("Clean " + item);
		}
	}

	
	public static void main(String...strings) {
		Wash<String> wash = new Q22().new Wash<>();
		wash.clean("socks");
		
		Wash wash1 = new Q22().new Wash<>();
		wash1.clean("pants");
		
		Wash wash2 = new Q22().new Wash<String>();
		wash2.clean("undies");
		
		
	}
	
}
