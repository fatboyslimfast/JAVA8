package java8.ocp.sg2.chapter2.practice;

public enum Proposition {


	TRUE(-10) {@Override String getNickName(){ return "RIGHT";}},
	FALSE(-10) {public String getNickName(){ return "WRONG";}},
	UNKNOWN(-10) {@Override  String getNickName(){ return "LOST";}};
	
	private final int value;
	
	Proposition(int value) {
		this.value = value;
	}
	
	
	public int getValue() {
		return value;
	}
	
	public abstract String getNickName();
	
	
	
	
}
