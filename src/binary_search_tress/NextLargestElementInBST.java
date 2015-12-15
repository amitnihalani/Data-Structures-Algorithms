package binary_search_tress;

import binary_tress.BinaryNode;

public class NextLargestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Find next higher key in Binary Search Tree with parent pointer given
//	public static BinaryNode findNextHigherNodeInBST(BinaryNode node){
//
//	     /* Empty Tree */
//	     if (node == null)
//	        return null;
//
//	     /* If the given node has right child  */
//	     if (node.right != null)
//	        return findLeftMostNode(node.right);
//
//	     /* When the given node has no right child  */
//	     /* Go up till node is the first left child - return node's parent */
//	     BinaryNode parent = node.parent();
//	     while (parent != null  &&  node == parent.right()){
//	        node = parent;
//	        parent = parent.parent();
//	     }
//	        // Intuition: as we traverse left up the tree we traverse smaller values
//	        // The first node on the right is the next larger number
//	     return parent;
//	 }
//
//	 public static BinaryNode findLeftMostNode(BinaryNode node){
//
//	      if(node == null)
//	           return null;
//
//	      /* Go to the leftmost leaf node */
//	      while(node.left != null)
//	           node = node.left;
//
//	      /* Return the leftmost node */
//	      return node;
//	 }
}
