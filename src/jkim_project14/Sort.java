package jkim_project14;

// https://docs.google.com/document/d/1FGWa1GQQVovlErmmdl75gi1JWbKwbETIMaod9ZKUiXc/edit

import java.util.Arrays;

public class Sort {

	static int linearSearch(String[] arr, String word) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(word)) {
				return i;
			}
		}
		return -1;
	}

	static int binarySearch(String[] arr, int start, int end, String word) {
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

//	static

}
