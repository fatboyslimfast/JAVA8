package java8.ocp.sg2.chapter2;

public class HayStorageSubClass extends HayStorage {

	/* If all of the constructors are declared
	private in the singleton class, then it is impossible to create a subclass with a valid
	constructor; therefore, the singleton class is effectively final.*/
	public HayStorageSubClass() {
		super();
	}

}
