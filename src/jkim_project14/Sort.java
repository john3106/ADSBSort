package jkim_project14;

import java.util.ArrayList;

// https://docs.google.com/document/d/1FGWa1GQQVovlErmmdl75gi1JWbKwbETIMaod9ZKUiXc/edit

import java.util.Arrays;
import java.util.List;

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
			int middle = (start+end)/2;
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

		while (arr[Math.min(b,n)-1].compareToIgnoreCase(s) < 0) {
			a = b;
			b += step;
			if (a >= n) {
				return -1;
			}
		}
		while (arr[a].compareToIgnoreCase(s)<0) {
			a++;
			if (a == Math.min(b,n)) {
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
		}
		else if (k.equalsIgnoreCase("descending")) {
			order = -1;
		}
		
		for (int i = 0; i < arr.size()-1; i++) {
			if (order*(arr.get(i).compareToIgnoreCase(arr.get(i+1))) > 0) {
				String replace = arr.get(i);
				arr.set(i, arr.get(i+1));
				arr.set(i+1, replace);
				count++;
			}
		}
		if (count > 0) {
			bubbleSort(arr, k);
		}
		return arr;
	}
	
	static ArrayList<String> mergeSort(ArrayList<String> arr, int l, int r, String k) {
		if (l > r) {
			int middle = (l+r)/2;
			ArrayList<String> smallerList = new ArrayList<String> (arr.subList(r, middle));
			ArrayList<String> largerList  = new ArrayList<String> (arr.subList(middle+1,  l));
			mergeSort(smallerList, middle, r, k);
			mergeSort(largerList, l, middle, k);
		}
		/*
		else {
			merger(arr, l, r);
		}
		*/
		System.out.println(arr.toString());
		return arr;
	}
	
	static void merger(ArrayList<String> arr, int l, int r) {
		
	}
	
	
	

	

}
