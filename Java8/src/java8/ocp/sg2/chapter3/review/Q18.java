package java8.ocp.sg2.chapter3.review;

public class Q18 {

	class A {
	}

	class B extends A {
	}

	class C extends B {
	}

	class D<T> { // C now refers to parameter not Class above, any lines with
					// 'C' do not compile ... change C to T

		A a1 = new A();
		A a2 = new B();
		A a3 = new C();

		B b1 = (B) new A();
		B b2 = new B();
		B b3 = new C();

		C c1 = (C) new A();
		C c2 = (C) new B();
		C c3 = new C();

	}
}
