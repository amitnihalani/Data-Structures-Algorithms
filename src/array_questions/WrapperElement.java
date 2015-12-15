package array_questions;

import java.util.Comparator;

public class WrapperElement implements Comparable<WrapperElement>{

	public int value;
	public int count;

	public WrapperElement(int v, int c) {
		value = v;
		count = c;
	}

//	@Override
//	public int compare(WrapperElement o1, WrapperElement o2) {
//		// TODO Auto-generated method stub
//		if (o1.count < o2.count) {
//			return 1;
//		} else if (o1.count == o2.count) {
//			return 0;
//		}
//		return -1;
//	}

	@Override
	public int compareTo(WrapperElement o2) {
		// TODO Auto-generated method stub
		if (this.count < o2.count) {
			return -1;
		} else if (this.count == o2.count) {
			return 0;
		}
		return 1;
	}
	
	
	
}
