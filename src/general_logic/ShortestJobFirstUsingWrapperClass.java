package general_logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestJobFirstUsingWrapperClass {

	static PriorityQueue<Job> pq = new PriorityQueue<Job>(new Comparator<Job>() {
		@Override
		public int compare(Job this1, Job j) {
			// TODO Auto-generated method stub
			if (this1.executionTime > j.executionTime) {
				return 1;
			} else if (this1.executionTime < j.executionTime) {
				return -1;
			} else {
				// if execution time is same, priority to earlier request
				if (this1.requestTime < j.requestTime) {
					return 1;
				} else if (this1.requestTime > j.requestTime) {
					return -1;
				}
			}
			return 0;
		}
	});

	private static class Job {
		int executionTime;
		int requestTime;
		int waitTime;

		Job(int eTime, int rTime) {
			executionTime = eTime;
			requestTime = rTime;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// array with job execution time 7414
		int[] jobExecution = { 3,1 ,3, 2, 4};
		// 0245,
		int[] request = { 8, 2, 1, 3, 4};

		List<Job> jobList = new ArrayList<Job>();

		for (int i = 0; i < request.length; i++) {
			jobList.add(new Job(jobExecution[i], request[i]));
		}

//		for (Job j : jobList) {
//			if (!pq.contains(j)) {
//				pq.add(j);
//			}
//		}
		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll().executionTime);
//		}
//		
		
		System.out.println(getAvgWaitTimeSJF(jobList));

	}

	private static double getAvgWaitTimeSJF(List<Job> jobList) {
		int currentTime = 0, waitTime = 0, jobs = jobList
				.size();

		while (true) {
			Job j = getShortestJob(jobList, currentTime);
			if (j == null) {
				currentTime++;
				continue;
			}
			j.waitTime = currentTime - j.requestTime;
			System.out.println("Wait time of process: " + j.waitTime);
			waitTime = waitTime + j.waitTime;
			currentTime += j.executionTime;
			jobList.remove(j);
			
			if(jobList.isEmpty()) break;
		}
		
		
		return (double) waitTime / jobs;
	}

	private static Job getShortestJob(List<Job> jobList, float currentTime) {

		for (Job j : jobList) {
			if (!pq.contains(j) && (float) j.requestTime <= currentTime) {
				pq.add(j);
			}
		}
		return pq.poll();
	}

}
