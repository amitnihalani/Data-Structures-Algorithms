package binary_tress;

import java.util.Stack;

public class PreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n\n In Order traversal recursive: ");
		preOrderRecursive(root);
		System.out.println("\n\n In Order traversal iterative: ");
		preOrderIterative(root);
	}
	
	private static void preOrderRecursive(BinaryNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.value);
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}
	
	private static void preOrderIterative(BinaryNode root) {
		if(root==null) {
			return;
		}
		Stack<BinaryNode> stack = new Stack<>();
		while(true) {
			
			
			while(root!=null) {
				System.out.print(root.value);
				stack.push(root);
				root=root.left;
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			root = stack.pop();			
				root = root.right;
		}
	}

}
