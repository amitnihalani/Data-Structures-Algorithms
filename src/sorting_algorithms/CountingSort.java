package sorting_algorithms;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 1, 2, 3, 4, 1, 1, 3, 3, 1 };
		// here range is 4 since there are just 4 unique values in array
		countingSort(arr, 4);
		
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue. Here, we will use the integers 0, 1, and 2 to
	 * represent the color red, white, and blue respectively.
	 */
	private static void countingSort(int[] arr, int rangeSize) {

		int[] range = new int[rangeSize+1];

		for (int i = 0; i < arr.length; i++) {
			range[arr[i]]++;
		}

		int arrIndex = 0;
		for (int rangeIndex = 0; rangeIndex < range.length; rangeIndex++) {

			while (range[rangeIndex] > 0) {
				arr[arrIndex++] = rangeIndex;
				range[rangeIndex]--;
			}
		}
	}

}
