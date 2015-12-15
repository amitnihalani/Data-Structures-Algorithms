package recursion;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleNumbers_DifferenceBetweenDigits_GOOGLE {

	static List<Character> digits;
	static List<List<Character>> numbers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number1 = 2134;
		int number2 = 9856;
		
		LinkedList<List<Character>> numbersLL = getList(number1, number2);
		numbers = new ArrayList<>(numbersLL);
		generateAllNumbers(0, 0, new int[10], 0);
	}

	private static LinkedList<List<Character>> getList(int n1, int n2) {
		int digit1, digit2, diff, place = 1;
		LinkedList<List<Character>> list = new LinkedList<>();
		digit1 = n1 % 10;
		digit2 = n2 % 10;
		n1 = n1/10;
		n2=n2/10;

		while (digit1 > 0 || digit2 > 0) {
			diff = Math.abs(digit2 - digit1);
			int smallerNumber = (digit1 < digit2 ? digit1 : digit2);
			List<Character> interval = new ArrayList<>();
			for(int i=smallerNumber+1; i<smallerNumber+diff; i++){
				interval.add((char)(i+48));
			}
			list.addFirst(interval);
			digit1 = n1 % 10;
			digit2 = n2 % 10;
			n1 = n1/10;
			n2=n2/10;
		}
			return list;
		
	}

	private static void generateAllNumbers(int listNumber, int indexNumber,
			int[] number, int length) {

		if (listNumber >= numbers.size()
				|| indexNumber >= numbers.get(listNumber).size()) {
			return;
		}

		number[length++] = numbers.get(listNumber).get(indexNumber)-48;
		if (listNumber == numbers.size()-1) {
			printNumber(number, length);
		}
		
		generateAllNumbers(listNumber + 1, indexNumber, number, length);
		generateAllNumbers(listNumber, indexNumber + 1, number, length);
		
			
	}

	private static void printNumber(int[] number, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(number[i]);
		}
		System.out.println();
	}

}
