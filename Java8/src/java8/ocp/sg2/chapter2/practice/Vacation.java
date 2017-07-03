package java8.ocp.sg2.chapter2.practice;

enum DaysOff {ThanksGiving, PresindetsDay, ValentinesDay,
}


public class Vacation {

	public static void main (String[] args){
		final DaysOff input = DaysOff.ThanksGiving;
		switch(input) {
			default:
			case DaysOff.ValentinesDay: System.out.print("1");
			case DaysOff.PresindetsDay: System.out.print("2");
		}
	}
	
}
