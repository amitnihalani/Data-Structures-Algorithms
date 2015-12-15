package binary_tress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCA {
	
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("------------------------Original Tree--------------------------");
		LevelOrderTraversal.printLevelOrderTraversal(root);
		
		System.out.println("\n \nEnter the two values (on seperate lines) for which LCA is to be found: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int valueOne = Integer.parseInt(br.readLine());
		int valueTwo = Integer.parseInt(br.readLine());
		
//		BinaryNode lca = returnLCA(root, valueOne, valueTwo);
//		System.out.println(String.format("LCA of %d and %d is: %d", valueOne, valueTwo, lca.value));
		BinaryNode lca = LCA(root, root.right.left.left, root.right.left);
		System.out.println(String.format("LCA of %d and %d is: %d", root.right.left.left.value, root.right.left.value, lca.value));
	}
	
	private static BinaryNode returnLCA(BinaryNode root, int valueOne, int valueTwo){
		
		if(root == null) {
			return null;
		} 
		
		if(root.value == valueOne || root.value==valueTwo){
			return root;
		}
		
		BinaryNode left = returnLCA(root.left, valueOne, valueTwo);
		BinaryNode right = returnLCA(root.right, valueOne, valueTwo);
		
		if(left!=null && right!=null) {
			return root;
		} else {
			return (left!=null? left:right);
		}
		
	}
	
	private static BinaryNode LCA(BinaryNode root, BinaryNode node1, BinaryNode node2) {

		if(root == null) {
			return null;
		}

		if(root == node1 || root == node2) {
			return root;
		}


		BinaryNode left = LCA(root.left, node1, node2);
		BinaryNode right = LCA(root.right, node1, node2);

		if (left!=null && right!=null) {
			return root;
		} else if(left!=null){
			return left;
		} else {
			return right;
		}
	}
}


