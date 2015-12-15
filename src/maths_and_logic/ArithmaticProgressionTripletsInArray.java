package maths_and_logic;

public class ArithmaticProgressionTripletsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAPTriplets(new int[]{1, 4, 7, 13, 15, 21, 25, 29});
	}
	
	private static void printAPTriplets(int[] arr) {
		int n = arr.length;
		
		for(int i = n-1; i>=2; i--) {
			int left = 0, right = i-1;
			
			while(left<right) {
				if(arr[left] == (2*arr[right]) - arr[i]) {
					System.out.println("a: " + arr[left] + "  b: " + arr[right] + "  c: " + arr[i]);
				}
				
				if(arr[left] < 2*arr[right] - arr[i]) {
					left++;
				} else {
					right--;
				}
			}
		}
	}

}
