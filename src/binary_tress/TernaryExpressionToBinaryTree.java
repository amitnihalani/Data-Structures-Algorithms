package binary_tress;

import java.util.Stack;

public class TernaryExpressionToBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ternaryExpression = { 'a', '?', 'b', '?', 'c', ':', 'd', ':',
				'e' };
		
		BinaryNode root = convertToBT(ternaryExpression); 
		LevelOrderTraversal.printLevelOrderTraversal(root);
	}

	public static BinaryNode convertToBT(char[] values) {
		BinaryNode root = new BinaryNode(values[0]);
		BinaryNode n = root;
		Stack<BinaryNode> a = new Stack<BinaryNode>();
		for (int i = 1; i < values.length; i += 2) {
			if (values[i] == '?') {
				n.left = new BinaryNode(values[i + 1]);
				a.add(n);
				n = n.left;

			} else if (values[i] == ':') {
				n = a.pop();
				while (n.right != null) {
					n = a.pop();
				}
				n.right = new BinaryNode(values[i + 1]);
				a.add(n);
				n = n.right;
			}
		}
		return root;
	}
	
//	// if parent pointer present
//	public BinaryNode convertTtoBT (char[] values) {
//	    BinaryNode n = new BinaryNode (values[0]);
//
//	    for (int i = 1; i < values.length; i += 2) {
//	        if (values[i] == '?') {
//	            n.left = new BinaryNode (values[i + 1]);
//	            n = n.left;
//	        }
//	        else if (values[i] == ':') {
//	            n = n.parent;
//	            while (n.right != null && n.parent != null ) {
//	                n = n.parent;
//	            }                    
//	            n.right = new BinaryNode (values[i + 1]);
//	            n = n.right;
//	        }
//	    }
//	    return n;
//	}

}
