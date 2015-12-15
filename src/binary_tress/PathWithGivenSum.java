package binary_tress;

import java.util.Arrays;
import java.util.Scanner;

public class PathWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nEnter the sum you want to check: ");
		int sum = sc.nextInt();
		
		System.out.println("\nPath Found? : " + isPathExists(root, sum));
		System.out.println("\nPath Found? :"  );
//		System.out.println(Arrays.toString());
		pathWithSum(root, new int[20], 0, sum, 0);
	}

	private static boolean checkIfPathWithSumExists(BinaryNode root, int sum, int currentSum){
		if(root == null) {
			return false;
		}
			currentSum += root.value; 
		if(currentSum == sum && root.left == null && root.right == null){
			return true;
		}

		boolean leftPath = checkIfPathWithSumExists(root.left, sum, currentSum);
		boolean rightPath = checkIfPathWithSumExists(root.right, sum, currentSum);

		if(leftPath || rightPath) {
			return true;
		} 
		return false;
	}
	
	private static void  pathWithSum(BinaryNode root, int[] path, int len, int sum, int currentSum) {
		if(root==null ) {
			return;
		}

		path[len++] = root.value;
		currentSum = currentSum + root.value;

		if(sum == currentSum && root.left == null && root.right == null) {
			printPath(path);
			return ;
		}
		
		pathWithSum(root.left, path, len, sum, currentSum);
		pathWithSum(root.right, path, len, sum, currentSum);

	}
	
	private static void printPath(int[] path) {
		for(int i=0; i<path.length; i++) {
			System.out.print(path[i] + " ");
		}
	}
	
	private static boolean isPathExists(BinaryNode root, int sum) {

		if(root == null && sum==0) {
			return true;
		}

		if(root == null) {
			return false;
		}

		boolean leftPath = isPathExists(root.left, sum - root.value);
		boolean rightPath = isPathExists(root.right, sum - root.value);

		return (leftPath || rightPath);
	}
}
