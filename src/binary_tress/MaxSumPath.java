package binary_tress;

import java.util.ArrayList;
import java.util.List;


public class MaxSumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		
		
		System.out.println("\n \n" + getLargestRootToLeafSum(root));
	}

	private static int[] returnMaxSumPath(BinaryNode root, int[] path, int[] finalPath, int sum, int max, int len){
		if(root == null) {
			return finalPath;
		}
		sum=sum+root.value;
		path[len++]=(root.value);
		
		if(root.left==null && root.right==null){
			if(sum>max){
				max=sum;
				finalPath = path;
			}
		}
		
	returnMaxSumPath(root.left, path, finalPath, sum, max, len);
	 returnMaxSumPath(root.right, path, finalPath, sum, max, len);
		
		return finalPath;
	}
	


private static int getLargestRootToLeafSum(BinaryNode root) {
	 /*
    A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
    to the root node inclusively.
    A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

    Please implement this method to
    return the largest root-to-leaf sum in the tree.
   */
	if(root==null) {
		return 0;
	}

	
	List<BinaryNode> children = root.getChildren();
	if(children.size() > 0){
		ArrayList<Integer> sumOfChildren = new ArrayList<Integer>();
		for(BinaryNode child : children) {
		     sumOfChildren.add(getLargestRootToLeafSum(child));
		}	 
		int maxChild = getMax(sumOfChildren);
		return maxChild + root.getValue();
	} else {
		return root.getValue();
	}

}

private static int getMax(ArrayList<Integer> list) {
	int max = -999;

	for(int n : list){
		if(n>max){
			max = n;
		}
	}

	return max;
}
	
}
