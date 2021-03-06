package amazon_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ShortestJobFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// array with job execution time 7414
		int[] jobExecution = { 3, 1, 3, 2, 4 };
		// 0245,
		int[] request = { 8, 2, 1, 3, 4 };

		List<Integer> jobExec = arrayToList(jobExecution);
		List<Integer> requestList = arrayToList(request);

		System.out.println(getAvgWaitingTime(jobExec, requestList));
		
		jobExec = arrayToList(jobExecution);
		requestList = arrayToList(request);
		//System.out.println(getAvgWaitTime(jobExec, requestList));

	}

	private static List<Integer> arrayToList(int[] a) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		return list;
	}

	private static double getAvgWaitingTime(List<Integer> exec,
			List<Integer> request) {
		int waitTime = 0, currentTime = 0, size = exec.size();
		double avgWaitTime = 0.0;

		while (true) {
			if (exec.size() == 0) {
				break;
			}
			int i = returnValidShortestJob(exec, request, currentTime);

			if (i == -1) {
				currentTime++;
				continue;
			}

			waitTime += currentTime - request.get(i);
			// execute the full job and update current time
			currentTime = currentTime + exec.get(i);
			// as soon as job is done, remove the job from both lists using its
			// index i
			exec.remove(i);
			request.remove(i);

		}
		avgWaitTime = (double) waitTime / size;

		return avgWaitTime;
	}

	/**
	 * Returns index of shortest valid job from list
	 * 
	 * @param jobExecution
	 * @param requestTime
	 * @param currentTime
	 * @return
	 */
	private static int returnValidShortestJob(List<Integer> jobExecution,
			List<Integer> requestTime, int currentTime) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int i = 0; i < jobExecution.size(); i++) {
			if (jobExecution.get(i) < min && requestTime.get(i) <= currentTime) {
				minIndex = i;
				min = jobExecution.get(i);
			}
		}
		return minIndex;
	}

	// ALTERNATE SOlution
//	private static double getAvgWaitTime(List<Integer> exec, List<Integer> arr) {
//		int currentTime = 0, processCount = exec.size();
//		int currentProcessIndex;
//		double waitTime = 0.0;
//		while (exec.isEmpty() != true) {
//			currentProcessIndex = getSJ(exec, arr, currentTime);
//			if(currentProcessIndex == -1) {
//				currentTime++;
//				continue;
//			} else {
//				waitTime += currentTime - arr.get(currentProcessIndex);
//				 currentTime += exec.get(currentProcessIndex);
//				 exec.remove(currentProcessIndex);
//				 arr.remove(currentProcessIndex);
//			}
//			 
//		}
//		return (double) waitTime / processCount;
//	}
//
//	private static int getSJ(List<Integer> ex, List<Integer> ar, int currentTime) {
//		int minJobIndex = -1, min = Integer.MAX_VALUE;
//		for (int i = 0; i < ex.size(); i++) {
//			if (ex.get(i) < min && ar.get(i) <= currentTime) {
//				minJobIndex = i;
//				min = ex.get(minJobIndex);
//			}
//		}
//		return minJobIndex;
//	}

}
