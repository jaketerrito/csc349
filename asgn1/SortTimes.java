/*
 * CSC 349
 * Max Blau and Jake Territo
 * Assignment 1: Sorting Algorithms
 *
 * Last Revision: 1/12/18
 */

import java.util.Random;

public class SortTimes {

	public static void main(String[] argv) {
		int[] arr1 = new int[160000];
		int[] arr2 = new int[160000];
		int[] arr3 = new int[160000];
		
		long startTime, quickTime, mergeTime, selectionTime;

		for(int i = 5000; i <= 160000; i *= 2) {
			for(int j = 0; j < 5; j++) {
				fillArray(arr1, i);
				arr3 = arr2 = arr1.clone();
				startTime = System.nanoTime();
				Sorts.selectionSort(arr1, i);
         			selectionTime = (System.nanoTime() - startTime);
				System.out.printf("Selection Sort: ");
				checkIfSorted(arr1);
				startTime = System.nanoTime();
				Sorts.mergeSort(arr1, i);
         			mergeTime = (System.nanoTime() - startTime);
				System.out.printf("Merge sort: ");
				checkIfSorted(arr2);
				startTime = System.nanoTime();
				Sorts.quickSort(arr1, i);
         			quickTime = (System.nanoTime() - startTime);
				System.out.printf("Quick sort: ");
				checkIfSorted(arr3);
				System.out.printf("N=%d, T_ss=%d, T_ms=%d, T_qs=%d\n", i, selectionTime/1000000, mergeTime/1000000, 420);
			}
			System.out.println();
		}
	}

	private static void fillArray(int[] arr, int N) {
		Random rand = new Random();
		for(int i = 0; i < N; i++) {
			arr[i] = rand.nextInt(N);
		}
	}	
	private static void checkIfSorted(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i-1] > arr[i]) {
				System.out.printf("Sort failed at segment: [%d %d] with indices %d and %d\n", arr[i-1], arr[i], i-1, i);
				return;
			}
		}
		System.out.println("Done");
	}
}
