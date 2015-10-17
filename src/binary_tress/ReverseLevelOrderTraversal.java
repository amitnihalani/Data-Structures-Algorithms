package binary_tress;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		System.out.println("\nOriginal Tree\n");
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\nReversed Level Order: ");
		reverseLevelOrderTraversal(root);
	}

	private static void reverseLevelOrderTraversal(BinaryNode root) {
		Queue<BinaryNode> q = new LinkedList<BinaryNode>();
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		// return if root is null
		if(root == null){
			return;
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
				stack.push(node);
			} else {
				if(!q.isEmpty()){
					q.add(null);
				}
			}
		}

		while(!stack.isEmpty()) {
			BinaryNode n = stack.pop();
			System.out.print(n.value);
		}
	}
}
