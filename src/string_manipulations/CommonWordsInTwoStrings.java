package string_manipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonWordsInTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Common WOrds: " + getCommonWords("This is string one. The length - 4", "This is string two. Its length- 4"));
	}
	
	private static String getCommonWords(String s1, String s2){
		List<String> longerString = new ArrayList<>();
		String[] shorterString;
		
		if(s1.length() > s2.length()){
			longerString.addAll( Arrays.asList(s1.split(" ")));
			shorterString = s2.split(" ");
		} else {
			longerString.addAll( Arrays.asList(s2.split(" ")));
			shorterString = s1.split(" ");
		}
		
		Set<String> wordSet = new HashSet<String>();
		StringBuilder strBuilder = new StringBuilder();
		
		for(String word : shorterString) {
			wordSet.add(word);
		}
		
		for(String word : longerString) {
			if(wordSet.contains(word)) {
				strBuilder.append(word + " ");
			}
		}
		
		return strBuilder.toString();
	}
	
	
//	private static String getCommonWordsBySorting(String s1, String s2) {
//		String[] wordsInStringOne = s1.split(" ");
//		String[] wordsInStringTwo = s2.split(" ");
//		StringBuilder strBuilder = new StringBuilder();
//		
//		Arrays.sort(wordsInStringOne);
//		Arrays.sort(wordsInStringTwo);
//		
//		for(int i=0, j=0; i<wordsInStringOne.length && j< wordsInStringTwo.length;) {
//			if(wordsInStringOne[i] == wordsInStringTwo[i]) {
//				strBuilder.append(wordsInStringOne[i] + " ");
//			} else if((int)wordsInStringOne[i] > (int)wordsInStringTwo[i]) {
//				
//			}
//		}
//		return null;
//	}

}


