package string_manipulations;

public class IsSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = "qwerty";
		String string2="qwerytqwerty";
		
		System.out.println("Actual strings: " + string1 + " " + string2);
		System.out.println("Is string1 substring of string2 ?");
		System.out.println("Actual answer: " + string2.contains(string1));
		System.out.println("Your answer: " + isSubstring(string1, string2));
		

	}
	

	private static boolean isSubstring(String string1, String string2) {
		
		for(int i=0; i<string2.length(); i++) {
			int j=0;
			if(string1.charAt(j) == string2.charAt(i)) {
				while((j<string1.length()) && (i+j < string2.length()) && (string2.charAt(i+j) == string1.charAt(j)) ) {
					j++;
				}
				
				if((j-1)==string1.length()-1) {
					return true;
				}
			}
		}
		return false;
	}

}
