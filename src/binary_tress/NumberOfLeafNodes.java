package binary_tress;

public class NumberOfLeafNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("\nOriginal Tree\n");
		root.left.left.left = new BinaryNode(89);
		root.left.left.right = new BinaryNode(90);
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("Number of Leaf Nodes: " + numberOfLeafNodes(root));
	}
	
	private static int numberOfLeafNodes(BinaryNode root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left==null && root.right==null) {
			return 1;
		}

		return numberOfLeafNodes(root.left) + numberOfLeafNodes(root.right);

	}

}
