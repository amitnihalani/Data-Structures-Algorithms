package amazon_questions;

public class PrintTwoDimArraySpirally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[][] arr = createTwoDimensionalArray(2, 3);
		System.out.println("Original Array: ");
		printArray(arr);
		System.out.println("\nSpiral numbers: ");
		printSpiral(arr);
		
		int[][] arr1 = createTwoDimensionalSquareArray(4);
		System.out.println("\nOriginal Array: ");
		printArray(arr1);
		System.out.println("\nSpiral numbers: ");
		printSpiral(arr1);
	}

	private static void printSpiral(int[][] array) {
		int rows = array.length, col = array[0].length;
		int row1 = 0, row2 = array.length - 1, col1 = array[0].length - 1, col2 = 0;
		int level = 0;
		while(row2>row1 && col1>col2) {
			//print 1st row
			for (int i = row1; i < col1; i++) {
				System.out.print(array[row1][i] + " ");
			}
			// print last col
			for (int i = row1; i < row2; i++) {
				System.out.print(array[i][col1] + " ");
			}
			// print last row
			for (int i = col1; i > col2; i--) {
				System.out.print(array[row2][i] + " ");
			}
			
			// print first column
			for (int i = row2; i > row1; i--) {
				System.out.print(array[i][row1] + " ");
			}
			
			row1++;
			row2--;
			col1--;
			col2++;
		}
	}

	private static void printRow(int[][] a, int rowNumber, int level) {
		for (int col = level; col < a.length - level; col++) {
			System.out.print(a[rowNumber][col] + " ");
		}
	}

	private static void printCol(int[][] a, int colNumber, int level) {
		for (int row = level; row < a[0].length - level; row++) {
			System.out.print(a[row][colNumber] + " ");
		}
	}

	private static int[][] createTwoDimensionalSquareArray(int length) {
		int[][] twoDimArray = new int[length][length];

		for (int i = 0, count = 1; i < length; i++) {
			for (int j = 0; j < length; j++) {
				twoDimArray[i][j] = count++;
			}
		}
		return twoDimArray;
	}

	
	private static int[][] createTwoDimensionalArray(int row, int col) {
		int[][] twoDimArray = new int[row][col];

		for (int i = 0, count = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				twoDimArray[i][j] = count++;
			}
		}
		return twoDimArray;
	}

	
	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(" " + arr[i][j]);
			}
		}
	}
}
