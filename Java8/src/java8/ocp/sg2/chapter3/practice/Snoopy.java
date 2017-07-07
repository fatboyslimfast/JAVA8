package java8.ocp.sg2.chapter3.practice;

import java8.ocp.sg2.chapter3.practice.Q15.Comic;

public class Snoopy {

	Snoopy(){}


// Q15
	public static void main(String[] args) {
		//Comic<Snoopy> c1 = c -> System.out.println(c);
		Snoopy snoopy = new Snoopy();
		Comic<Snoopy> c2 = new Q15().new ComicClass<>();
		c2.draw(snoopy);

		Comic<Snoopy> c3 = new Q15().new SnoopyClass();
		c3.draw(snoopy);

		Comic<Snoopy> c4 = new Q15().new SnoopyComic();
		c4.draw(snoopy);


	}

}
