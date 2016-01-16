package amazon_questions;

import linked_list.LinkedList;

public class RoundRobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] jobExecution = { 5, 3, 8, 6 };
		int quant = 3;
		
		System.out.println("Avg Wait time: " + roundRobin(jobExecution, quant));
	}
	
	private static double roundRobin(int[] execution, int quant) {
		LinkedList list = new LinkedList();
		
		int waitTime = 0, finishedProcesses = 0, totalProcesses = execution.length;
		int currentIndex = 0, q;
		
		while(finishedProcesses < execution.length-1) {
			q = quant;
			while(q>0) {
				
				if(execution[currentIndex] <= 0) {
				// not expected
					break;
				}
				
				q--;
				execution[currentIndex]--;
				waitTime += (totalProcesses - finishedProcesses - 1);
				
				if(execution[currentIndex] <= 0) {
					finishedProcesses++;
					break;
				}
			}
			currentIndex = (currentIndex+1) % execution.length;
		}
		
		return (double)waitTime/totalProcesses;
		
	}

}
