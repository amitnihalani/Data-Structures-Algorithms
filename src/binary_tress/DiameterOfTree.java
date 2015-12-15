package binary_tress;

public class DiameterOfTree {

	static int diameter = 0;
	
	public static void main(String[] args) {
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("\n Tree:");
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n The diameter of the tree is: " + findTreeDiameter(root, 0));
	}

	private static int findTreeDiameter(BinaryNode root, int diameter) {
		if (root == null) {
			return 0;
		}
		
		int leftMaxDepth = findTreeDiameter(root.left, diameter);
		int rightMaxDepth = findTreeDiameter(root.right, diameter);

		if(leftMaxDepth+rightMaxDepth > diameter) {
			diameter = leftMaxDepth + rightMaxDepth;
		}
		
		int max = Math.max(leftMaxDepth, rightMaxDepth);
		return max+1;
		
	}
	

}
