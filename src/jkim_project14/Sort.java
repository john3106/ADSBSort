package jkim_project14;

import java.util.Arrays;

public class Sort {

	static int linearSearch(String[] arr, String word) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equalsIgnoreCase(word)) {
				return i;
			}
		}
		return -1;
	}

	static int binarySearch(String[] arr, int start, int end, String word) {
		if (end >= 1) {
			int middle = (start+end)/2;
			if (arr[middle].equalsIgnoreCase(word)) {
				return middle;
			}
			if ((arr[middle].compareToIgnoreCase(word)) > 0) {
				return binarySearch(arr, start, middle - 1, word);
			}

			return binarySearch(arr, middle + 1, end, word);

		}
		return -1;
	}
	
	static int jumpSearch(String[] arr, String s) {
		// Find the optimal block size
		int step = (int) Math.round(Math.sqrt(arr.length));
		int b = step;
		int a = 0;
		int n = arr.length;

		while (arr[Math.min(b,n)-1].compareTo(s) < 0) {
			a = b;
			b += step;
			if (a >= n) {
				return -1;
			}
		}
		while (arr[a].compareTo(s)<0) {
			a++;
			if (a == Math.min(b,n)) {
				return -1;
			}
		}
		if (arr[a].equals(s)) {
			return a;
		} else {
			return -1;
		}
	}

}
