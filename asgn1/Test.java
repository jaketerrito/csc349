public class Test {

	public static void main(String[] args) {
		int[] testArray = {4, 2, 1, 7, 13, 5, 14, 9, 12, 6, 15, 3, 11, 8, 10};
		Sorts.quickSort(testArray, testArray.length);
		printArray(testArray);
	}

	private static void printArray(int[] array) {
		System.out.printf("Sorted array: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("");
	}
}
