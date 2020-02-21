package jkim_project14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Project Description: https://docs.google.com/document/d/1FGWa1GQQVovlErmmdl75gi1JWbKwbETIMaod9ZKUiXc/edit
// Role assignments: https://docs.google.com/document/d/14w5kx63BC7bXkn66zRQG84cMu7xV_xrHv-03AYLTxRM/edit

public class Sort {

	static int linearSearch(ArrayList<String> arr, String word) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equalsIgnoreCase(word)) {
				return i;
			}
		}
		return -1;
	}

	static int binarySearch(ArrayList<String> arrList, int start, int end, String word) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (arrList.get(middle).equalsIgnoreCase(word)) {
				return middle;
			}
			if ((arrList.get(middle).compareToIgnoreCase(word)) > 0) {
				return binarySearch(arrList, start, middle - 1, word);
			}

			return binarySearch(arrList, middle + 1, end, word);

		}
		return -1;
	}

	static int jumpSearch(String[] arr, String s) {
		// Find the optimal block size
		int step = (int) Math.round(Math.sqrt(arr.length));
		int b = step;
		int a = 0;
		int n = arr.length;

		while (arr[Math.min(b, n) - 1].compareToIgnoreCase(s) < 0) {
			a = b;
			b += step;
			if (a >= n) {
				return -1;
			}
		}
		while (arr[a].compareToIgnoreCase(s) < 0) {
			a++;
			if (a == Math.min(b, n)) {
				return -1;
			}
		}
		if (arr[a].equalsIgnoreCase(s)) {
			return a;
		} else {
			return -1;
		}
	}

	static ArrayList<String> bubbleSort(ArrayList<String> arr, String k) {
		int count = 0;
		int order = 0;
		if (k.equalsIgnoreCase("ascending")) {
			order = 1;
		} else if (k.equalsIgnoreCase("descending")) {
			order = -1;
		}

		for (int i = 0; i < arr.size() - 1; i++) {
			if (order * (arr.get(i).compareToIgnoreCase(arr.get(i + 1))) > 0) {
				String replace = arr.get(i);
				arr.set(i, arr.get(i + 1));
				arr.set(i + 1, replace);
				count++;
			}
		}
		if (count > 0) {
			bubbleSort(arr, k);
		}
		return arr;
	}

	
	static void mergeSort(ArrayList<String> arr, int n, String k) {
		if (n < 2) {
			return;
		}
		int middle = n / 2;
		ArrayList<String> left = new ArrayList<String> (middle);
		ArrayList<String> right = new ArrayList<String> (n-middle);
		for (int i = 0; i < middle; i++) {
			left.add(arr.get(i));
		}
		for (int i = middle; i < n; i++) {
			right.add(i-middle, arr.get(i));
		}
		mergeSort(left, middle, k);
		mergeSort(right, n-middle, k);
		merger(arr, left, right, middle, n-middle, k);
	}

	static void merger(ArrayList<String> arr, ArrayList<String> l, ArrayList<String> r, int left, int right, String order) {
		int i = 0;
		int j = 0;
		int k = 0;
		int multiplier = 0;
		if (order.equalsIgnoreCase("descending")) {
			multiplier = -1;
		}
		else {
			multiplier = 1;
		}
		while (i < left && j < right) {
			if (multiplier*(l.get(i).compareToIgnoreCase(r.get(j))) <= 0) {
					arr.set(k, l.get(i));
					i++;
			}
			else {
				arr.set(k, r.get(j));
				j++;
			}
			k++;
		}
	
		while (i < left) {
			arr.set(k, l.get(i));
			i++;
			k++;
		}
	
		while (j < right) {
			arr.set(k, r.get(j));
			j++;
			k++;
		}
	}
	
	
	static ArrayList<String> insertionSort(ArrayList<String> arr, String k) {
		return arr;
		
	}
	


	// arr is the input and k is the number of buckets to create
	// static String[] buckSort(String[] arr, int k) {
	// ArrayList<ArrayList<String>> buckets = new ArrayList<ArrayList<String>>();
	// // buck
	// for (int i = 0; i < arr.length; i++) {
	// // buckets.get(Math.floor(k * arr[i])).add(arr[i]);
	// }
	// return new String[] {};
	// }

	// ArrayList<String>

	// quicksort returns a new sorted ArrayList
	static ArrayList<String> quicksort(ArrayList<String> A, int lo, int hi) {
		ArrayList<String> l = new ArrayList<String>(A);
		quicksort_internal(l, lo, hi);
		return l;
	}

	// quicksort_internal does an in-place sort of the provided ArrayList A
	private static void quicksort_internal(ArrayList<String> A, int lo, int hi) {
		if (lo < hi) {
			int p = partitionIndex(A, lo, hi);
			quicksort_internal(A, lo, p - 1);
			quicksort_internal(A, p + 1, hi);
		}
	}

	private static int partitionIndex(ArrayList<String> a, int lo, int hi) {
		String pivot = a.get(hi);
		int i = (lo - 1);
		for (int j = lo; j < hi - 1; j++) {
			if (a.get(j).compareToIgnoreCase(pivot) < 0) {
				i++;
				Collections.swap(a, i, j);
			}
		}
		Collections.swap(a, i + 1, hi);
		return (i + 1);
	}

	// algorithm quicksort(A, lo, hi) is
	// if lo < hi then
	// p := partition(A, lo, hi)
	// quicksort(A, lo, p - 1)
	// quicksort(A, p + 1, hi)
	//
	// algorithm partition(A, lo, hi) is
	// pivot := A[hi]
	// i := lo
	// for j := lo to hi do
	// if A[j] < pivot then
	// swap A[i] with A[j]
	// i := i + 1
	// swap A[i] with A[hi]
	// return i

}
