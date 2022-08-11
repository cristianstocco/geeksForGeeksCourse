/**
 * 
 */
package stream;

import java.util.Arrays;

/**
 * @author stykky
 *
 */
public class StreamMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public StreamMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("StreamMain execution...");
		
		executeSum();
		executeMax();
		executeAverage();
		executeMaxOfOdd();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeSum() {
		//	data
		int[] addends = {1, 2, 3, 4, 5};
		
		//	sum
		int sum = Arrays.stream(addends).sum();
		
		//	print
		System.out.println(
				String.format("The sum of %d elements is %d", addends.length, sum)
		);
	}
	
	private void executeMax() {
		//	data
		int[] numbers = {30, 10, 40, 50, 20};
		
		//	sum
		int max = Arrays.stream(numbers).max().getAsInt();
		
		//	print
		System.out.println(
				String.format("The max of %d elements is %d", numbers.length, max)
		);
	}
	
	private void executeAverage() {
		//	data
		int[] numbers = {20, 50, 30, 10, 40};
		
		//	average
		double average = Arrays.stream(numbers).average().getAsDouble();
		
		//	print
		System.out.println(
				String.format("The average of %d elements is %.2f", numbers.length, average)
		);
	}
	
	private void executeMaxOfOdd() {
		//	data
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//	max of filtered data
		int max = Arrays.stream(numbers)
				.filter(
						(n) -> { return n%2 == 1; }
				).max().getAsInt();
		
		//	print
		System.out.println(
				String.format("The max of odd numbers of %d elements is %d", numbers.length, max)
		);
	}

}
