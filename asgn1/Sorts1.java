/*
 * CSC 349
 * Max Blau (mbblau) and Jake Territo (jterrito)
 * Assignment 1: Sorting Algorithms
 * Counting version
 * 1/19/18
 */

public class Sorts1 {
   private static long countm,countq;

   private static void swap(int[] arr, int i, int j) {
      if(i == j || arr[i] == arr[j]) return;
         int temp = arr[i];
	 arr[i] = arr[j];
	 arr[j] = temp;
   }

   public static long selectionSort(int[] arr, int N) {
      int minIndex;
      long count = 0;
      for(int i = 0; i < N-1; i++){
         minIndex = i;
	 for(int j = i+1; j < N; j++){
	    if(arr[minIndex] > arr[j]){
	       minIndex = j;
	    }
            count++;
	 }
         swap(arr, minIndex, i);
      }
      return count;
   }

   public static long mergeSort(int[] arr, int N) {
      countm = 0;
      mergeSort(arr, 0, N - 1);
      return countm;
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
		
      while(index1 <= middle && index2 <= right) {
	 if(arr[index1] < arr[index2]) {
	    temp[index] = arr[index1];
	    index1++;
	 }else {
	    temp[index] = arr[index2];
	    index2++;
	 }
         countm++;
	 index++;
      }
      if(index1 == middle + 1) {
	 for(int i = index2; i <= right; i++) {
	    temp[index] = arr[i];
	    index++;
	 }
      }else {
	 for(int i = index1; i <= middle; i++) {
	    temp[index] = arr[i];
	    index++;
	 }
      }

      for(int i = 0; i < temp.length; i++) {
	 arr[i+left] = temp[i];
      }
   }

   public static long quickSort(int[] arr, int N) {
      countq = 0;
      quickSort(arr,0,N-1);
      return countq;
   }

   private static void quickSort(int[] arr, int first, int last){
      if(first < last){
         setPivotToEnd(arr,first, last);
         int pivotIndex = splitList(arr,first,last);
         quickSort(arr, first, pivotIndex -1);
         quickSort(arr, pivotIndex +1, last);
      }
   }

   private static void setPivotToEnd(int[] arr, int first, int last) {
      int mid = (first+last)/2;
      if(arr[first] > arr[last]){
         swap(arr,first,last);
      }
      if(arr[last] > arr[mid]){
         swap(arr,last,mid);
      }
      if(arr[first] > arr[last]){
         swap(arr,first,last);
      }
      countq += 3;
   }

   private static int splitList(int[] arr, int first, int last){
      int indexl, indexr, pivot;
      indexl = first;
      indexr = last-1;
      pivot = arr[last];
      while(indexl <= indexr){
         while(arr[indexl] < pivot){
            indexl++;
            countq ++;
         }
         countq++;
         while(indexr >= indexl){
            countq++;
            if(arr[indexr] > pivot){
               indexr--;
            }else{
               break;
            }
         }
         if(indexr >= indexl){
            swap(arr,indexr,indexl);
            indexr--;
            indexl++;
         }
      }
      swap(arr,indexl,last);
      return indexl;
   }

   private static void printArray(int[] array) {
      System.out.printf("Array: ");
      for(int i = 0; i < array.length; i++) {
	 System.out.print(array[i] + ", ");
      }
      System.out.println("");
   }

}
