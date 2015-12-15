package binary_search_tress;

import binary_tress.BinaryNode;
import binary_tress.BinaryTree;
import binary_tress.LevelOrderTraversal;

public class IsBST {
	static int prev = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinarySearchTree.generateRandomBinarySearchTree();
		System.out
				.println("------------------------Original Tree--------------------------");
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out
				.println("\n\n Is Binary Search tree valid? : " + isBST(root));
	}

	/**
	 * Logic is to do in order traversal and check if the order of traversal is
	 * sorted. That is, always previous node traversed<currentNode
	 * Keep previous as static and update it at each node
	 */
	public static boolean isBST(BinaryNode root) {
		if (root == null) {
			return true;
		}

		boolean leftBST = isBST(root.left);

		if (prev > root.value) {
			return false;
		}
		prev = root.value;

		boolean rightBST = isBST(root.right);

		if (leftBST && rightBST) {
			return true;
		}

		return false;
	}

}
