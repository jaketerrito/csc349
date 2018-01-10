public class Test {

	public static void main(String[] args) {
		int[] testArray = {5, 19, 24, 13, 7, 58, 12, 10, 4, 2, 84, 32, 69, 100};
		Sorts.mergeSort(testArray, testArray.length);
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
