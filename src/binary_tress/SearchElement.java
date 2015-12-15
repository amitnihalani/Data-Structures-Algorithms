package binary_tress;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n \n Enter the element to be searched: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
				
		if(searchElement(root, x) && searchElementIterative(root, x)){
			System.out.println(String.format("\n Found the element %d in tree using Recursion and Iterative approach", x));
		} else {
			System.out.println(String.format("\n Cound NOT find the element %d in tree", x));
		}
	}
	
	//return true if element is found in tree  - RECURSIVE Solution
//	private static boolean searchElement(BinaryNode root, int val) {
//		if(root==null){
//			return false;
//		}
//		
//		boolean left = searchElement(root.left, val);
//		boolean right = searchElement(root.right, val);
//		
//		if(root.value == val){
//			return true;
//		}
//		
//		if(left||right){
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	//return true if element is found in tree  - RECURSIVE Solution
	private static boolean searchElement(BinaryNode root, int val) {
		if(root == null) {
			return false;
		}

		if(root.value == val) {
			return true;
		}

		return (searchElement(root.left, val) ||  searchElement(root.right, val));

	}
	
	//Return true if element is found - ITERATIVE solution
	private static boolean searchElementIterative(BinaryNode root, int val) {
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		q.add(root);

		while(!q.isEmpty()) {
			BinaryNode node = q.poll();

			if(node.value == val) {
				return true;
			}

			if(node.left!=null) {
				q.add(node.left);
			}

			if(node.right != null) {
				q.add(node.right);
			}

		}
		return false;
	}

}
