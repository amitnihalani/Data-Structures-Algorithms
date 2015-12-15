package graphs;

import java.util.HashSet;
import java.util.Set;

public class Node {
	int value;
	Set<Node> neighbours;
	
	public Node(int v) {
		this.value = v;
		neighbours = new HashSet<>();
	}

	public void addNeighbour(int value) {
		neighbours.add(new Node(value));
	}

	public void addNeighbour(Node n) {
		neighbours.add(n);
	}
}
