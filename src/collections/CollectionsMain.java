/**
 * 
 */
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author stykky
 *
 */
public class CollectionsMain {

	/*
	 * CONSTRUCTOR
	 */
	public CollectionsMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("CollectionsMain execution...");
		
		executeMinMaxBinarySearch();
		executeFill();
		executeAreEquals();
		executeRotate();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeMinMaxBinarySearch() {
		List<Integer> list = new ArrayList<>();
		Integer toFind = 39;
		
		list.add(293);
		list.add(20);
		list.add(934);
		list.add(39);
		
		System.out.println(
				String.format("The max is: %d", Collections.max(list))
		);
		System.out.println(
				String.format("The min is: %d", Collections.min(list))
		);
		Collections.sort(list);
		System.out.println(
				String.format("The value %d is in %d position", toFind, Collections.binarySearch(list, toFind))
		);
	}
	
	private void executeFill() {
		List<Integer> list = new ArrayList<>();
		Integer toFill = 290;
		
		list.add(823);
		list.add(29);
		list.add(630);
		list.add(12);

		Collections.fill( list, toFill );
		System.out.println(
				String.format("The array with filled %d is %s", toFill, list.toString())
		);
	}
	
	private void executeAreEquals() {
		List<Integer> list1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		
		list1.add(394);
		list1.add(39);
		list2.add(394);
		list2.add(39);
		
		System.out.println(
				String.format("The lists are equal %b", areEquals(list1, list2))
		);
	}
	
	private boolean areEquals( List<Integer> list1, List<Integer> list2 ) {
		if( list1.size() != list2.size() )
			return false;
		
		for( int i = 0; i < list1.size(); i++ ) {
			if( list1.get(i).intValue() != list2.get(i).intValue() ) {
				return false;
			}
		}
		
		return true;
	}
	
	private void executeRotate() {
		List<Integer> list = new LinkedList<>();
		Integer k = 2;
		
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		
		Collections.rotate(list, k);
		
		System.out.println(
				String.format("The list rotated by %d is %s", k, list.toString())
		);
	}
	
}
