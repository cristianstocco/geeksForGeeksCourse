/**
 * 
 */
package main;

import arraylist.ArrayListMain;
import lambda.LambdaMain;
import linkedlist.LinkedListMain;
import stream.StreamMain;

/**
 * @author stykky
 *
 */
public class Main {

	/**
	 * MAIN
	 */
	public static void main(String[] args) {
		new Main().execute();
	}
	
	private void execute() {
		System.out.println("Welcome to solutions & applications for JavaBackEndCourse");
		System.out.println("made by: cristianstocco");
		System.out.println("provided by: geeks for geeks");
		new LambdaMain().execute();
		new StreamMain().execute();
		new ArrayListMain().execute();
		new LinkedListMain().execute();
	}

}
