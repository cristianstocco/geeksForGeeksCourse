/**
 * 
 */
package linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author stykky
 *
 */
public class LinkedListMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public LinkedListMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("LinkedListMain execution...");
		
		executeCopy();
		executePrint();
		executeJosephusCircle();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	
	private void executeCopy() {
		//	data
		List<Integer> list = List.of(1, 1, 2, 3, 5, 8);
		
		//	copy to LinkedList
		LinkedList<Integer> linkedList = copy( list );
		
		//	print
		System.out.print( "Numbers are: " );
		print( linkedList );
		System.out.println();
	}
	
	private LinkedList<Integer> copy( List<Integer> list ) {
		//	data
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		//	copy
		list.stream().forEach(
				(n) -> { linkedList.add(n); }
		);
		
		return linkedList;
	}
	
	private void executePrint() {
		//	data
		List<Integer> list = List.of(10, 10, 20, 30, 50, 80);
		
		//	copy
		LinkedList<Integer> linkedList = copy( list );
		
		//	print
		System.out.print("Numbers are: ");
		print( linkedList );
		System.out.println();
	}
	
	private void print( LinkedList<Integer> linkedList ) {
		linkedList.stream().forEach(
				(n) -> { System.out.print(n + ", "); }
		);
	}
	
	private void executeJosephusCircle() {
		int peopleNo = 7;
		int ratio = 3;
		
		int manStanding = killJosephusCircle( peopleNo, ratio );
		
		System.out.println(
				String.format("The last person from JosephusCircle with people %d and ratio %d is: %d", peopleNo, ratio, manStanding)
		);
	}
	
	private int killJosephusCircle( int peopleNo, int ratio ) {
		List<Integer> linkedList = new LinkedList<>();
		
		//	add people
		for( int i = 0; i < peopleNo; i++ ) {
			linkedList.add(i);
		}

		ListIterator<Integer> it = linkedList.listIterator();
		//	kill people
		while( linkedList.size() > 1 ) {
			for( int i = 0; i < ratio; i++ ) {
				if( !it.hasNext() )
					it = linkedList.listIterator();
				
				it.next();
			}
			
			it.remove();
		}

		return linkedList.get( 0 );
	}

}