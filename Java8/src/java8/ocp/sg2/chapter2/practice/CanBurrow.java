package java8.ocp.sg2.chapter2.practice;

interface CanBurrow {

	public abstract void canBurrow(); //

	@FunctionalInterface
	interface HasHardShell extends CanBurrow {
	}

	abstract class Tortoise implements HasHardShell {
		public abstract int toughness();
	}

	public class DesertTortoise extends Tortoise {


		@Override
		public int toughness() {
			return 11;
		}
	}
}
