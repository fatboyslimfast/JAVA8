package java8.ocp.sg2.chapter3.review;

import java.util.HashMap;
import java.util.Map;

public class Q20 {

	public static void main(String...strings ){

		Map m = new HashMap();
		m.put(123, "456");
		m.put("abc", "def");

		System.out.println(m.containsKey("123")); // false
		System.out.println(m.containsKey(123)); // true
		System.out.println(m.containsValue("123")); // false
		System.out.println(m.containsValue("def")); // true

		System.out.println(m.contains("123")); //containsKey .. containsValue .. contains 

	}

}
