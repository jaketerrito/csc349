/*
 * CSC 349
 * Max Blau and Jake Territo
 * Assignment 1: Sorting Algorithms
 *
 * Last Revision: 1/17/18
 */

import java.util.*;

public class SortCounts {

	public static void main(String[] argv) {
		int[] arr1 = new int[12800];
		int[] arr2 = new int[12800];
		int[] arr3 = new int[12800];
		
		long quickTotal, mergeTotal, selectionTotal;

		for(int i = 100; i <= 12800; i *= 2) {
                   mergeTotal = selectionTotal = quickTotal = 0;
			for(int j = 0; j < 100; j++) {
				fillArray(arr1, i);
				arr3 = arr2 = Arrays.copyOf(arr1,i);
				selectionTotal += Sorts1.selectionSort(arr1, i);
				checkSorted(arr1, i);
				mergeTotal += Sorts1.mergeSort(arr2, i);
				checkSorted(arr2,i);
				quickTotal += Sorts1.quickSort(arr3, i);
				checkSorted(arr3,i);
			}

			System.out.printf("N=%d: C_ss=%d, C_ms=%d, C_qs=%d\n", i, selectionTotal/100, mergeTotal/100, quickTotal/100);
		}
	}
         private static void checkSorted(int[] arr, int N){
            int[] sorted = new int[N];
            sorted = Arrays.copyOf(arr,N);
            Arrays.sort(sorted);
            for(int x = 0; x < N; x++){
               if(arr[x] != sorted[x]){
                  System.out.printf("Index: %d, %d provided, %d expected.\n",x,arr[x],sorted[x]);
               }
            }
         }

	private static void fillArray(int[] arr, int N) {
		Random rand = new Random();
		for(int i = 0; i < N; i++) {
			arr[i] = rand.nextInt(N);
		}
	}
}
