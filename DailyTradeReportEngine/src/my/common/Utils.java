package my.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {

	public static Set<String> rankEntity(Map<String, Double> map) {

		List<Map.Entry<String, Double>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			@Override
			public int compare(Map.Entry<String, Double> double1, Map.Entry<String, Double> double2) {
				return (double2.getValue()).compareTo(double1.getValue()); // descending
																			// order
																			// sort
																			// by
																			// value
			}
		});
		Set<String> result = new LinkedHashSet<>();
		for (Map.Entry<String, Double> entry : list) {
			result.add(entry.getKey());
		}
		return result;
	}

}
