package java8.ocp.whizzlabs.exam.five;

public interface MyCloseable<T> extends AutoCloseable {

	@Override
	default void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
