package java8.ocp.sg2.chapter2.practice;

public class Turtle {

	public static void main(String[] seeweed) {
		int distance = 7;
		
		CanSwim seaTurtle = new CanSwim() {
				@Override
				public void swim() {
					System.out.print(distance);
				}
		};
		
		seaTurtle.swim();

	}

}
