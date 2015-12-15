package binary_tress;

public class SumOfAllNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTreeTwo();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n \n Sum of all the nodes in the tree is: " + sumOfAllNodesInTree(root));
	}

	private static int sumOfAllNodesInTree(BinaryNode root){
		if (root == null) {
			return 0;
		}

		int leftSum  = sumOfAllNodesInTree(root.left);
		int rightSum = sumOfAllNodesInTree(root.right);

		return leftSum + root.value + rightSum;
	}
}
