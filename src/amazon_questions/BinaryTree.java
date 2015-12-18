package amazon_questions;

public class BinaryTree {

	public static BinaryNode generateRandomBinaryTree(){
		BinaryNode root = new BinaryNode(5);
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(8);
		
		root.left.left = new BinaryNode(5);
		root.left.right = new BinaryNode(1);
		
		root.right.left = new BinaryNode(3);
		root.right.right = new BinaryNode(9);
		
		root.right.left.left = new BinaryNode(1);
		
		return root;
	}
	
	public static BinaryNode generateRandomBinaryTreeTwo(){
		BinaryNode root = new BinaryNode(7);
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(8);
		
		root.left.left = new BinaryNode(10);
		root.left.right = new BinaryNode(12);
		
		root.right.left = new BinaryNode(3);
		root.right.right = new BinaryNode(4);
		
		root.right.left.left = new BinaryNode(12);
		
		return root;
	}
	
	public static BinaryNode generateRandomBinaryTreeThree(){
		BinaryNode root = new BinaryNode(10);
		root.left = new BinaryNode(12);
		root.right = new BinaryNode(18);
		
		root.left.left = new BinaryNode(15);
		root.left.right = new BinaryNode(11);
		
		root.right.left = new BinaryNode(13);
		root.right.right = new BinaryNode(19);
		
		//root.right.left.left = new BinaryNode(12);
		
		return root;
	}
}
