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

	static ArrayList<String> mergeSort(ArrayList<String> arr, int start, int end, String k) {
		if (end > start) {
			int middle = (start + end) / 2;
			mergeSort(arr, start, middle, k);
			mergeSort(arr, middle + 1, end, k);
			merger(arr, start, middle, end);
		}

		return arr;
	}

	static void merger(ArrayList<String> arr, int start, int middle, int end) {
		ArrayList<String> list1 = new ArrayList<String>(arr.subList(start, middle + 1));
		ArrayList<String> list2 = new ArrayList<String>(arr.subList(middle + 1, end + 1));
		System.out.println(start + ", " + middle + ", " + end);
		System.out.println(list1 + "\n" + list2);
		int listSize1 = list1.size();
		int listSize2 = list2.size();
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < listSize1 && j < listSize2) {
			if (list1.get(i).compareToIgnoreCase(list2.get(j)) <= 0) {
				arr.set(k, list1.get(i));
				i++;
			} else {
				arr.set(k, list2.get(j));
				j++;
			}
			k++;
		}

		while (i < listSize1) {
			arr.set(k, list1.get(i));
			i++;
			k++;
		}

		while (j < listSize2) {
			arr.set(k, list2.get(j));
			j++;
			k++;
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static ArrayList<String> insertionSort(ArrayList<String> arr, String k) {
		return arr;

	}

	static void merger(ArrayList<String> arr, int l, int r) {

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

	static ArrayList<String> selectionSort(ArrayList<String> A) {
		ArrayList<String> l = new ArrayList<String>(A);
		selectionSortInternal(l);
		return l;
	}

	private static void selectionSortInternal(ArrayList<String> A) {
		int n = A.size();
		for (int i = 0; i < n; i++) {
			int min = i;

			for (int j = i + 1; j < n; j++) {
				if (A.get(j).compareTo(A.get(min)) < 0) {
					min = j;
				}
			}

			if (min != i) {
				Collections.swap(A, min, i);
			}
		}
	}

}
