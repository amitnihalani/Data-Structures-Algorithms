/**
 * 
 */
package binary_tress;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Amit
 *
 */
public class ZigZagTraversal {
	
	public static 
	void zigZagTraversal(BinaryNode root){
		Stack<BinaryNode> currentStack = new Stack<BinaryNode>();
		Stack<BinaryNode> nextStack = new Stack<BinaryNode>();
		int rightToLeft = 1;
		currentStack.add(root);
		
		while(!currentStack.isEmpty()){
			BinaryNode currentNode = currentStack.pop();
			System.out.print(currentNode.value + " ");
			
			if(rightToLeft==1){
				if(currentNode.left!=null){
					nextStack.add(currentNode.left);
				}
				if(currentNode.right!=null){
					nextStack.add(currentNode.right);
				}
				
			}else{
				if(currentNode.right!=null){
					nextStack.add(currentNode.right);
				}
				if(currentNode.left!=null){
					nextStack.add(currentNode.left);
				}
			}
			
			if(currentStack.isEmpty()){
				Stack<BinaryNode> temp = currentStack;
				currentStack = nextStack;
				nextStack = temp;
				rightToLeft = Math.abs(rightToLeft-1);
			}
			
		}
	}
	
	public static void main(String args[]){
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		zigZagTraversal(root);
	}

}
