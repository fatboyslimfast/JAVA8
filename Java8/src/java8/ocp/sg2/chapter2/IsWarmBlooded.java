package java8.ocp.sg2.chapter2;

public interface IsWarmBlooded {
	boolean hasScales();

	public default double getTemperature() {
		return 10.0;
	}

	default double getX() {
		return 10.0;
	}

	static int getHeight() {
		return 8;
	}
}
