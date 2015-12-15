package searching;

public class TwoDimensionalSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = createTwoDimensionalArray(4,5);
		System.out.println("Original Array: ");
		printArray(arr);
		// Lets assume we are looking for 11
		System.out.println("\n \n Element 18 found in 2d Array: " + searchInArray(arr, 20));
		
	}
	
	private static int[][] createTwoDimensionalArray(int rowCount, int columnCount){
		int[][] twoDimArray = new int[rowCount][columnCount];
		
		for(int i=0, count=1; i<rowCount; i++){
			for(int j=0; j<columnCount; j++){
				twoDimArray[i][j] = count++;
			}
		}
		return twoDimArray;
	}
	
	private static void printArray(int[][] arr){
		for(int i=0; i<arr.length; i++){
			System.out.println();
			for(int j=0; j<arr[0].length; j++){
				System.out.print(" " + arr[i][j]);
			}
		}
	}
	
	private static boolean searchInArray(int[][] arr, int x) {
		int row=0;
		int column = arr[0].length-1;
		
		while(row<arr.length && column>=0) {
			if(arr[row][column] == x){
				return true;
			}
			
			if(x > arr[row][column]) {
				//if x is greater than current element, skip the row and move to next row
				row++;
			} else if(x < arr[row][column]){
				column--;
			}
		}
		
		return false;
	}

}
