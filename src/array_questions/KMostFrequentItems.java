package array_questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javax.print.attribute.HashAttributeSet;

public class KMostFrequentItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 1, 2, 3, 5, 6, 7, 8, 9, 3, 3, 3, 4, 5, 1, 1,
				1, 4, 2, 1, 2, 1, 2, 1, 3, 4, 5, 7, 8, 8, 8, 8, 8, 9, 9, 9, 8,
				8, 8, 8, 8, 8, 8, 1 };
		Map<Integer, Integer> map = elementCountMap(arr);
		int k = 3;
		Heap minHeap = new Heap(k, 0);
//		PriorityQueue<WrapperElement> prQueue = new PriorityQueue<>(k,
//				new Comparator<WrapperElement>() {
//					@Override
//					public int compare(WrapperElement o1, WrapperElement o2) {
//						// TODO Auto-generated method stub
//						if (o1.count < o2.count) {
//							return 1;
//						} else if (o1.count == o2.count) {
//							return 0;
//						}
//						return -1;
//					}
//
//				});
		int i = 0;
		
		WrapperElement[] wrapperArray = new WrapperElement[arr.length];
		
		for (Integer key : map.keySet()) {
			wrapperArray[i++] =  new WrapperElement(key, map.get(key));
			//prQueue.add(new WrapperElement(key, map.get(key)));
		}

		Arrays.sort(wrapperArray);
		
		for(int j=0; j<wrapperArray.length; j++) {
			System.out.println("Value: " + wrapperArray[j].value + "  Count: " + wrapperArray[j].count);
		}
		
//		while (!prQueue.isEmpty()) {
//			WrapperElement w = prQueue.remove();
//			System.out.println("Value: " + w.value + "  Count: " + w.count);
//		}

	}

	public static Map<Integer, Integer> elementCountMap(int[] arr) {
		Map<Integer, Integer> elementMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (elementMap.containsKey(arr[i])) {
				int count = elementMap.get(arr[i]);
				elementMap.put(arr[i], count + 1);
			} else {
				elementMap.put(arr[i], 1);
			}
		}

		return elementMap;
	}

}
