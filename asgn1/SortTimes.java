/*
 * CSC 349
 * Max Blau and Jake Territo
 * Assignment 1: Sorting Algorithms
 *
 * 1/19/18
 */

import java.util.*;

public class SortTimes {

	public static void main(String[] argv) {
		int[] arr1 = new int[160000];
		int[] arr2 = new int[160000];
		int[] arr3 = new int[160000];
		
		long startTime, quickTime, mergeTime, selectionTime;

		for(int i = 5000; i <= 160000; i *= 2) {
			for(int j = 0; j < 5; j++) {
				fillArray(arr1, i);
				arr3 = Arrays.copyOf(arr1,i);
				arr2 = Arrays.copyOf(arr1,i);
				startTime = System.nanoTime();
				Sorts.selectionSort(arr1, i);
         			selectionTime = (System.nanoTime() - startTime);
				//checkSorted(arr1, i);
				startTime = System.nanoTime();
				Sorts.mergeSort(arr2, i);
         			mergeTime = (System.nanoTime() - startTime);
				//checkSorted(arr2,i);
				startTime = System.nanoTime();
				Sorts.quickSort(arr3, i);
         			quickTime = (System.nanoTime() - startTime);
				//checkSorted(arr3,i);
				System.out.printf("N=%d, T_ss=%d, T_ms=%d, T_qs=%d\n", i, selectionTime/1000000, mergeTime/1000000, quickTime/1000000);
			}
			System.out.println();
		}
	}

	//Tester function to check if a given array is sorted
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
