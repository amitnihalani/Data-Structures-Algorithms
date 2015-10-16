package binary_tress;

public class MaxHeightOfTree {
	
	public static void main(String arg[]) {
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("---------------------Original Tree----------------------");
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n \n");
		System.out.println("Max Height of Tree: "+returnMaxHeight(root, 0));
	}
	
	private static int returnMaxHeight(BinaryNode root, int height){
		// return len-1 when null, since the total no. of edges = no. of nodes -1. 
		if(root == null){
			return height-1;
		}
		
		height++;
		// Calculate height for left and right subtree and return the max
		int leftHeight = returnMaxHeight(root.left, height);
		int rightHeight = returnMaxHeight(root.right, height);
		
		return (leftHeight>rightHeight? leftHeight:rightHeight);
	}

}
