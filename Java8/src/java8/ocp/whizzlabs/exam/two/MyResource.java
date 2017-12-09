package java8.ocp.whizzlabs.exam.two;

import java.io.IOException;

public class MyResource implements AutoCloseable {

	public MyResource() {
		// TODO Auto-generated constructor stub
	}

	public void open() {
		System.out.println("Resource Opened");
	}

	public void read() throws IOException {
		throw new IOException();
	}

	@Override
	public void close() {
		System.out.println("Resource Closed");
	}

}
