package binary_tress;

import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n\n Post Order traversal recursive: ");
		postOrderRecursive(root);
		System.out.println("\n\n Post Order traversal iterative: ");
		postOrderIterative(root);
	}
	
	private static void postOrderRecursive(BinaryNode root) {
		if(root==null) {
			return;
		}
		
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.value);
	}
	
	private static void postOrderIterative(BinaryNode root) {
		if(root==null) {
			return;
		}
		Stack<BinaryNode> stack = new Stack<>();
		while(true) {
			if(root!=null) {
				stack.push(root);
				root=root.left;
			} else {
				if(stack.isEmpty()) {
					return;
				} else {
					if(stack.peek().right==null) {
						root=stack.pop();
						System.out.print(root.value);
						if(root==stack.peek().right) {
							System.out.print(stack.pop().value);
						}
					}
					
				}
				if(stack.isEmpty()) {
					root=stack.peek().right;
				} else {
					root=null;
				}
			}
		}
			
			
			
	}

}
