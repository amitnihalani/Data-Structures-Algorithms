package searching;

public class FindElementWithOddOccurances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,2,2,3,3,3,3,4,4,4,4,5,5};
		int xorSum = 0;
		for(int i=0; i<array.length; i++) {
			xorSum = xorSum^array[i];
		}
		
		System.out.println(String.format("%d occurs odd number of times", xorSum));
	}

}
