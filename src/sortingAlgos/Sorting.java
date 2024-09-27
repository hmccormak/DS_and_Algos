package sortingAlgos;

import java.util.Random;

public class Sorting {
	int[] arr = new int[20];
	
	public Sorting() {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i: arr) {
			arr[i] = rand.nextInt(100);
		}
	}
	
	void insertionSort(int[] arr) {
		int n = arr.length;
		for (int k = 1; k < n; k++) {			// begin with second int
			int cur = arr[k];					// time to insert cur = arr[k]
			int j = k;							// find correct index j for cur
			while(j > k && arr[j-1] > cur) {	// thus arr[j-1] must go after cur
				arr[j] = arr[j-1];				// slide arr[j-1] rightward
				j--;							// and consider previous j for cur
			}
			arr[j] = cur;						// this is the proper place for cur
		}
	}
}
