package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijikstrasShortestPath {
	
	static int[] distance;
	static int[] parents;
	
	public static void main (String args[]) {
		GraphGenerator graph = new GraphGenerator();
		dijikstra(graph, graph.nodes.get(0), graph.weights);
		
		System.out.println("Source: " + graph.nodes.get(0).value);
		System.out.println("Distance Matrix: " + Arrays.toString(distance));
		System.out.println("Parent Matrix: " + Arrays.toString(parents));
	}

	public static void initialize(GraphGenerator graph, Node source) {
		distance = new int[graph.nodes.values().size()];
		parents = new int[graph.nodes.values().size()];
		
		for(Node n : graph.nodes.values()) {
			distance[n.value] = Integer.MAX_VALUE;
			parents[n.value] = -1;
		}
		
		distance[source.value] = 0;
	}
	
	public static void relax(Node u, Node v, int[][] weights) {
		if(distance[v.value] > distance[u.value]+weights[u.value][v.value]) {
			distance[v.value] = distance[u.value]+weights[u.value][v.value];
			parents[v.value] = u.value;
		}
	}
	
	public static void dijikstra(GraphGenerator graph, Node source, int[][] weights) {
		
		initialize(graph, source);
		
		Set<Node> finishedVertices = new HashSet<>();
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(graph.nodes.values().size(), new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(distance[o1.value] > distance[o2.value]) {
					return 1;
				} else if(distance[o1.value] == distance[o2.value]) {
					return 0;
				}
				return -1;
			}
		});
		
		for(Node n: graph.nodes.values()) {
			priorityQueue.add(n);
		}
		
		while(!priorityQueue.isEmpty()) {
			Node u = priorityQueue.remove();
			finishedVertices.add(u);
			
			for(Node v: u.neighbours) {
				relax(u, v, weights);
			}
		}
	}

}
