package binary_tress;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElementBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n\n Max element (using Recursion) is: " + returnMaxElementRecursion(root));
		System.out.println("\n\n Max element (using iterative method) is: " + returnMaxElementIterative(root));
	}

	// Return max element from tree recursively
	private static int returnMaxElementRecursion(BinaryNode root) {
		int max = -999;
		if(root == null){
			return max;
		}
		
 		int leftMax = returnMaxElementRecursion(root.left);
		int rightMax = returnMaxElementRecursion(root.right);
		
		if(leftMax>rightMax) {
			max = leftMax;
		}else {
			max = rightMax;
		}
		
		if(max<root.value){
			max = root.value;
		}
		
		return max;
	}
	
	// Returns max element without recursion
	private static int returnMaxElementIterative(BinaryNode root) {
		int max = Integer.MIN_VALUE;
		Queue<BinaryNode> q= new LinkedList<BinaryNode>();
		q.add(root);
		while(!q.isEmpty()){
			root = q.poll();
			if(root.value > max){
				max = root.value;
			}
			
			if(root.left!=null){
				q.add(root.left);
			}
			
			if(root.right!=null) {
				q.add(root.right);
			}
			
		}
		return max;
	}
}
