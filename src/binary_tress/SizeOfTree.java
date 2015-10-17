package binary_tress;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SizeOfTree {

	public static void main(String[] args) {
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println(String.format("\n \n Size of the tree calculated using ITERATIVE APPROACH is: %d", calculateTreeSizeIterative(root)));
		System.out.println(String.format("\n Size of the tree calculated using RECURSIVE APPROACH is: %d", calculateTreeSizeRecursive(root)));
	}

	private static int calculateTreeSizeIterative(BinaryNode root) {
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		if(root == null) {
			return 0;
		}

		q.add(root);
		int count =0;

		while(!q.isEmpty()) {
			BinaryNode node = q.poll();

			count++;

			if(node.left!=null) {
				q.add(node.left);
			}

			if(node.right != null) {
				q.add(node.right);
			}

		}

		return count;
	}
	
	private static int calculateTreeSizeRecursive(BinaryNode root) {
		if(root == null){
			return 0;
		}

		int left = calculateTreeSizeRecursive(root.left);
		int right = calculateTreeSizeRecursive(root.right);

		return left+right+1;
	}
	
}
