package java8.ocp.sg2.chapter3.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Q5 {

	public static void main(String[] args) {
		HashSet<Number> hs = new HashSet<Integer>(); // replace <Number> .. with <? extends Number> .. any type that extends NUmber would be OK
		HashSet<? super ClassCastException> set = new HashSet<Exception>();
		List<String> list = new Vector<String>();
		List<Object> values = new HashSet<Object>(); // List and Set extend Collection ... new ArrayList<Object>() would be OK
		List<Object> objects = new ArrayList<? extends Object>(); // you need to know what type when instantiating an ARRAY
		Map<String, ? extends Number> hm = new HashMap<String, Integer>();

	}

}
