/**
 * 
 */
package lambda;

/**
 * @author stykky
 *
 */
interface Multiply {
	public Integer multiplyByFive( int n );
}

interface Sum {
	public Integer sumAddends( int n, int m );
}

public class MultipleParameterLambda {
	
	public Multiply multiplyFunction() {
		return (int n) -> { return n*5; };
	}
	
	public Sum sumFunction() {
		return (int n, int m) -> { return n+m; };
	}

}