/**
 *
 */
package java8.ocp.sg2.chapter3.practice;

/**
 * @author pche0001
 *
 */
public class Q15 {

	interface Comic<C>{
		void draw(C c);
	}


	class ComicClass<C> implements Comic<C> {
		@Override
		public void draw(C c) {
			System.out.println("draw ComicClass");
			System.out.println(c);
		}
	}


	class SnoopyClass implements Comic<Snoopy> {
		@Override
		public void draw(Snoopy c) {
			System.out.println("draw SnoopyClass");
			System.out.println(c);
		}

	}


	class SnoopyComic implements Comic<Snoopy> {
		@Override
		public void draw(Snoopy c) {
			System.out.println("draw SnoopyComic");
			System.out.println(c);
		}

	}


}
