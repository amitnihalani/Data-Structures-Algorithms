package binary_search_tress;

import binary_tress.BinaryNode;

public class BinarySearchTree {
	
	/**
	 * 						8
	 * 			3						10
	 * 	1				6						14
	 * 				4		7				13
	 * 
	 * 
	 */
	public static BinaryNode generateRandomBinarySearchTree(){
		BinaryNode root = new BinaryNode(8);
		root.left = new BinaryNode(3);
		root.right = new BinaryNode(10);
		
		root.left.left = new BinaryNode(1);
		root.left.right = new BinaryNode(6);
		
		root.left.right.left = new BinaryNode(4);
		root.left.right.right = new BinaryNode(7);
		
//		root.right.left = new BinaryNode(3);
		root.right.right = new BinaryNode(14);
		
		root.right.right.left = new BinaryNode(13);
		
		return root;
	}
	
	
	public static BinaryNode generateRandomBinaryTreeTwo(){
		BinaryNode root = new BinaryNode(8);
		root.left = new BinaryNode(3);
		root.right = new BinaryNode(10);
		
		root.left.left = new BinaryNode(1);
		root.left.right = new BinaryNode(6);
		
		root.left.right.left = new BinaryNode(4);
		root.left.right.right = new BinaryNode(7);
		
//		root.right.left = new BinaryNode(3);
		root.right.right = new BinaryNode(14);
		
		root.right.right.left = new BinaryNode(13);
		
		return root;
	}
	
	/**
	 * 						8
	 * 			3						10
	 * 	1				6						14
	 * 				4		7				13
	 * 									  15			
	 * 
	 * 
	 */
	public static BinaryNode generateIncorrectBinarySearchTree(){
		BinaryNode root = new BinaryNode(8);
		root.left = new BinaryNode(3);
		root.right = new BinaryNode(10);
		
		root.left.left = new BinaryNode(1);
		root.left.right = new BinaryNode(6);
		
		root.left.right.left = new BinaryNode(4);
		root.left.right.right = new BinaryNode(7);
		
//		root.right.left = new BinaryNode(3);
		root.right.right = new BinaryNode(14);
		
		root.right.right.left = new BinaryNode(13);
		root.right.right.left.left = new BinaryNode(15);
		
		return root;
	}
}
