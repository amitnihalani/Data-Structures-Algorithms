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
		
		BinaryNode lca = returnLCA(root, valueOne, valueTwo);
		System.out.println(String.format("LCA of %d and %d is: %d", valueOne, valueTwo, lca.value));
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
}


