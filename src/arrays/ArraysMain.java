/**
 * 
 */
package arrays;

import java.util.Arrays;

/**
 * @author stykky
 *
 */
public class ArraysMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public ArraysMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("ArraysMain execution...");
		
		executeIntSort();
		executeFill();
		executeBinarySearch();
		executeAreEqual();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeIntSort() {
		int[] array = {10, 4, 6, 2, 1, 9, 5, 8, 3, 7};
		
		Arrays.sort( array );
		
		System.out.println(
				String.format("The array sorted is: %s", Arrays.toString(array))
		);
	}
	
	private void executeFill() {
		int[] array = {10, 4, 6, 2, 1, 9, 5, 8, 3, 7};
		int filler = 0;
		
		Arrays.fill(array, filler);
		
		System.out.println(
				String.format("The array filled by %d is: %s", filler, Arrays.toString(array))
		);
	}
	
	private void executeBinarySearch() {
		int[] array = {10, 4, 6, 2, 1, 9, 5, 8, 3, 7};
		int toFind = 5;
		
		Arrays.sort(array);
		
		System.out.println(
				String.format("The array %s contains %d in position %d", Arrays.toString(array), toFind, Arrays.binarySearch(array, toFind))
		);
	}
	
	private void executeAreEqual() {
		int[] array1 = {5, 2, 7, 3};
		int[] array2 = {5, 2, 7, 3};
		int[] array3 = {2, 7, 3, 5};
		
		System.out.println(
				String.format("The array %s contains %s in position %b", Arrays.toString(array1), Arrays.toString(array2), areEquals(array1, array2))
		);
		System.out.println(
				String.format("The array %s contains %s in position %b", Arrays.toString(array1), Arrays.toString(array3), areEquals(array1, array3))
		);
	}
	
	private boolean areEquals( int[] array1, int[] array2 ) {
		return Arrays.equals(array1, array2);
	}

}
