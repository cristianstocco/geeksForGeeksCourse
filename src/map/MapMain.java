/**
 * 
 */
package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author stykky
 *
 */
public class MapMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public MapMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("MapMain execution...");
		
		executeBasics();
		executeFrequencySorted();
		executeCommonElement();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeBasics() {
		Map<Integer, Integer> map = new TreeMap<>();

		map.put(2, 4);
		map.put(4, 8);
		map.put(8, 16);
		map.put(16, 32);
		
		System.out.println(
				String.format("Looking for value 4: %d", findValue(map, 4))
		);
		System.out.println(
				String.format("Size of map is: %d", map.size())
		);
		
		map.remove( 16 );
		
		printMap( map );
	}
	
	private int findValue( Map<Integer, Integer> map, int x ) {
		if( !map.containsKey(x) )
			return -1;
		
		return map.get(x);
	}
	
	private void printMap( Map<Integer, Integer> map ) {
		System.out.println( "Map contains: " );
		
		for( Map.Entry<Integer, Integer> entry : map.entrySet() ) {
			System.out.println( " ==>> " + entry.getKey() + " - > " + entry.getValue() );
		}
	}
	
	private void executeFrequencySorted() {
		List<Integer> list = new ArrayList<>();
		
		list.add( 1 );
		list.add( 2 );
		list.add( 2 );
		list.add( 0 );
		list.add( 2 );
		list.add( 1 );
		list.add( 2 );
		
		printFrequencySorted( list );
	}
	
	private void printFrequencySorted( List<Integer> list ) {
		Map<Integer, Integer> map = new TreeMap<>();
		
		for( Integer i : list ) {
			if( map.containsKey(i) ) {
				map.replace( i, map.get(i)+1 );
			}
			else {
				map.put(i, 1);
			}
		}
		
		printMap( map );
	}
	
	private void executeCommonElement() {
		int[] v1 = {1, 2, 3, 4, 5};
		int[] v2 = {3, 5, 10, 15};
		
		List<Integer> list = commonElement(v1, v2);
		
		System.out.print( "Common elements are: " );
		list.stream().forEach(
				(i) -> {System.out.print( i + ", " );}
		);
		System.out.println();
	}
	
	private List<Integer> commonElement( int[] v1, int[] v2 ) {
		List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> t1 = new TreeMap<>();
        Map<Integer, Integer> t2 = new TreeMap<>();
        
        for( int i : v1 ) {
            if( t1.containsKey(i) ) {
                Integer v = t1.get( i );
                t1.replace( i, v+1 );
            }
            else {
                t1.put( i, 1 );
            }
        }
        for( int i : v2 ) {
            if( t2.containsKey(i) ) {
                Integer v = t2.get( i );
                t2.replace( i, v+1 );
            }
            else {
                t2.put( i, 1 );
            }
        }
        
        for( Map.Entry<Integer, Integer> entry : t1.entrySet() ) {
            int key1 = entry.getKey();
            int value1 = entry.getValue();
            
            if( t2.containsKey(key1) ) {
                int lowerBound = Math.min( value1, t2.get(key1) );
                        
                for( int i = 0; i < lowerBound; i++ ) {
                    list.add( key1 );
                }
            }
        }
        
        return list;
	}

}
