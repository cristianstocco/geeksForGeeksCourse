/**
 * 
 */
package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author stykky
 *
 */
public class StackMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public StackMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("StackMain execution...");
		
		executeCopy();
		executeBasics();
		executeDeleteMid();
		executeCompactConsecutiveDuplicates();
		executeRemoveConsecutiveDuplicates();
		executeParenthesisChecker();
		executeGetMinAtPop();
		executeShopkeeperProfit();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeCopy() {
		//	data
		List<Integer> list = List.of(1, 1, 2, 3, 5, 8);
		
		//	copy
		Stack<Integer> stack = copy( list );
		
		//	print
		System.out.print("Numbers are: ");
		print( stack );
		System.out.println();
	}
	
	private Stack<Integer> copy( List<Integer> list ) {
		//	data
		Stack<Integer> stack = new Stack<>();
		
		//	copy
		list.stream().forEach(
				(n) -> { stack.add(n); }
		);
		
		return stack;
	}
	
	private void print( Stack<Integer> stack ) {
		Iterator<Integer> it = stack.iterator();
		
		//	print
		while( it.hasNext() ) {
			System.out.print( it.next()+", " );
		}
	}
	
	private void executeBasics() {
		Stack<Integer> stack = new Stack<>();
		
		//	basics
		stack.push( 2 );
		Integer i = stack.pop();
		stack.push( i );
		Integer j = stack.peek();
		boolean isPresent = stack.search( j ) != -1;
		
		//	print
		System.out.println(
				String.format("Element %d is present? %b", j, isPresent)
		);
	}
	
	private void executeDeleteMid() {
		//	data
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		stack.push(8);
		
		//	delete mid
		deleteMid( stack );
		
		//	print
		System.out.print("Numbers are: ");
		print( stack );
		System.out.println();
	}
	
	private void deleteMid( Stack<Integer> stack ) {
		if( !stack.isEmpty() )
			stack.remove( (stack.size()-1)/2 );
	}
	
	private void executeCompactConsecutiveDuplicates() {
		//	data
		String s = "aabbaaccaa";
		String parsedS = compactConsecutiveDuplicates(s);
		
		//	print
		System.out.println("Compacted consecutive duplicates v1: "+parsedS);
	}
	
	private String compactConsecutiveDuplicates( String s ) {
		//	base case
		if( s.isEmpty() )
			return "";
		
		//	data
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		//	stack & copy first char
		stack.push( s.charAt(0) );
		sb.append( s.charAt(0) );
		
		//	copy
		for( int i = 1; i < s.length(); i++ ) {
			if( stack.peek() != s.charAt(i) ) {
				stack.push( s.charAt(i) );
				sb.append( s.charAt(i) );
			}
		}
		
		return sb.toString();
	}
	
	private void executeRemoveConsecutiveDuplicates() {
		//	data
		String s = "aabbaaccaad";
		String parsedS = removeConsecutiveDuplicates(s);
		
		//	print
		System.out.println("Removed consecutive duplicates v1: "+parsedS);
	}
	
	private String removeConsecutiveDuplicates( String s ) {
		//	data
		Stack<Character> stack = new Stack<>();
        
		//	stack first char
        stack.push( s.charAt(0) );
        
        //	stack not consecutive duplicates
        for(int i = 1; i < s.length(); i++) {
        	if( !stack.isEmpty() ) {
	            Character c = stack.peek();
	            
	            if( c == s.charAt(i) ) {
	                stack.pop();
	            }
	            else {
	            	stack.push( s.charAt(i) );
	            }
        	}
            else {
            	stack.push( s.charAt(i) );
            }
        }
        
        //	data
        StringBuilder sb = new StringBuilder( stack.size() );
        sb.setLength( stack.size() );
        
        //	copy chars to string
        for(int i = stack.size()-1; i >= 0; i--) {
            sb.setCharAt(i, stack.pop());
        }
        
        return sb.toString();
	}
	
	private void executeParenthesisChecker() {
		//	data
		String parenthesis = "([{}])";
		boolean isParenthesisPair = isParenthesisPair(parenthesis);
		
		//	print
		System.out.println(
				String.format("Is parenthesis pair of %s: %b", parenthesis, isParenthesisPair)
		);
	}
	
	private boolean isParenthesisPair( String s ) {
		//	data
		Stack<Character> stack = new Stack<>();
        
		//	push first char
        stack.push(s.charAt(0));
        
        //	cycle over the string
        for(int i = 1; i < s.length(); i++) {
        	if( !stack.isEmpty() ) {
	            Character c = stack.peek();
	            
	            //	curved parenthesis
	            if( c == '(' && s.charAt(i) == ')' )
	                stack.pop();
	            
	            //	square brackets
	            else if( c == '[' && s.charAt(i) == ']' )
	                stack.pop();
	            
	            //	curly brackets
	            else if( c == '{' && s.charAt(i) == '}' )
	                stack.pop();
	            
	            //	push to stack
	            else
	            	stack.push( s.charAt(i) );
        	}
        	
        	//	push to stack
            else
            	stack.push( s.charAt(i) );
        }
        
        return stack.isEmpty();
	}
	
	private void executeGetMinAtPop() {
		//	data
		Stack<Integer> stack = new Stack<>();
		
		//	add data
		stack.add(10);
		stack.add(20);
		stack.add(5);
		stack.add(25);
		
		//	print
		System.out.print( "The min element popped is: " );
		cycleMinAtPop( stack );
		System.out.println();
	}
	
	private void cycleMinAtPop( Stack<Integer> stack ) {
		while( !stack.isEmpty() ) {
            System.out.print( getMinAtPop(stack)+" " );
            stack.pop();
        }
	}
	
	private int getMinAtPop(Stack<Integer> stack) {
        int min = Integer.MAX_VALUE;
        
        for( int i=stack.size()-1; i >= 0; i--) {
           min = Math.min( min, stack.elementAt(i) );
        }
        
        return min;
    }
	
	private void executeShopkeeperProfit() {
		//	data
		List<Integer> list = new ArrayList<>();
		
		//	add data
		list.add( 5 );
		list.add( 4 );
		list.add( 6 );
		list.add( 2 );
		list.add( 1 );
		
		//	find profit
		int profit = shopkeeperProfit( list );
		
		//	print
		System.out.println( "The profit is: "+profit );
	}
	
	private int shopkeeperProfit( List<Integer> list ) {
		//	data
		int profit = 0;
		
		//	cycle over list
        for(int i = 0 ; i < list.size(); i++) {
            int j = i+1;
            int iValue = list.get(i);
            
            //	cycle over list to find V_j
            while( j < list.size() && iValue > list.get(j) ) {
                j++;
            }
            
            //	add profit
            if(j == list.size()) {
                profit += iValue;
            } else {
                profit += list.get(j) - iValue;
            }
        }
        
        return profit;
	}

}

