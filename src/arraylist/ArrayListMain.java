/**
 * 
 */
package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author stykky
 *
 */
public class ArrayListMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public ArrayListMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("ArrayListMain execution...");
		
		executeFillArrayList();
		executeBasics();
		executeIterator();
		executeSmallerThan();
		executeMaxNeighbours();
		executeMinimumVerticalSum();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeFillArrayList() {
		//	fill List
		List<Integer> list = fillArrayList( new int[] {0, 1, 2, 3, 4} );
		
		//	print
		System.out.print( "Numbers are: " );
		list.stream().forEach(
				(n) -> { System.out.print( n + ", " ); }
		);
		
		//	print new line
		System.out.println();
	}
	
	private List<Integer> fillArrayList( int[] data ) {
		//	data
		List<Integer> list = new ArrayList<>();
		
		//	add i-th element
		for(int i = 0; i < data.length; i++) {
			list.add( data[i] );
		}
		
		return list;
	}
	
	private void executeBasics() {
		List<Integer> list = new ArrayList<>();
		
		//	add data
		list.add( 1 );
		list.add( 1 );
		list.add( 2 );
		list.add( 3 );
		list.add( 5 );
		list.add( 8 );
		
		//	remove data
		list.remove( 1 );
		list.remove( (Object) 5 );
		
		//	rearrange array
		list.sort( (n, m) -> { return m.compareTo(n); } );
		Collections.reverse( list );
		
		//	print
		System.out.print( "Numbers are: " );
		printArrayList( list.iterator() );
		
		//	print new line
		System.out.println();
	}
	
	private void executeIterator() {
		//	data
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 5, 8);
		
		//	print
		System.out.print( "Numbers are: " );
		printArrayList( list.iterator() );
		
		//	print new line
		System.out.println();
	}
	
	private void printArrayList( Iterator<?> it ) {
		//	print
		while( it.hasNext() ) {
			System.out.print( it.next()+", " );
		}
	}
	
	private void executeSmallerThan() {
		//	data
		int k = 783;
		List<Integer> list = List.of(39284, 34, 394, 9374, 594, 1028);
		
		//	filter
		List<Integer> filteredList = filterSmallerThan(list, k);
		
		//	print
		System.out.print( "Numbers are: " );
		printArrayList( filteredList.iterator() );
		
		//	print new line
		System.out.println();
	}
	
	private List<Integer> filterSmallerThan(List<Integer> list, int k) {
		//	filter
		return list.stream().filter( (n) -> { return n.compareTo(k) < 0; } ).toList();
	}
	
	private void executeMaxNeighbours() {
		//	data
		List<Integer> list = List.of(0, 1, 0, 1, 0);
		
		//	filter
		List<Integer> filteredList = filterMaxNeighbours( list );
		
		//	print
		System.out.print( "Numbers are: " );
		printArrayList( filteredList.iterator() );
		
		//	print new line
		System.out.println();
	}
	
	private List<Integer> filterMaxNeighbours( List<Integer> list ) {
		//	data
		List<Integer> filteredList = new ArrayList<>();
		Iterator<Integer> it = list.iterator();
		
		//	base-case
		if( !it.hasNext() )
			return new ArrayList<>();
		
		//	catch first value
		Integer i = it.next();
		
		//	filter data
		while( it.hasNext() ) {
			Integer j = it.next();
			
			filteredList.add( Math.max(i, j) );
			
			i = j;
		}
		
		return filteredList;
	}
	
	private void executeMinimumVerticalSum() {
		//	data
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add( List.of(1, 2, 3, 4) );
		matrix.add( List.of(5, 6) );
		matrix.add( List.of(7, 8, 9) );
		
		int n = getMinimumVerticalSum( matrix );
		System.out.println( 
				String.format("The min vertical sum of %s is: %d", matrix.toString(), n)
		);
	}
	
	private int getMinimumVerticalSum( List<List<Integer>> matrix ) {
		//	data
		Iterator<List<Integer>> columnIt = matrix.iterator();
		List<Integer> sums = new ArrayList<>();
		int rowIndex;
		
		//	cycle over columns
		while( columnIt.hasNext() ) {
			Iterator<Integer> rowIt = columnIt.next().iterator();
			
			rowIndex = 0;
			//	cycle over rows
			while( rowIt.hasNext() ) {
				Integer i = rowIt.next();
				
				//	add the sum
				if( sums.size() < rowIndex+1 )
					sums.add( i );
				
				//	modify the sum
				else
					sums.set(rowIndex, i+sums.get(rowIndex));
				
				rowIndex++;
			}
		}
		
		return Collections.min( sums );
	}

}
