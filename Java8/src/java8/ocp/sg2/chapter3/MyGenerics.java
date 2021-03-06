package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.List;

class A {
}

class B extends A {
}

class C extends B {
}

public class MyGenerics {

	public static void main(String[] stuff) {

		List<? super Object> list0 = new ArrayList<Object>();
		list0.add(new A());
		list0.add(new B());
		list0.add(new C());

		List<?> list1 = new ArrayList<A>(); // can hold instances of A?
		list1.add(new A());
		list1.add(new B());
		list1.add(new C());

		List<? extends A> list2 = new ArrayList<A>(); // can have A, B , C
		list2.add(new A());
		list2.add(new B());
		list2.add(new C());

		List<? super A> list3 = new ArrayList<A>(); // lowest type you can
													// reference is A
		list3.add(new A());
		list3.add(new B());
		list3.add(new C());

		List<? extends B> list4 = new ArrayList<A>(); // can only reference B
														// and C

		List<? super B> list5 = new ArrayList<A>(); // upper bounded so allows
													// A, B & Object to be
													// referenced
		list5.add(new A());
		list5.add(new B());
		list5.add(new C());

		List<?> list6 = new ArrayList<? extends A>(); // need to know the exact
														// type when
														// instantiating array
														// list

	}

	public <T> T method1(List<? extends T> list) { // takes a parameter of
													// list<T> or subclass of T
		return list.get(0); // returns a single object of that T type
	}

	public <T> <? extends T> method2(List<? extends T> list) { // DOES NOT COMPILE because the return type isn’t actually a type. You don’t get to specify this as a wildcard
		return list.get(0);
	}

	public <B extends A> B method3(List<B> list) { // Within the scope of the
													// method, B parameter can
													// represent classes A, B,
													// or C, because all extend
													// the A class
		return new B(); // DOES NOT COMPILE, Since B no longer refers to the B
						// class in the method, you can’t instantiate it.
	}

	void method4(List<? super B> list) {
	}


	<X> void method5(List<X super B> list) { // DOES NOT COMPILE because it tries to mix a method-specific type parameter	with a wildcard. A wildcard must have a ? in it.
	}


	public void test() {

		List<String> list1 = new ArrayList<>();
		list1.add("Pete");
		list1.add("Matt");
		list1.add("Amar");


		// you could call it with a List<String> parameter and have it return a
		// String.
		String pete = method1(list1);

		// Or you could call it with a List<Number> parameter and have it return
		// a Number

		List<A> listA = new ArrayList<A>();
		listA.add(new A());
		listA.add(new B());
		listA.add(new C());

		List<B> listB = new ArrayList<B>();
		listB.add(new B());
		listB.add(new C());

		List<C> listC = new ArrayList<C>();
		listC.add(new C());


		List<Object> listObject = new ArrayList<>();
		listObject.add(new A());
		listObject.add(new B());
		listObject.add(new C());
		listObject.add("Object");


		method4(listA);
		method4(listB);
		method4(listObject);
		method4(listC);




	}

}
