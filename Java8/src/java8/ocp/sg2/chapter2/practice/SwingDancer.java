package java8.ocp.sg2.chapter2.practice;

public abstract class SwingDancer extends Dancer {

	public Follower getPartner() {
		return new Follower();
	}

}
