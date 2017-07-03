package java8.ocp.sg2.chapter2.practice;

public class ApplePicking {

	interface Edible {
		void eat(); //public
	}

	public static void main(String[] args) {
		Edible apple = new Edible() {
			@Override
			public void eat() {
				System.out.println("Yummy");
			}
		};
		
		//apple.eat();

	}

}
