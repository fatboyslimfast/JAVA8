package java8.ocp.sg2.chapter6;

import java.io.IOException;

public class TryCatchRules {
	
	
	public static void main(String...  args){
		try{
			// do 0 catch 0 finally illegal // DOES NOT COMPILE
		} 

		try{
			// do stuff
		} finally {
			//  legal
		}
		
		try{
			// do stuff
		} finally {
			//  legal
		} finally {
			//  illegal // DOES NOT COMPILE
		}
		
		
		try{
			// do stuff .. multi catch legal
		} catch (IOException e) {
			
		} catch (Exception ex) {
			
		}
		
		
		try{
			// do stuff .. multi catch & 1 finally legal
		} catch (IOException ex1) {
			
		} catch (Exception ex2) {
			
		} finally {
			// do final stuff
		}
		
		
		try{
			// do stuff .. multi catch > 1 finally illegal
		} catch (IOException ex3) {
			
		} catch (Exception ex4) {
			
		} finally {
			// do final stuff
		} finally {
			// do final stuff // DOES NOT COMPILE
		}
	}
	
	
}
