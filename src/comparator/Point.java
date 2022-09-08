/**
 * 
 */
package comparator;

/**
 * @author stykky
 *
 */
public class Point {
    private int x;
    private int y;

	/*
	 * CONSTRUCTOR
	 */
    public Point( int x, int y ) {
        this.x = x;
        this.y = y;
    }

	/*
	 * PUBLIC METHODS
	 */
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    
	/*
	 * GETTERS / SETTERS
	 */
    public Integer getX() {
    	return x;
    }
    public Integer getY() {
    	return y;
    }
}