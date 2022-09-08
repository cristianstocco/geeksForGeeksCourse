/**
 * 
 */
package main;

import arraylist.ArrayListMain;
import arrays.ArraysMain;
import collections.CollectionsMain;
import comparator.ComparatorMain;
import lambda.LambdaMain;
import linkedlist.LinkedListMain;
import map.MapMain;
import queue.QueueMain;
import set.SetMain;
import sort.SortMain;
import stack.StackMain;
import stream.StreamMain;
import string.StringMain;

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
		new StackMain().execute();
		new QueueMain().execute();
		new SetMain().execute();
		new MapMain().execute();
		new StringMain().execute();
		new ComparatorMain().execute();
		new ArraysMain().execute();
		new CollectionsMain().execute();
		new SortMain().execute();
	}

}
