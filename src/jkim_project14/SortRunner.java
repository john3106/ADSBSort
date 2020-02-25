package jkim_project14;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortRunner {

	private static String[] arr1;
	private static int counter = 0;
	private static ArrayList<String> arrList = new ArrayList<String>();
	private static ArrayList<ArrayList<String>> arrList2d = new ArrayList<ArrayList<String>>();	


	private static void readUsingScanner(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
		System.out.println("Read text file using Scanner");
		// read line by line
		while (scanner.hasNextLine()) {
			// process each line
			String line = scanner.nextLine();
			if (counter == 0) {
				arrList.add(line);
				arrList2d.get(counter).add(line);
			}
			if (counter == 1) {
				arrList2d.get(counter).add(line);
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		arrList2d.add(new ArrayList<String>());
		arrList2d.add(new ArrayList<String>());
		try {
			readUsingScanner("words.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// arrList.sort();
		arr1 = arrList.toArray(new String[] {});
		
		try {
			counter = 1;
			readUsingScanner("source.txt");
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(arrList2d);
		
		Collections.sort(arrList);
		Arrays.sort(arr1);
		System.out.println("Array length: " + arr1.length); // Arrays.toString(arr1));


		String word = "african wild dog";
		System.out.println("Linear Search: " + Sort.linearSearch(arrList, word));
		System.out.println("Binary Search: " + Sort.binarySearch(arrList, 0, arrList.size() - 1, word));
		System.out.println("Jump Search: " + Sort.jumpSearch(arr1, word));

		System.out.println(arrList);

		// Randomize list for sorting methods
		// Collections.shuffle(arrList);
		// String[] arrShuffle = arrList.toArray(new String[] {});
		System.out.println("\n\n\n");
		Collections.shuffle(arrList);
		System.out.println(arrList+"\n");

		
		System.out.println("Bubble Sort: ");
		Collections.shuffle(arrList);
		System.out.println((Sort.bubbleSort(arrList, "descending")));

		
		System.out.println("Merge Sort: ");
		Collections.shuffle(arrList);
		Sort.mergeSort(arrList, arrList.size(), "descending");
		System.out.println(arrList);

		
		System.out.println("QuickSort: ");
		Collections.shuffle(arrList);
		System.out.println(Sort.quicksort(arrList, 0, arrList.size() - 1));

		
		System.out.println("Selection Sort: ");
		Collections.shuffle(arrList);
		System.out.println(Sort.selectionSort(arrList));

		
		System.out.println("Insertion Sort: ");
		Collections.shuffle(arrList);
		System.out.println(Sort.insertionSort(arrList, "descending"));

		
		System.out.println("Gnome Sort: ");
		Collections.shuffle(arrList2d.get(0));
		Collections.shuffle(arrList2d.get(1));
		System.out.println(arrList2d);
		System.out.println(Sort.gnomeSort(arrList2d, "descending"));

	}
}