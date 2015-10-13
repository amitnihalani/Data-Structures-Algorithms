package array_questions;

public class ContinuousSubSequenceMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { -7, 4, -2, 5, 3, -6, 8, -9 };
		System.out.println("Max sum of Sub-array is: "
				+ returnMaxSumOfSubArray(arr));
		
		printSubSequenceWithMaximumSum(arr);
		
	}

	private static void printSubSequenceWithMaximumSum(int[] arr) {
		int startIndex = 0, endIndex = 0;
		int currentSum = 0, maxSum = 0;
		int outerIndex, innerIndex;
		
		for (outerIndex = 0; outerIndex < arr.length; outerIndex++) {
			currentSum=0;
			for (innerIndex = outerIndex; innerIndex < arr.length; innerIndex++) {
				currentSum += arr[innerIndex];

				if (maxSum < currentSum) {
					maxSum = currentSum;
					startIndex = outerIndex;
					endIndex = innerIndex;
				} else if (currentSum<0){
					break;
				}
			}
		}
		System.out.print("The sub-array with max sum is {");
		for(int i=startIndex; i<=endIndex; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.print("}");
	}

	private static int returnMaxSumOfSubArray(int[] arr) {
		int currentSum = 0, max = 0;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];

			if (max < currentSum) {
				max = currentSum;
			} else if (currentSum < 0) {
				currentSum = 0;
			}
		}

		return max;
	}

}
