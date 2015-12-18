package amazon_questions;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void printLevelOrderTraversal(BinaryNode root) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		if (root == null) {
			System.out.println("The tree is Empty");
		} else {
			queue.add(root);
			queue.add(null);
		}

		while (!queue.isEmpty()) {
			BinaryNode n = queue.peek();
			queue.remove();

			if (n == null && !queue.isEmpty()) {
				System.out.println("\n");
				queue.add(null);
			} else {
				if (n != null) {
					System.out.print(" " + n.value);
					if (n.left != null) {
						queue.add(n.left);
					}

					if (n.right != null) {
						queue.add(n.right);
					}
				}

			}

		}

	}

	public static void main(String args[]) {
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		printLevelOrderTraversal(root);
	}

}
