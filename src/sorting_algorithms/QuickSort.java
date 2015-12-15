package sorting_algorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 4, 7, 6, 8, 9, 2, 3 };
		System.out.println("Original Array: " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		if (arr == null || arr.length == 0)
			return;
		int partitionIndex = partition(arr, left, right);

		if (left < partitionIndex - 1) {
			// Sort left half
			quickSort(arr, left, partitionIndex - 1);
		}

		if (partitionIndex < right) {
			// Sort right half
			quickSort(arr, partitionIndex, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {

		int pivot = arr[left + (right - left) / 2];

		while (left <= right) {
			while (arr[left] < pivot) {
				// find element greater than pivot from left sub array
				left++;
			}

			while (arr[right] > pivot) {
				// find element smaller than pivot from right sub array
				right--;
			}

			if (left <= right) {
				// if elements exist on the wrong side of partition, swap
				// elements from left to right
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}
		return left;

	}

}
