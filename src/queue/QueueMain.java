/**
 * 
 */
package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * @author stykky
 *
 */
public class QueueMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public QueueMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("LambdaMain execution...");
		
		executeBasics();
		executePrint();
		executeReverse();
		executeReverseFirstK();
		executeQueueWithStack();
		executeGenerateBinaryNumbers();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeBasics() {
		Queue<Integer> queue = new ArrayDeque<>();
		int queueValue = 325;
		
		queue.offer( queueValue );
		queue.offer( queueValue );
		queue.offer( 3925 );
		
		int queueFrequency = getFrequency( queue, queueValue );
		System.out.println(
				String.format("The number %d has frequency: %d", queueValue, queueFrequency)
		);
	}
	
	private int getFrequency( Queue<Integer> queue, int queueValue ) {
		Iterator<Integer> it = queue.iterator();
		int n = 0;
		
		while( it.hasNext() ) {
			if( it.next() == queueValue )
				n++;
		}
		
		return n;
	}
	
	private void executePrint() {
		//	data
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer( 1 );
		queue.offer( 1 );
		queue.offer( 2 );
		queue.offer( 3 );
		queue.offer( 5 );
		queue.offer( 8 );
		
		System.out.print( "The queue has values: " );
		print( queue );
		System.out.println();
	}
	
	private void print( Queue<Integer> queue ) {
		queue.stream().forEach(
				(n) -> { System.out.print( n+", " ); }
		);
	}
	
	private void executeReverse() {
		//	data
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer( 1 );
		queue.offer( 1 );
		queue.offer( 2 );
		queue.offer( 3 );
		queue.offer( 5 );
		queue.offer( 8 );
		
		queue = reverse( queue );
		System.out.print( "The queue has values: " );
		print( queue );
		System.out.println();
	}
	
	private Queue<Integer> reverse( Queue<Integer> queue ) {
		Queue<Integer> reversedQ = new ArrayDeque<>();
        
        Object[] queueArray = queue.toArray();
        
        for( int i = queueArray.length-1; i >= 0; i-- ) {
            reversedQ.offer( (Integer) queueArray[i] );
        }
        
        return reversedQ;
	}
	
	private void executeReverseFirstK() {
		//	data
		Queue<Integer> queue = new ArrayDeque<>();
		int reversingK = 4;
		
		queue.offer( 1 );
		queue.offer( 1 );
		queue.offer( 2 );
		queue.offer( 3 );
		queue.offer( 5 );
		queue.offer( 8 );
		
		queue = reverseFirstK( queue, reversingK );
		System.out.print( "The queue has values: " );
		print( queue );
		System.out.println();
	}
	
	private Queue<Integer> reverseFirstK( Queue<Integer> queue, int k ) {
		Queue<Integer> reversedQ = new ArrayDeque<>();
        
        Object[] queueArray = queue.toArray();
        
        for( int i = k-1; i >= 0; i-- ) {
            reversedQ.offer( (Integer) queueArray[i] );
        }
        
        for( int i = 0; i < k; i++ ) {
            queue.poll();
        }
        
        Iterator<Integer> it = queue.iterator();
        while( it.hasNext() ) {
            reversedQ.offer( it.next() );
        }
        
        return reversedQ;
	}
	
	private void executeQueueWithStack() {
		//	data
		QueueWithStack queueWithStack = new QueueWithStack();

		queueWithStack.push( 2 );
		queueWithStack.push( 4 );
		queueWithStack.push( 6 );
		queueWithStack.push( 8 );

		//	print
		System.out.println("QueueWithStack 1st element: "+queueWithStack.pop());
		System.out.println("QueueWithStack 2nd element: "+queueWithStack.pop());
		System.out.println("QueueWithStack 3rd element: "+queueWithStack.pop());
		System.out.println("QueueWithStack 4th element: "+queueWithStack.pop());
	}
	
	private void executeGenerateBinaryNumbers() {
		//	data
		int limit = 8;
		
		//	generate
		List<String> binaryNumbers = generateBinaryNumbers( limit );
		
		//	print
		System.out.println( "Numbers till " + limit + " are: " );
		binaryNumbers.stream().forEach(
				(s) -> { System.out.print( s+", " ); }
		);
		System.out.println();
	}
	
	private List<String> generateBinaryNumbers( int limit ) {
		List<String> binaries = new ArrayList<>();
        
        for( int i = 1; i <= limit; i++ )
            binaries.add(Integer.toBinaryString(i));
            
        return binaries;
	}

}
