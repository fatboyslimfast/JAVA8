/**
 *
 */
package java8.ocp.sg2.chapter3.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pche0001
 *
 */
public class Q9 {

    private static Map<String, Double> map = new HashMap<>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        map.add("pi", 3.14159);
        map.add("e", 2L);
        map.add("log(1)", new Double(0.0));
        map.add('x', new Double(123.4));

        map.put("pi", 3.14159); //  3.14159D would be valid
        map.put("e", 2L); // Long not valid value
        map.put("log(1)", new Double(0.0));
        map.put('x', new Double(123.4)); // char not valid key




    }

}
