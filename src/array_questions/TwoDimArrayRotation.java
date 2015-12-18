package array_questions;

public class TwoDimArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = createTwoDimensionalArray(4);
		System.out.println("Original Array: ");
		printArray(arr);
		rotateArray(arr);
		System.out.println("\n \n Rotated Array: ");
		printArray(arr);
		
	}
	
	private static int[][] createTwoDimensionalArray(int length){
		int[][] twoDimArray = new int[length][length];
		
		for(int i=0, count=1; i<length; i++){
			for(int j=0; j<length; j++){
				twoDimArray[i][j] = count++;
			}
		}
		return twoDimArray;
	}
	
	private static void printArray(int[][] arr){
		for(int i=0; i<arr.length; i++){
			System.out.println();
			for(int j=0; j<arr.length; j++){
				System.out.print(" " + arr[i][j]);
			}
		}
	}
	
	private static int[][] rotateArray(int[][] arr){
		int length = arr.length; 
		for(int row=0; row<(length/2); row++){
			
			for(int column=row; column<(length-row-1) ; column++){
				int temp = arr[row][column];
				arr[row][column] = arr[length-column-1][row];
				arr[length-column-1][row] = arr[length-row-1][length-column-1];
				arr[length-row-1][length-column-1] = arr[column][length-row-1];
				arr[column][length-row-1] = temp;
			}
		}
		return arr;
	}

}
