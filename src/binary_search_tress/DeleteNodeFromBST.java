package binary_search_tress;

import binary_tress.BinaryNode;
import binary_tress.LevelOrderTraversal;

public class DeleteNodeFromBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinarySearchTree.generateRandomBinarySearchTree();
		System.out
				.println("------------------------Original Tree--------------------------");
		LevelOrderTraversal.printLevelOrderTraversal(root);

		System.out
				.println("\n\n------------------------After Deletion--------------------------");
		root = deleteNode(root, 10);
		LevelOrderTraversal.printLevelOrderTraversal(root);
	}

	private static BinaryNode deleteNode(BinaryNode root, int data) {

		if (root == null) {
			return null;
		} else if (root.value > data) {
			root.left = deleteNode(root.left, data);
		} else if (root.value < data) {
			root.right = deleteNode(root.right, data);
		} else {

			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left == null) {
				BinaryNode temp = root;
				root = root.right;
				temp = null;
			} else if (root.right == null) {
				BinaryNode temp = root;
				root = root.left;
				temp = null;
			} else {
				BinaryNode min = getMin(root.right);
				root.value = min.value;
				root.right = deleteNode(root.right, min.value);
			}

		}

		return root;

	}

	private static BinaryNode getMin(BinaryNode root) {
		BinaryNode minChild;
		if (root == null)
			return null;

		BinaryNode leftMin = getMin(root.left);
		BinaryNode rightMin = getMin(root.right);

		if (root.left == null && root.right == null) {
			minChild = root;
		} else if (leftMin == null) {
			minChild = rightMin;
		} else if (rightMin == null) {
			minChild = leftMin;
		} else {
			minChild = leftMin.value <= rightMin.value ? leftMin : rightMin;
		}

		return minChild.value <= root.value ? minChild : root;
	}

	private static BinaryNode getMax(BinaryNode root) {
		BinaryNode maxChild;
		if (root == null)
			return null;

		BinaryNode leftMax = getMax(root.left);
		BinaryNode rightMax = getMax(root.right);

		if (root.left == null && root.right == null) {
			maxChild = root;
		} else if (leftMax == null) {
			maxChild = rightMax;
		} else if (rightMax == null) {
			maxChild = leftMax;
		} else {
			maxChild = leftMax.value >= rightMax.value ? leftMax : rightMax;
		}

		return maxChild.value >= root.value ? maxChild : root;
	}
}
