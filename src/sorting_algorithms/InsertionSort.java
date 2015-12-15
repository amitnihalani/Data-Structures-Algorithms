package sorting_algorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 4, 7, 6, 8, 9, 2, 3 };
		arr = insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static int[] insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int j=i, temp=0;
			while(j>0) {
				if(arr[j]<arr[j-1]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
				j--;
			}
		}
		return arr;
	}

}
