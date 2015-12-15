package array_questions;

import java.util.HashSet;
import java.util.Set;

public class StringsIn2DArray {

	static public Set<String> dict = new HashSet<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dict.add("GEEKS");
		dict.add("FOR");
		dict.add("QUIZ");
		dict.add("SEKI");
		

		char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' },
				{ 'Q', 'S', 'E' } };

		System.out.println("Following words of dictionary are present\n");
		findWords(boggle);

	}

	// A given function to check if a given string is present in
	// dictionary. The implementation is naive for simplicity. As
	// per the question dictionary is givem to us.
	static boolean isWord(String str) {
		if (dict.contains(str)) {
			return true;
		}
		return false;
	}

	// A recursive function to print all words present on boggle
	static void findWordsUtil(char[][] boggle, boolean[][] visited, int i,
			int j, String str) {
		// Mark current cell as visited and append current character to str
		visited[i][j] = true;
		str = str + boggle[i][j];

		// If str is present in dictionary, then print it
		if (isWord(str)) {
			System.out.println(str);
		}

		// Traverse 8 adjacent cells of boggle[i][j]
		for (int row = i - 1; row <= i + 1 && row < boggle.length; row++)
			for (int col = j - 1; col <= j + 1 && col < boggle[0].length; col++)
				if (row >= 0 && col >= 0 && !visited[row][col])
					findWordsUtil(boggle, visited, row, col, str);

		// Erase current character from string and mark visited
		// of current cell as false
		StringBuilder sb = new StringBuilder(str);
		sb.deleteCharAt(str.length() - 1);
		str = sb.toString();

		visited[i][j] = false;
	}

	// Prints all words present in dictionary.
	static void findWords(char[][] boggle) {
		// Mark all characters as not visited
		boolean visited[][] = new boolean[boggle.length][boggle[0].length];

		// Initialize current string
		String str = "";

		// Consider every character and look for all words
		// starting with this character
		for (int i = 0; i < boggle.length; i++)
			for (int j = 0; j < boggle[0].length; j++)
				findWordsUtil(boggle, visited, i, j, str);
	}
}
