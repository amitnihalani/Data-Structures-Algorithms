package amazon_questions;

import java.util.ArrayList;
import java.util.List;




public class MaxSumPath {

	static int maxSum = -100000;
	static BinaryNode maxLeaf=null;
	static int currentSum =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		
		int[] path = returnMaxSumPath(root, new int[20], new int[20], 0, 0, 0);
		System.out.println("\n \n" + path.toString());
		maxSum(root, 0);
		System.out.println("\n \n");
		path(root, maxLeaf);
		
	}

	
		
	
	public static void maxSum(BinaryNode root, int sum){
		if(root!=null){
			sum=sum+root.value;
			if(sum>maxSum && root.left==null && root.right==null){
				maxLeaf = root;
				maxSum = sum;
			}
		//	System.out.println("Sum " + sum);
			maxSum(root.left,sum);
			maxSum(root.right,sum);
		}
	}
	
	public static Boolean path(BinaryNode root, BinaryNode leaf){
		if(root==null) return false;
		if ((root == leaf) || path(root.left, leaf) ||path(root.right, leaf) )
		{
			System.out.print(" " + root.value);
			return true;
		}
			return false;
	}
	
	private static int[] returnMaxSumPath(BinaryNode root, int[] path, int[] finalPath, int sum, int max, int len){
		if(root == null) {
			return finalPath;
		}
		sum=sum+root.value;
		path[len++]=(root.value);
		
		if(root.left==null && root.right==null){
			if(sum>max){
				max=sum;
				finalPath = path;
			}
		}
		
	returnMaxSumPath(root.left, path, finalPath, sum, max, len);
	 returnMaxSumPath(root.right, path, finalPath, sum, max, len);
		
		return finalPath;
	}
	
}
