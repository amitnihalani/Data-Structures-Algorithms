package array_questions;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.RET;

import sun.security.util.Length;

public class KthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array = { 1, 5, 4, 7, 6, 8, 9, 2, 3 };
		int[] array = { 20, 40, 30, 90, 70, 60, 10, 50 };
		System.out.println("Original Array: " + Arrays.toString(array));
		
		System.out.println("Enter k: ");
		int k = new Scanner(System.in).nextInt();
		int start = 0, partition = 0, end = array.length - 1;
//		System.out.println(returnKthLargestNumber(array, start, end,k));
		System.out.println(selectKth(array, k));
	}

	
	public static int returnKthLargestNumber(int[] arr, int start, int end,
			int k) {
		int partition = 0;

		if (k > 0 && k < end) {
			partition = partition(arr, start, end);

			if (k == partition) {
				return arr[partition];
			} else if (k > partition) {
				start = partition;
				return returnKthLargestNumber(arr, partition+1, end, k);
			} else {
				end = partition;
				return partition = partition(arr, start, partition);
			}
		}
		return partition;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		while (start <= end) {
			while (arr[start] <= pivot && start <= end) {
				start++;
			}
			while (arr[end] > pivot && start <= end) {
				end--;
			}

			if (start < end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start-1;
	}

	private static int findMaxInK(int[] arr, int partition) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= partition; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	
	// works in O(N)
	public static int selectKth(int[] arr, int k) {
		 if (arr == null || arr.length <= k)
		  throw new Error();
		 
		 int from = 0, to = arr.length - 1;
		 
		 // if from == to we reached the kth element
		 while (from < to) {
		  int r = from, w = to;
		  int mid = arr[(r + w) / 2];
		 
		  // stop if the reader and writer meets
		  while (r < w) {
		 
		   if (arr[r] >= mid) { // put the large values at the end
		    int tmp = arr[w];
		    arr[w] = arr[r];
		    arr[r] = tmp;
		    w--;
		   } else { // the value is smaller than the pivot, skip
		    r++;
		   }
		  }
		 
		  // if we stepped up (r++) we need to step one down
		  if (arr[r] > mid)
		   r--;
		 
		  // the r pointer is on the end of the first k elements
		  if (k <= r) {
		   to = r;
		  } else {
		   from = r + 1;
		  }
		 }
		 
		 return arr[k];
		}

}
