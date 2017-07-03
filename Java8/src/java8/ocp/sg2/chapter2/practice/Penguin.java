/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public class Penguin { 
	
	private int volume = 1;
	
	private class Chick {
		private int chickvolume = 3;
		void chick(){
			System.out.println("Honk("+Penguin.this.volume+")!");
			System.out.println("Honk("+Chick.this.chickvolume+")!");
			System.out.println("Honk("+this.chickvolume+")!");
			System.out.println("Honk("+chickvolume+")!");
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Penguin pen = new Penguin();
		final Penguin.Chick littleOne = pen.new Chick();
		
		littleOne.chick();

	}

}
