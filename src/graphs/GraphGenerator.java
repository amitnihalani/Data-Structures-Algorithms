package graphs;

import java.util.HashMap;
import java.util.Map;

public class GraphGenerator {
	
	Map<Integer, Node> nodes = new HashMap<>();
	
	int[][] weights = new int[5][5];
	
	public GraphGenerator() {
		generateGraph();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				weights[i][j] = -1;
			}
		}
		
		weights[0][1] = 10;
		weights[0][4] = 5;
		
		weights[1][2] = 1;
		weights[1][4] = 2;
		
		weights[2][3] = 4;
		
		weights[4][1] = 3;
		weights[4][2] = 9;
		weights[4][3] = 2;
		
		weights[3][2] = 6;
		weights[3][0] = 7;
		
		
	}
	

	public void generateGraph() {
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		zero.addNeighbour(one);
		zero.addNeighbour(four);
	
		one.addNeighbour(four);
		one.addNeighbour(two);
		
		two.addNeighbour(three);
		
		three.addNeighbour(two);
		three.addNeighbour(zero);
		
		four.addNeighbour(one);
		four.addNeighbour(two);
		four.addNeighbour(three);
		
		nodes.put(0, zero);
		nodes.put(1, one);
		nodes.put(2, two);
		nodes.put(3, three);
		nodes.put(4, four);
		
	}
	
	
}
