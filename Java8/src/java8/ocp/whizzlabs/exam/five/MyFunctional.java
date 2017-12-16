package java8.ocp.whizzlabs.exam.five;

import java.util.function.ObjDoubleConsumer;

public interface MyFunctional<T> extends ObjDoubleConsumer {

	@Override
	default void accept(Object t, double value) {
		// TODO Auto-generated method stub

	}

}
