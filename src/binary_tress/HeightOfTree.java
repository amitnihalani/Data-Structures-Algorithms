package binary_tress;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

	public static void main(String[] args) {
		
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("\nOriginal Tree\n");
		root.left.left.left = new BinaryNode(10);
		root.left.left.left.right = new BinaryNode(15);
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n \nHeight of tree  found using RECURSION is: " + heightOfTree(root));
		System.out.println("\n \nHeight of tree  found using LEVEL ORDER TRAVERSAL is: " + heightOfTreeUsingLevelOrder(root));
	}
	
//	private static int heightOfTree(BinaryNode root) {
//		
//		if(root==null) {
//			return 0;
//		}
//
//		int left = heightOfTree(root.left);
//		int right = heightOfTree(root.right);
//		int max = (left>right? left:right);
//		// height of left/right subtree + 1 for the node itself
//		return max+1;
//	}
	
	private static int heightOfTree(BinaryNode root) {
		if(root == null) {
			return 0;
		}
		
		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;

	}

	private static int heightOfTreeUsingLevelOrder(BinaryNode root) {
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		int level=1;
			// return if root is null
			if(root == null){
				return 0;
			}// else add root to the queue
			q.add(root);
			q.add(null);

			while(!q.isEmpty()) {
				BinaryNode node = q.poll();
				if(node!=null){
					if(node.right!=null) {
						q.add(node.right);
					}
					if(node.left!=null) {
						q.add(node.left);
					}
				} else {
					if(!q.isEmpty()){
						q.add(null);
						level++;
					}
				}
			}
		return level;
	}
}
