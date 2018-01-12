import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		int[] testArray = new int[100];
		fillArray(testArray, 100);
		Sorts.quickSort(testArray, testArray.length);
		checkIfSorted(testArray);
	}

	private static void printArray(int[] array) {
		System.out.printf("Sorted array: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("");
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
				System.out.printf("Sort failed at segment: %d [%d %d] %d\n", arr[i-2], arr[i-1], arr[i], arr[i+1]);
				return;
			}
		}
		System.out.println("Done");
	}
}
