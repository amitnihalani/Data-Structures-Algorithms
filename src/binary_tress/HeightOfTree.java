package binary_tress;

public class HeightOfTree {

	public static void main(String[] args) {
		
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("\nOriginal Tree\n");
		root.left.left.left = new BinaryNode(10);
		root.left.left.left.right = new BinaryNode(15);
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n \nHeight of tree is: " + heightOfTree(root));
	}
	
	private static int heightOfTree(BinaryNode root) {
		
		if(root==null) {
			return 0;
		}

		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		int max = (left>right? left:right);
		// height of left/right subtree + 1 for the node itself
		return max+1;
	}

}
