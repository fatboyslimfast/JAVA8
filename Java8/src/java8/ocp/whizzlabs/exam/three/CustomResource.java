package java8.ocp.whizzlabs.exam.three;

import java.io.IOException;

public class CustomResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new IOException("IO Exceprion");

	}

}
