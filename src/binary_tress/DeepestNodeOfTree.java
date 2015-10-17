package binary_tress;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeOfTree {

	public static void main(String[] args) {
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("\nOriginal Tree\n");
		root.left.left.left = new BinaryNode(10);
		root.left.left.left.right = new BinaryNode(15);
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n \nDeepest node in the tree: " + deepestNodeUsingLevelOrder(root).value);
	}
	
	private static BinaryNode deepestNodeUsingLevelOrder(BinaryNode root) {
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		BinaryNode deepestNode = null;
			// return if root is null
			if(root == null){
				return null;
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
					deepestNode = node;
				} else {
					if(!q.isEmpty()){
						q.add(null);
					}
				}
			}
		return deepestNode;
	}

}
