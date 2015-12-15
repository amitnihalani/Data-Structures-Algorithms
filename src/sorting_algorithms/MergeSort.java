package sorting_algorithms;

import java.util.Arrays;

public class MergeSort {
	private static int[] tempMergeArr;
	private static int[] array;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 4, 7, 6, 8, 9, 2, 3 };
		array = arr;
		tempMergeArr = new int[arr.length];
		mergeSort(arr);

		System.out.println(Arrays.toString(array));

	}

	private static void mergeSort(int[] array) {
		doMergeSort(0, array.length - 1);
	}

	private static void doMergeSort(int lowerIndex, int higherIndex) {
		int mid = 0;
		if(lowerIndex<higherIndex){
			mid=lowerIndex + (higherIndex-lowerIndex)/2;
			doMergeSort(lowerIndex, mid);
			doMergeSort(mid+1, higherIndex);
			
			mergeParts(lowerIndex, mid, higherIndex);
		}
	}
	
	private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
		 
        for (int i = lowerIndex; i <= higherIndex; i++) {
        	tempMergeArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergeArr[i] <= tempMergeArr[j]) {
                array[k] = tempMergeArr[i];
                i++;
            } else {
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergeArr[i];
            k++;
            i++;
        }
 
    }
}
