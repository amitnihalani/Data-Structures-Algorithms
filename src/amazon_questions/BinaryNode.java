package amazon_questions;

import java.util.ArrayList;
import java.util.List;

public class BinaryNode {
	public int value;
	public BinaryNode left;
	public BinaryNode right;
	
	public BinaryNode(int val){
		this.value = val;
	}
	
	public int getValue(){
		return value;
	}
	
	public List<BinaryNode> getChildren(){
		List<BinaryNode> children = new ArrayList<BinaryNode>();
		children.add(this.left);
		children.add(this.right);
		
		return children;
	}
}
