/**
 * 
 */
package comparator;

/**
 * @author stykky
 *
 */
@FunctionalInterface
interface PointComparator {
	public Integer compareTo(Point p1, Point p2);
}

public class PointComparatorLambda {
	
	public PointComparator compareTo() {
		return (Point p1, Point p2) -> {
			if( p1.getX() == p2.getX() )
                return p1.getY() - p2.getY();
			
            return p1.getX() - p2.getX();
		};
	}
	
}
