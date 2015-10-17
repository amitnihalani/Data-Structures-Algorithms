package binary_tress;

public class StructurallySimilarTrees {

	public static void main(String[] args) {
		BinaryNode root1 = BinaryTree.generateRandomBinaryTree();
		BinaryNode root2 = BinaryTree.generateRandomBinaryTreeTwo();
		System.out.println("\n Tree1 :");
		LevelOrderTraversal.printLevelOrderTraversal(root1);
		System.out.println("\n Tree2 :");
		LevelOrderTraversal.printLevelOrderTraversal(root2);

		if (checkStructurallyIdenticalTrees(root1, root2)) {
			System.out.println("\n \nBoth trees are structurally identical");
		} else {
			System.out
					.println("\n \nBoth trees are NOT structurally identical");
		}

	}

	// Return true if both trees are structurally identical
	private static boolean checkStructurallyIdenticalTrees(BinaryNode root1,
			BinaryNode root2) {
		if ((root1 == null && root2 == null)) {
			return true;
		}

		if ((root1.left == null && root2.left != null) || (root1.left != null && root2.left == null)) {
			return false;
		}

		if ((root1.right == null && root2.right != null) || (root1.right != null && root2.right == null)) {
			return false;
		}

		boolean leftSimilar = checkStructurallyIdenticalTrees(root1.left,
				root2.left);
		boolean rightSimilar = checkStructurallyIdenticalTrees(root1.right,
				root2.right);

		if ((leftSimilar && rightSimilar)) {
			return true;
		}

		return false;
	}

}
