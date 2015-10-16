package trees;

import java.util.Stack;

public class TrinaryTreeNode {
	int value;
	TrinaryTreeNode left;
	TrinaryTreeNode right;
	TrinaryTreeNode middle;
	
	public TrinaryTreeNode(int val){
		this.value = val;
	}
	
	public static void printLevelOrder(TrinaryTreeNode root){
		int rightToLeft = 1;
		Stack<TrinaryTreeNode> nextLevel = new Stack<TrinaryTreeNode>();
		Stack<TrinaryTreeNode> currentLevel = new Stack<TrinaryTreeNode>();
		
		currentLevel.push(root);
		while(!currentLevel.isEmpty()){
			TrinaryTreeNode currentNode = currentLevel.pop();
			System.out.print(currentNode.value + " ");
			
			if(rightToLeft == 1) {
				if(currentNode.left != null){
					nextLevel.push(currentNode.left);
				}
				if(currentNode.middle != null){
					nextLevel.push(currentNode.middle);
				}
				if(currentNode.right != null){
					nextLevel.push(currentNode.right);
				}
			} else {
				if(currentNode.right != null){
					nextLevel.push(currentNode.right);
				}
				if(currentNode.middle != null){
					nextLevel.push(currentNode.middle);
				}
				if(currentNode.left != null){
					nextLevel.push(currentNode.left);
				}
			}
			
			if(currentLevel.isEmpty()){
				System.out.print("\n");
				rightToLeft = Math.abs(rightToLeft - 1);
				Stack<TrinaryTreeNode> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
		
	}
}
