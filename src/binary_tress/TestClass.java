package binary_tress;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTree.generateRandomBinaryTree();
		LevelOrderTraversal.printLevelOrderTraversal(root);
		List<BinaryNode> result = traverseTreeInWidth(root);
		System.out.println("\n\n"+ result);
	}

	public static List<BinaryNode> traverseTreeInWidth(BinaryNode root) {
        /*
          Please implement this method to
          traverse the tree in width and return a list of all passed nodes.

          The list should start with the root node, next
          it should contain all second-level nodes, then third-level nodes etc.

          The method shall work optimally with large trees.
         */
        List<BinaryNode> result = new ArrayList<BinaryNode>();
        result.add(root);
        for (int i = 0; i < result.size(); ++i){
        	for (BinaryNode child : result.get(i).getChildren()) {
        		if(child!=null){
        			result.add(child);
        		}
        		
        	}
                
        }
                
        return result;
}
}
