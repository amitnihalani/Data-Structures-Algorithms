package string_manipulations;

import java.util.Scanner;

public class AllPalindromesInString {

	public static void main(String args[]) {
		// Scanner in = new Scanner(System.in);
		// System.out.println("Enter a string to print it's all substrings");
		// String string = in.nextLine();
		//
		// System.out.println(countPalindromes(string));
		int[] elements = { 1, 2,  4, 4, 4, 4, 5, 6, 7, 8, 9 };
		System.out.println(elements.length);
		System.out.println(sorted_search(elements, 4));

	}

	private static int countPalindromes(String str) {
		String string, sub;
		int j, i, length, palindromes = 0;
		length = str.length();

		for (i = 0; i < length; i++) {
			for (j = 1; j <= length - i; j++) {
				sub = str.substring(i, i + j);
				if (isPalindrome(sub)) {
					palindromes++;
				}
			}
		}
		return palindromes;
	}

	private static boolean isPalindrome(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return true;
		}

		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	static int sorted_search(int[] elements, int target) {
		if (elements == null || elements.length <= 0) {
			return -1;
		}
			

		int left = 0, right = elements.length - 1;

		while (left < right) {
			int middle = (left + right + 1) / 2;

			if (elements[middle] > target) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		if(elements[right]==target) return right;
		return -1;
	}

}
