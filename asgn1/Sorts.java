/*
 * CSC 349
 * Max Blau and Jake Territo
 * Assignment 1: Sorting Algorithms
 *
 * Last Revision: 1/10/18
 */

public class Sorts {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void selectionSort(int[] arr, int N) {
		int minIndex;
		for(int i = 0; i < N - 1; i++) {
			minIndex = i;
			for(int j = i; j < N - 1; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			swap(arr, minIndex, i);
		}
	}

	public static void mergeSort(int[] arr, int N) {
		mergeSort(arr, 0, N - 1);
	}

	private static void mergeSort(int[] arr, int first, int last) {
		if(first < last) {
			int middle = (first + last) / 2;
			mergeSort(arr, first, middle);
			mergeSort(arr, middle + 1, last);
			mergeSortedHalves(arr, first, middle, last);
		}
	}

	private static void mergeSortedHalves(int[] arr, int left, int middle, int right) {
		int[] temp = new int[right - left + 1];
		int index1 = left;
		int index2 = middle + 1;
		int index = 0;
		
		System.out.printf("Left: %d, Middle: %d, Right: %d\n", left, middle, right);

		while(index1 <= middle && index2 <= right) {
			if(arr[index1] < arr[index2]) {
				temp[index] = arr[index1];
				index1++;
			}
			else {
				temp[index] = arr[index2];
				index2++;
			}
			System.out.printf("Index1: %d, Index2: %d\n", index1, index2);
			index++;
		}
		if(index1 == middle + 1) {
			for(int i = index2; i <= right; i++) {
				temp[index] = arr[i];
				index++;
			}
		}
		else {
			for(int i = index1; i <= middle; i++) {
				System.out.printf("Index: %d, i: %d\n", index, i);
				temp[index - left] = arr[i];
				index++;
			}
		}

		for(int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}

	public static void quickSort(int[] arr, int N) {

	}
}
