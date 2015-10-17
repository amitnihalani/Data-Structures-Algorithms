package binary_tress;

import java.util.ArrayList;

public class PrintRootToLeafPaths {

	public static void main(String[] args) {
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);

		printRootToLeafPaths(root, new int[10], 0);
	}

	private static void printRootToLeafPaths(BinaryNode root, int[] path,
			int len) {
		if (root == null) {
			return;
		}
		path[len++] = root.value;
		if (root.left == null && root.right == null) {
			printPath(path, len);
		}
			printRootToLeafPaths(root.left, path, len);
			printRootToLeafPaths(root.right, path, len);

		

	}

	private static void printPath(int[] arr, int len) {
		System.out.println();
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
