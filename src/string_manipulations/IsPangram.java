package string_manipulations;

import java.util.HashSet;
import java.util.Set;

public class IsPangram {

	private static int asciiValueOfLowerA = 97;
	private static int asciiValueOfLowerZ = 122;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPangram("qwertyuiop asdfghjkl zxcvbnm"));
	}

	private static boolean isPangram(String s) {

		if (s == null) {
			return false;
		}

		char[] characters = s.toCharArray();
		Set<Character> charSet = new HashSet<Character>();

		for (int i = 0; i < s.length(); i++) {
			if ((int) characters[i] >= 97 && (int) characters[i] <= 122) {
				charSet.add(characters[i]);
			}
		}
		if (charSet.size() == 26) {
			return true;
		}
		return false;
	}
	
}

//	----------------------------------------------JW PLAYER-------------------------------------
//	
//    static String isPangram(String[] strings) {
//        StringBuilder strBuilder = new StringBuilder();
//        // for each string, check if it is pangram
//        	for(String s : strings){
//                if(isPangramString(s)) {
//                    strBuilder.append("1");
//                } else {
//                    strBuilder.append("0");
//                }
//            }
//        return strBuilder.toString();
//    }
//
///**
//This function tests if a given string is pangram
//**/
//private static boolean isPangramString(String s) {
//        // if string is null, it is not a pangram
//		if (s == null) {
//			return false;
//		}
//
//		char[] characters = s.toCharArray();
//		Set<Character> charSet = new HashSet<Character>();
//
//        // enter all the lowercase alphabets in the string to the character set
//		for (int i = 0; i < s.length(); i++) {
//			if ((int) characters[i] >= 97 && (int) characters[i] <= 122) {
//				charSet.add(characters[i]);
//			}
//		}
//    
//        // if character set has size 26, it means the string has all characters from a-z in lowercase
//		if (charSet.size() == 26) {
//			return true;
//		}
//		return false;
//}
//
//}



