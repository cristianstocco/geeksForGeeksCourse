/**
 * 
 */
package sort;

/**
 * @author stykky
 *
 */
class IndexedItem {
    public int item;
    public int index;

	/*
	 * CONSTRUCTOR
	 */
    public IndexedItem(int item,int index) {
        this.item = item;
        this.index = index;
    }
    
	/*
	 * PUBLIC METHODS
	 */
    public String toString() {
    	return "(" + item + ", " + index + ")";
    }
}