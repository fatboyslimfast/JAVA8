package java8.ocp.sg2.chapter2.practice;

public abstract class Dancer {
	public Leader getPartner() {
		return new Leader();
	}

	abstract public Leader getPartner(int count);
}
