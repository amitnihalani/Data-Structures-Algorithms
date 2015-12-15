package binary_tress;

import java.math.BigInteger;
import java.util.Scanner;

public class PrintAllAncestors {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTreeTwo();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		//System.out.println("\n \n Sum of all the nodes in the tree is: " + printAncestors(root, 12));
		 
	}
	
	private static void printAncestors(BinaryNode root, int val) {
		if (root==null) {
			
		}
	}
}
