package binary_tress;

public class BinaryTree {

	public static BinaryNode generateRandomBinaryTree(){
		BinaryNode root = new BinaryNode(5);
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(8);
		
		root.left.left = new BinaryNode(5);
		root.left.right = new BinaryNode(1);
		
		root.right.left = new BinaryNode(3);
		root.right.right = new BinaryNode(9);
		
		return root;
	}
}
