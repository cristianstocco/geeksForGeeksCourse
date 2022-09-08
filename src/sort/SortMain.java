/**
 * 
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author stykky
 *
 */
public class SortMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public SortMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("SortMain execution...");
		
		executeBubbleSort();
		executeMergeSort();
		executeThief();
		executeSortIndexedItem();
		executePossibleTriangles();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeBubbleSort() {
		int[] array = {10, 4, 6, 2, 1, 9, 5, 8, 3, 7};
		
		Sort.bubbleSort( array );
		
		System.out.println(
				String.format("The array is sorted by bubbleSort: %s", Arrays.toString(array))
		);
	}
	
	private void executeMergeSort() {
		int[] array = {10, 4, 6, 2, 1, 9, 5, 8, 3, 7};
		
		Sort.mergeSort( array );
		
		System.out.println(
				String.format("The array is sorted by mergeSort: %s", Arrays.toString(array))
		);
	}
	
	private void executeThief() {
		List<Integer> list = new ArrayList<>();
		int k = 3;

		list.add( 3 );
		list.add( 7 );
		list.add( 2 );
		list.add( 5 );
		list.add( 12 );
		list.add( 30 );
		
		System.out.println(
				String.format("The array has thief with k %d with value %d", k, thiefValue(list, k))
		);
	}
	
	private Integer thiefValue( List<Integer> list, int k ) {
		int sum = 0;
        int limit = list.size() - k;
        
        Collections.sort(list);
        
        for( int i = list.size()-1; i >= 0 && i >= limit; i-- ) {
            sum += list.get(i);
        }
        
        return sum;
	}
	
	private void executeSortIndexedItem() {
		List<Integer> list = new ArrayList<>();

		list.add( 5 );
		list.add( 5 );
		list.add( 4 );
		list.add( 3 );
		list.add( 2 );
		list.add( 5 );
		
		List<IndexedItem> sortedList = sortIndexedItem(list);
		
		System.out.println(
				String.format("The array ordered by indexes %s", sortedList.toString())
		);
	}
	
	private ArrayList<IndexedItem> sortIndexedItem( List<Integer> arr ) {
		ArrayList<IndexedItem> list = new ArrayList<>();
	    
	    for( int i = 0; i < arr.size(); i++ ) {
	        list.add( new IndexedItem(arr.get(i), i) );
	    }
	    
	    Collections.sort(list, (i1, i2) -> {return i1.item - i2.item;});
	    
	    return list;
	}
	
	private void executePossibleTriangles() {
		int[] array = {6, 4, 9, 7, 8};
		
		int trianglesNo = findNumberOfTriangles( array );
		
		System.out.println(
				String.format("The array %s has number of triangles equals to %d", Arrays.toString(array), trianglesNo)
		);
	}
	
	private int findNumberOfTriangles( int array[] ) {
        int count=0;
        int one=0;
		
        Arrays.sort(array);
		
        for( int i = array.length-1; i >= 2; i-- ) {
            one = array[i];
            count += twoSum( 0, i-1, array, one );
        }
        
        return count;
    }
	
    private int twoSum( int left, int right, int array[], int sum ) {
        int count=0;
        
        while(left<right) {
	        if( array[left]+array[right] > sum ) {
	            count += right-left;
	            right--;
	        }
	        else {
	            left++;
	        }
        }
        
        return count;
    }

}
