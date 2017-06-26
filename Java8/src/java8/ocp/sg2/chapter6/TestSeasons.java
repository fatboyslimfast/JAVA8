package java8.ocp.sg2.chapter6;

import java8.ocp.sg2.chapter6.Assertions.Seasons;

public final class TestSeasons {
	public static void test(Seasons s) {
		switch (s) {
		case SPRING:
		case FALL:
			System.out.println("Shorter hours");
			break;
		case SUMMER:
			System.out.println("Longer hours");
			break;
		case WINTER:
			System.out.println("Shortest hours");
			break;			
		default:
			assert false : "Invalid season";
		}
	}
}
