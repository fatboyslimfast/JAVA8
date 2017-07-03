/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public class Bottle {

	public class Inner {
		
	}
	public static class Ship {
		private enum Sail {
			TALL {
				protected int getHeight() {
					return 100;
				}
			},
			SHORT {
				protected int getHeight() {
					return 2;
				}
			};
			protected abstract int getHeight();
		}

		public Sail getSail() {
			return Sail.TALL;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bottle bottle = new Bottle();
		
		Inner in = bottle.new Inner();
		
		Ship q = bottle.new Ship();
		//	Bottle.Ship q = new Bottle.Ship();
		
		System.out.print(q.getSail());

	}

}
