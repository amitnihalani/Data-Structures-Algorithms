package general_logic;

public class NumberToWords {

	static final String[] tens = { "twenty", "thirty", "forty", "fifty",
			"sixty", "seventy", "eighty", "ninety" };
	static final String[] digits = { "", "One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(numtoWords(521));

	}

	private static String numtoWords(int n) {
		StringBuilder sb = new StringBuilder();
		String number = Integer.toString(n);
		int i = number.length() - 1, unitsPlace = 0;
		while (i >= 0) {
			switch (Double.toString(Math.pow(10, unitsPlace))) {
			case "1.0":
				sb = sb.append(digits[Integer.parseInt(number.substring(i, i + 1))]);
				break;
			case "10.0":
				sb = sb.insert(0, tens[Integer.parseInt(number.substring(i, i + 1)) - 2] + " ");
				break;
			case "100.0":
				sb = sb.insert(0, digits[Integer.parseInt(number.substring(i, i + 1))] + " hundred ");
				break;
			default:
				break;

			}
			i--; 
			unitsPlace++;
		}

		return sb.toString();
	}

}
