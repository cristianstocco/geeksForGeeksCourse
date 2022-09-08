/**
 * 
 */
package comparator;

import java.util.Arrays;

/**
 * @author stykky
 *
 */
public class ComparatorMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public ComparatorMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("ComparatorMain execution...");
		
		executeStringSort();
		executePointSort();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeStringSort() {
		String[] strings = {"Abc", "Xyz", "fghfg", "adas", "tuTY", "dsa"};
		
		Arrays.sort(strings, String::compareToIgnoreCase);
		
		System.out.println(
				String.format("Strings sorted by ignoring case %s", Arrays.toString(strings))
		);
	}
	
	private void executePointSort() {
		Point[] points = {new Point(3, 1), new Point(2, 8), new Point(2, 4), new Point(0, 2)};
		
		Arrays.sort(
				points,
				(p1, p2) -> { return new PointComparatorLambda().compareTo().compareTo(p1, p2); }
		);
		
		System.out.println(
				String.format("Points sorted %s", Arrays.toString(points))
		);
	}

}
