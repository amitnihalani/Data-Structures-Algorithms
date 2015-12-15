package binary_tress;

import java.util.Stack;

public class InOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		System.out.println("\n\n In Order traversal recursive: ");
		inOrderRecursive(root);
		System.out.println("\n\n In Order traversal iterative: ");
		inOrderIterative(root);
	}
	
	private static void inOrderRecursive(BinaryNode root) {
		if(root == null){
			return;
		}
		inOrderRecursive(root.left);
		System.out.print(root.value + " ");
		inOrderRecursive(root.right);
	}
	
	private static void inOrderIterative(BinaryNode root) {
		if(root == null) {
			return;
		}
		
		Stack<BinaryNode> stack = new Stack<>();
	
		
		while(true) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
				
			}
			
			if(stack.isEmpty() == true){
				break;
			}
			root = stack.pop();
			System.out.print(root.value + " ");
			
			root=root.right;
			
		}
	}

}
