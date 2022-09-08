/**
 * 
 */
package sort;

/**
 * @author stykky
 *
 */
public class Sort {
	
	/*
	 * CONSTRUCTOR
	 */
	private Sort() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public static void bubbleSort( int[] array ) {
		for( int j = 0; j < array.length; j++ ) {
            for( int i = 0; i < array.length-1; i++ ) {
               if( array[i] > array[i+1] ) {
                   swap( array, i, i+1 );
               }
           }
		}
	}
	
	public static void mergeSort( int[] array ) {
		mergeSort( array, 0, array.length-1 );
	}
		
	public static void mergeSort( int[] array, int l, int r ) {
		if( l>=r )
            return;
            
        int mid = l + (r - l) / 2;
        mergeSort(array,l,mid);
        mergeSort(array,mid+1,r);
        
        merge(array,l,mid,r);
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private static void swap( int[] array, int i, int j ) {
		int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
	}
	
	private static void merge(int arr[], int l, int m, int r) {
        int[] merged = new int[ r-l+1 ];
   
        int idx1 = l;
        int idx2 = m+1;
        int x = 0;
   
        while( idx1<=m && idx2<=r ) {
            if(arr[idx1] <= arr[idx2])
                merged[x++] = arr[idx1++];
            else
                merged[x++] = arr[idx2++];
        }
     
        while( idx1 <= m )
            merged[x++] = arr[idx1++];
        
        while( idx2 <= r )
            merged[x++] = arr[idx2++];
     
      
        for( int i = 0, j = l; i < merged.length; i++, j++)
            arr[j] = merged[i];
    }

}
