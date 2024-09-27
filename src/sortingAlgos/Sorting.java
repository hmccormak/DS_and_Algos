package sortingAlgos;

import java.util.Random;
import java.util.Arrays;

public class Sorting {
	int[] arr, orig;
	
	public Sorting(int size) {
		this.arr = new int[size];
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		this.orig = Arrays.copyOf(arr, size);
	}
	
	void insertionSort() {
		int n = this.arr.length;
		for (int k = 1; k < n; k++) {				// begin with second int
			int cur = this.arr[k];					// time to insert cur = arr[k]
			int j = k;								// find correct index j for cur
			while(j > 0 && this.arr[j-1] > cur) {	// thus arr[j-1] must go after cur
				this.arr[j] = this.arr[j-1];		// slide arr[j-1] rightward
				j--;								// and consider previous j for cur
			}
			this.arr[j] = cur;						// this is the proper place for cur
		}
		results(this.arr, this.orig);
	}
	
	void results(int[] arr, int[] orig) {
		System.out.println("Original array: " + Arrays.toString(orig));
		System.out.println("After sorting: " + Arrays.toString(arr));
	}
	
	public static void main(String[] args) throws Exception {
		Sorting iSort = new Sorting(20);
		iSort.insertionSort();
	}
}
