package string_manipulations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IsIsomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("ab", "ab"));
	}

	public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        
        if(s.length() <=1 || t.length()<=1) {
            return true;
        }
        
        char[] originalString = s.toCharArray();
        
        for(int i=0; i<s.length(); i++) {
            if(!charMap.containsKey((Character)originalString[i])) {
                    charMap.put((Character)originalString[i], (Character)t.charAt(i));
                    originalString[i] = t.charAt(i);
            } else {
                originalString[i] = charMap.get(originalString[i]);
            }
            
            
        }

         return (String.valueOf(originalString).equals(t) && (charMap.values().size() == new HashSet<Character>(charMap.values()).size()));
    }
}
