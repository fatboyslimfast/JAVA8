package java8.ocp.sg2.chapter2;

public class StaffRegister {
	private static final StaffRegister instance;

	// Instantiation using a static block
	static {
		instance = new StaffRegister();
		// Perform additional steps
	}

	private StaffRegister() {
	}

	public static StaffRegister getInstance() {
		return instance;
	}

	// Data access methods
}
