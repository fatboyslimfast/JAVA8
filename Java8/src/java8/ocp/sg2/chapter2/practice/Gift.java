package java8.ocp.sg2.chapter2.practice;

public class Gift {

	public static void main(String[] matrix) {
		abstract class Robot{}
		
		class Transformer extends Robot implements Toy {
			public String name = "GiantRobot";
			public String play() { return "DinosaurRobot";}
			
		}
		
		Transformer prime = new Transformer() {
			public String play() { return name;}
		};
		
		System.out.println(prime.play()+" " );

	}

}
