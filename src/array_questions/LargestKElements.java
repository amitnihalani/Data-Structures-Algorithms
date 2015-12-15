package array_questions;

public class LargestKElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {100, 10, 90, 70, 60, 30, 80, 40, 50, 20};
		int left=0, right=arr.length-1;
		int k =6;
		int partition = 0;
		while(k!=partition+1) {
			partition = getPatition(arr, left, right, k);
			
			if(partition+1 == k){
				break;
			}
			
		}

		System.out.println(partition + "\n");
		
		for(int i=0; i<=partition; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int getPatition(int[] arr, int start, int end, int k) {
		int partition = 0;

		if (k > 0 && k < end) {
			partition = partition(arr, start, end);

			if (k == partition+1) {
				return partition;
			} else if (k > partition) {
				partition =  getPatition(arr, partition+1, end, k);
			} else {
				partition =  getPatition(arr, start, partition, k);
			}
		}
		//return partition;
		return partition;
	}
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		while (start < end) {
			while (arr[start] <= pivot && start < end) {
				start++;
			}
			while (arr[end] > pivot && start < end) {
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
	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
