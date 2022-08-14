/**
 * 
 */
package queue;

import java.util.Stack;

/**
 * @author stykky
 *
 */
public class QueueWithStack {

	private Stack<Integer> s1;
    private Stack<Integer> s2;

	/*
	 * CONSTRUCTOR
	 */
    public QueueWithStack() {
    	s1 = new Stack<>();
    	s2 = new Stack<>();
    }

	/*
	 * PUBLIC METHODS
	 */
    public void push( int x ) {
    	s1.push( x );
    }
    
    public int pop() {
    	if( s2.isEmpty() ) {
            if(s1.isEmpty()) {
                return -1;
            }
            
            //	copy data
            while( !s1.isEmpty() ) {
                s2.push(s1.pop());
            }
           
            return s2.pop();
        }
       
        else
        	return s2.pop();
    }
	
}
