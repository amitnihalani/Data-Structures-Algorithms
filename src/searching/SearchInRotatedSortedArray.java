package searching;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {15, 15, 15, 15, 15, 15, 15, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("Original Array: " + Arrays.toString(arr));
		// Assume we are looking for element 5
		
		int result = searchInRotatedSortedArray(arr, 0, arr.length-1, 5);
		System.out.println(result==-1? "Value not found":"Value found at index"+result);
	}

	private static int searchInRotatedSortedArray(int[] arr, int start,
			int end, int searchValue) {

		int mid = start + (end - start) / 2;

		if (arr[mid] == searchValue)
			return mid;

		if (start >= end)
			return -1;

		if (arr[mid] > arr[start]) {
			// left half sorted
			// values lies between start and end of sub array
			if (searchValue > arr[start] && searchValue < arr[mid]) {
				return searchInRotatedSortedArray(arr, start, mid, searchValue);
			} else {
				return searchInRotatedSortedArray(arr, mid+1, end, searchValue);
			}
		} else {
			// right half is sorted
			// value lies between start and end
			if (searchValue > arr[mid+1] && searchValue < arr[end]) {
				return searchInRotatedSortedArray(arr, mid+1, end, searchValue);
			} else {
				return searchInRotatedSortedArray(arr, start, mid, searchValue);
			}
		}
	}

}
