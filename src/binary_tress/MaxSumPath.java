package binary_tress;

import java.util.ArrayList;


public class MaxSumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		int[] path = returnMaxSumPath(root, new int[10], new int[10], 0, 0, 0);
		System.out.println();
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
