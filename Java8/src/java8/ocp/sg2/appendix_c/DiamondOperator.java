package java8.ocp.sg2.appendix_c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pche0001
 *
 */
public class DiamondOperator {

	//Starting with Java 7, you can even omit that type
	//from the right side. The < and > are still required, though. This is called the diamond operator
	//because <> looks like a diamond.

	List<String> list1 = new ArrayList<String>();
	List<String> list2 = new ArrayList<>();


	// One of the most powerful features of the diamond operator <> is that it can be used for	embedded collection types.
	Map<Map<String,Integer>,List<Double>> map1	= new HashMap<Map<String,Integer>, List<Double>>();
	Map<Map<String,Integer>,List<Double>> map2 = new HashMap<>();

	// 	Nesting diamond	operators is not allowed.
	Map<Map<String,Integer>,List<Double>> map3	= new HashMap<<>,<>>(); // DOES NOT COMPILE

	// allowed only	on the right side of an assignment operation
	List<> list3 = new ArrayList<String>(); // DOES NOT COMPILE


}
