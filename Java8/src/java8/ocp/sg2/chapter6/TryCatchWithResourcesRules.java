package java8.ocp.sg2.chapter6;

import java.io.IOException;
import java.util.Scanner;

public class TryCatchWithResourcesRules {

	public static void main(String...  args){

		try (Scanner s = new Scanner(System.in)) {
			// do 0 catch 0 finally legal << MAIN DIFFERENCE
		} 

		try (Scanner s = new Scanner(System.in)) {
			// do stuff
		} finally {
			//  legal
		}

		try (Scanner s = new Scanner(System.in)) {
			// do stuff
		} finally {
			//  legal
		} finally {
			//  illegal // DOES NOT COMPILE
		}


		try (Scanner s = new Scanner(System.in)) {
			// do stuff .. multi catch legal
		} catch (IOException e) {

		} catch (Exception ex) {

		}


		try (Scanner s = new Scanner(System.in)) {
			// do stuff .. multi catch & 1 finally legal
		} catch (IOException ex1) {

		} catch (Exception ex2) {

		} finally {
			// do final stuff
		}


		try (Scanner s = new Scanner(System.in)) {
			// do stuff .. multi catch > 1 finally illegal
		} catch (IOException ex3) {

		} catch (Exception ex4) {

		} finally {
			// do final stuff
		} finally {
			// do final stuff // DOES NOT COMPILE
		}


/*The resources created in the try clause are only in scope within the try block. This is
another way to remember that the implicit finally runs before any catch/finally blocks
that you code yourself. The implicit close has run already, and the resource is no longer
available.
*/
		try (Scanner s = new Scanner(System.in)) {
			s.nextLine();
		} catch(Exception e) {
			s.nextInt(); // DOES NOT COMPILE
		} finally{
			s.nextInt(); // DOES NOT COMPILE
		}










	}

}
