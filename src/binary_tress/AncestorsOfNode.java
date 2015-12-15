package binary_tress;

public class AncestorsOfNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		BinaryNode n = root.right.left.left;
		System.out.println("\n Ancestors of " + n.value + " are: " );
		isAncestor(root, n);
	}

	private static boolean isAncestor(BinaryNode root, BinaryNode node) {
		if (root == null) {
			return false;
		}

		boolean left = isAncestor(root.left, node);
		boolean right = isAncestor(root.right, node);

		if (left || right || root == node) {
			System.out.print(root.value + " ");
			return true;
		}
		return false;
	}

}
