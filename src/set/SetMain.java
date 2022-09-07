/**
 * 
 */
package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author stykky
 *
 */
public class SetMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public SetMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("SetMain execution...");
		
		executeCountOnce();
		executeSumExists();
		executeIntersection();
		executeUnion();
		executeUniqueSubstring();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeCountOnce() {
		List<Integer> list = new ArrayList<>();
		
		list.add( 8 );
		list.add( 8 );
		list.add( 6 );
		list.add( 5 );
		list.add( 9 );
		list.add( 9 );
		list.add( 2 );
		
		System.out.println(
				String.format("The elements counted once are number: %d", countOnce(list))
		);
	}
	
	private int countOnce(List<Integer> list) {
		Set<Integer> set = new HashSet<>();
		
		for( Integer i : list ) {
			set.add( i );
		}
		
		return set.size();
	}
	
	private void executeSumExists() {
		int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 16;
		
		System.out.println(
				String.format("Sum exists of %s are: %s", Arrays.toString(elements), Arrays.toString(sumExists(elements, sum)))
		);
	}
	
	private int[] sumExists( int[] elements, int sum ) {
		int[] toReturn = new int[2];
		
		for( int i = 0; i < elements.length; i++ ) {
			for( int j = i+1; j < elements.length; j++ ) {
				if( elements[i] + elements[j] == sum ) {
					toReturn[ 0 ] = elements[ i ];
					toReturn[ 1 ] = elements[ j ];
					return toReturn;
				}
			}
		}
		
		return new int[2];
	}
	
	private void executeIntersection() {
		int[] elements1 = {89, 24, 75, 11, 23};
		int[] elements2 = {89, 2, 24};
		
		System.out.println(
				String.format("The number of intersection %s and %s is: %d",
						Arrays.toString(elements1),
						Arrays.toString(elements2),
						countIntersection(elements1, elements2)
				)
		);
	}
	
	private int countIntersection(int[] elements1, int[] elements2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		for( int i : elements1 ) {
			set1.add( i );
		}
		for( int i : elements2 ) {
			set2.add( i );
		}
		
		set1.retainAll( set2 );
		
		return set1.size();
	}
	
	private void executeUnion() {
		int[] elements1 = {1, 2, 3};
		int[] elements2 = {2, 3, 4, 5};
		
		System.out.println(
				String.format("The number of union %s and %s is: %d",
						Arrays.toString(elements1),
						Arrays.toString(elements2),
						countUnion(elements1, elements2)
				)
		);
	}
	
	private int countUnion(int[] elements1, int[] elements2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		for( int i : elements1 ) {
			set1.add( i );
		}
		for( int i : elements2 ) {
			set2.add( i );
		}
		
		set1.addAll( set2 );
		
		return set1.size();
	}
	
	private void executeUniqueSubstring() {
		String src = "abcd";
		
		System.out.println(
				String.format("The number of unique substrings of %s is: %d", src, countUniqueSubstring(src))
		);
	}
	
	private int countUniqueSubstring( String src ) {
		Set<String> set = new HashSet<String>();
		
		for( int i = 1; i <= src.length(); i++ ) {
			for( int j = 0; i+j <= src.length(); j++) {
				set.add( src.substring(j,i+j) );
			}
		}
		
		return set.size();
	}

}
