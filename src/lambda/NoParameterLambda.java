/**
 * 
 */
package lambda;

/**
 * @author stykky
 *
 */
interface Hello {
	public void sayHelloWorld();
}

public class NoParameterLambda {
	
	public Hello helperFunction() {
		return () -> { System.out.println("Hello World!"); };
	}

}
