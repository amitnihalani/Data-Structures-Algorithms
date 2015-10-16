package trees;

public class InsertAndDeleteTrinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrinaryTreeNode root = new TrinaryTreeNode(8);
		root = insert(root, new TrinaryTreeNode(5));
		root = insert(root, new TrinaryTreeNode(9));
		root = insert(root, new TrinaryTreeNode(8));
		root = insert(root, new TrinaryTreeNode(8));
		root = insert(root, new TrinaryTreeNode(3));
		root = insert(root, new TrinaryTreeNode(2));
		root = insert(root, new TrinaryTreeNode(7));
		root = insert(root, new TrinaryTreeNode(11));
		
		TrinaryTreeNode.printLevelOrder(root);
		
		root = delete(root, 5);
		
		TrinaryTreeNode.printLevelOrder(root);
	}
	
	private static TrinaryTreeNode insert(TrinaryTreeNode root, TrinaryTreeNode nodeToInsert){
		if(root == null || nodeToInsert == null){
			return root;
		}
		
		if(nodeToInsert.value == root.value){
			nodeToInsert.middle = root.middle;
			root.middle = nodeToInsert;
		} else if(nodeToInsert.value > root.value){
			if(root.right == null){
				root.right = nodeToInsert;
			} else {
				insert(root.right, nodeToInsert);
			}
			
		} else {
			if(root.left == null){
				root.left = nodeToInsert;
			} else {
				insert(root.left, nodeToInsert);
			}
		}
		return root;
	}
	
	private static TrinaryTreeNode delete(TrinaryTreeNode root, int value){
		if(root == null){
			return root;
		}
		
		if(value == root.value){
			if (root.middle != null) {
				root.middle = root.middle.middle;
			} else if(root.left != null) {
				insert(root.left, root.right);	
				root = root.left;
			} else if(root.right != null) {
				root = root.right;
			}
			
		} else if(value < root.value) {
			root.left = delete(root.left, value);
		} else {
			root.right = delete(root.right, value);
		}	
		return root;
	}

}
