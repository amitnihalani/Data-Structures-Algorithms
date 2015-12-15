package string_manipulations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SegmentationProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<String>();
		set.add("there");
		set.add("example");
		set.add("are");
		set.add("four");
		set.add("sample");
		set.add("words");

		System.out.println(segmentString("therearefourwords", set));
		System.out.println(SegmentStringDynamic("therearefourwords", set));
	}

	// This is brute force solution. Runs an O(2^N)
	private static String segmentString(String input, Set<String> dict) {
		if (dict.contains(input))
			return input;
		int len = input.length();
		for (int i = 1; i < len; i++) {
			String prefix = input.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = input.substring(i, len);
				String segSuffix = segmentString(suffix, dict);
				if (segSuffix != null) {
					return prefix + " " + segSuffix;
				}
			}
		}
		return null;
	}

	static Map<String, String> memoized = new HashMap<String, String>();

	static String SegmentStringDynamic(String input, Set<String> dict) {
		if (dict.contains(input))
			return input;
		if (memoized.containsKey(input)) {
			return memoized.get(input);
		}
		int len = input.length();
		for (int i = 1; i < len; i++) {
			String prefix = input.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = input.substring(i, len);
				String segSuffix = SegmentStringDynamic(suffix, dict);
				if (segSuffix != null) {
					memoized.put(input, prefix + " " + segSuffix);
					return prefix + " " + segSuffix;
				}
			}
		}
			memoized.put(input, null);
			return null;
		}
	
}
