package jkim_project14;

import java.util.Arrays;

public class Sort {

	static int linearSearch(Object[] arr, String word) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(word)) {
				return i;
			}
		}
		return -1;
	}

	static int binarySearch(Object[] arr, int start, int end, String word) {
		Arrays.sort(arr);
		if (end >= 1) {
			int middle = arr.length / 2;
			if (arr[middle].equals(word)) {
				return middle;
			}
			if (arr[middle].compareTo(word) < 0) {
				return binarySearch(arr, 0, middle - 1, word);
			}

			return binarySearch(arr, middle + 1, end, word);

		}
		return -1;
	}

}
