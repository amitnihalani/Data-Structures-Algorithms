package sorting_algorithms;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,5, 4,7,6 ,8,9,2,3};

		array = bubbleSort(array);
		
		System.out.println(Arrays.toString(array));
		
	}
	
	private static int[] bubbleSort(int[] arr) {
		boolean sorted = true;
		
		while(true) {
			sorted = true;
			
			for(int i=1; i<arr.length; i++) {
				if(arr[i-1]>arr[i]) {
					sorted=false;
					int temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
				}
			}
			if(sorted==true){
				break;
			}
		}
		
		return arr;
	}

}
