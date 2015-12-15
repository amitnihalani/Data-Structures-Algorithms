package string_manipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original = "map cat amp qwerty tac pma ytrewq";
		System.out.println(groupAnagrams(original));
	}

	private static String groupAnagrams(String s) {
		String[] strings = s.split(" ");
		Map<String, List<String>> anagramMap = new LinkedHashMap<String, List<String>>();
		
		for(String str : strings) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			if(!anagramMap.containsKey(String.valueOf(charArray))){
				anagramMap.put(String.valueOf(charArray), new ArrayList<String>());
			} 
			anagramMap.get(String.valueOf(charArray)).add(str);
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for(List<String> anagramList : anagramMap.values()){
			for(String anagram : anagramList) {
				stringBuilder.append(anagram);
				stringBuilder.append(" ");
			}
		}
		
		return stringBuilder.toString().trim();
	}
}
