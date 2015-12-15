package binary_search_tress;

import binary_tress.BinaryNode;
import binary_tress.BinaryTree;
import binary_tress.LevelOrderTraversal;

public class GenerateBSTFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		BinaryNode root = generateBST(arr, 0, arr.length - 1);

		LevelOrderTraversal.printLevelOrderTraversal(root);

		System.out.println("\n \n Is generated BST valid?: " + IsBST.isBST(root));

	}

	private static BinaryNode generateBST(int[] arr, int start, int end) {
		if (arr.length == 0 || end < start) {
			return null;
		}

		int mid = (start + end) / 2;

		BinaryNode n = new BinaryNode(arr[mid]);

		n.left = generateBST(arr, start, mid - 1);
		n.right = generateBST(arr, mid + 1, end);

		return n;
	}

}
