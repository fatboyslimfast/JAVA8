package java8.ocp.whizzlabs.exam.four;

public interface Child extends Parent {

	@Override
	default double method2() {
		return 0.0;
	}

}
