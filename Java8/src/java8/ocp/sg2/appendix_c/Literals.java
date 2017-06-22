package java8.ocp.sg2.appendix_c;

/**
 * @author pche0001
 *
 */
public class Literals {
	/*When a number is present in the code, it is a type of literal. By default, Java assumes that
	you are defining an int value with a literal. In this example, the number listed is bigger
	than what fits in an int. Remember that you aren’t expected to memorize the maximum
	value for an int. The exam will include it in the question if it comes up. */

	long max = 3123456789; // DOES NOT COMPILE

	long max2 = 3123456789L; // now Java knows it is a long

	//You can have underscores in numbers to make them easier to read:
	int million1 = 1000000;
	int million2 = 1_000_000;

	/*You
	can add underscores anywhere except at the beginning of a literal, the end of a literal, right
	before a decimal point, or right after a decimal point. Let’s look at a few examples: */

	double notAtStart = _1000.00; // DOES NOT COMPILE
	double notAtEnd = 1000.00_; // DOES NOT COMPILE
	double notByDecimal = 1000_.00; // DOES NOT COMPILE
	double annoyingButLegal = 1_00_0.0_0; // this one compiles


}
