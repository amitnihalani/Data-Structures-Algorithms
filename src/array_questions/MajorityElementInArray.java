package array_questions;

public class MajorityElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 3, 2, 2, 4, 2, 5, 2, 6 };

		int c = candidate(arr);

		if (verifyCandidate(arr, c)) {
			System.out.println("Majority elemnt is: " + c);
		} else {
			System.out.println("No majority element");
		}
	}

	private static int candidate(int[] arr) {
		int c = arr[0], count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == c) {
				count++;
			} else {

				if (count > 0) {
					count--;
				} else {
					c = arr[i];
				}
			}
		}
		return c;
	}

	private static boolean verifyCandidate(int[] arr, int c) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == c) {
				count++;
			}
		}

		if (count > arr.length / 2) {
			return true;
		}
		return false;
	}
}
