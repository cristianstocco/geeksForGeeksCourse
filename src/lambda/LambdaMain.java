/**
 * 
 */
package lambda;

import java.util.List;

/**
 * @author stykky
 *
 */
public class LambdaMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public LambdaMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		executeLambdaHelloWorld();
		executeLambdaMapper();
		executeLambdaSum();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeLambdaHelloWorld() {
		new NoParameterLambda().helperFunction().sayHelloWorld();
	}
	
	private void executeLambdaMapper() {
		//	data
		List<Integer> fibonacci = List.of(1, 1, 2, 3, 5, 8);
		
		//	sum
		//	map (pipeline): changes values with a lambda expression
		//	reduce (terminal): makes the sum value
		int fibonacciSum = fibonacci.stream()
				.map(
						(n) -> { return new MultipleParameterLambda().multiplyFunction().multiplyByFive(n); }
				).reduce(
						(sum, n) -> { return sum + n; }
				).get().intValue();
		
		//	print sum
		System.out.println("The fibonacci sum (1..8) * 5 = " + fibonacciSum);
	}
	
	private void executeLambdaSum() {
		//	data
		int n = 8;
		int m = 13;
		
		//	print sum
		System.out.println(
				String.format("The sum of %d and %d is %d", n, m, new MultipleParameterLambda().sumFunction().sumAddends(n, m))
		);
	}

}
