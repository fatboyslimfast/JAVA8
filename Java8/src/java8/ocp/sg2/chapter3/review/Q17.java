package java8.ocp.sg2.chapter3.review;

public class Q17 {

	public class Generic<T> { // <> and <?> not valid


		Generic<String> g = new Generic<?>(); // <> valid  <T> invalid <?> invalid

		Generic<Object> g2 = new Generic(); // warning but valid

		Generic<Object> g3 = new Generic<Object>(); // valid
	}





}
