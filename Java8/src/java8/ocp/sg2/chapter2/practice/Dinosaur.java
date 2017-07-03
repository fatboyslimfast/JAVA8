/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public class Dinosaur {
	
	
	Dinosaur() {
		System.out.println("GRRR");
	}
	
	
	public class Pterodactyl //extends Dinosaur 
	{
		
		Pterodactyl() {
//			super();
			System.out.println("SKREECH");
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dinosaur d= new Dinosaur();

		Pterodactyl p = d.new Pterodactyl();
		
		//d.noStaticMethod();
		
	}
	
	
	public void noStaticMethod() {
		System.out.println("SKREECHY");
		Pterodactyl p = new Pterodactyl();
		
	}

}
