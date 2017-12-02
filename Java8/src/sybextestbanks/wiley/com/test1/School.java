package sybextestbanks.wiley.com.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class School {

	private List<Object> exceptions;
	private List<?> names = new ArrayList<Object>();

	public School() {
		exceptions = new LinkedList<>();
		names.add("Pete");
		exceptions.add("Objection");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
