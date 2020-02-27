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
	private static ArrayList<String> arrStats = new ArrayList<String>();
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

		int counterSearch = 2;
		String algName = "";
		String word = "african wild dog";
		for (int i = 0; i <= counterSearch; i++) {
			long startTime = System.nanoTime();
			if (i == 0) {
				System.out.println("Linear Search: " + Sort.linearSearch(arrList, word));
				algName = "Linear Search";
			}
			else if (i == 1) {
				System.out.println("Binary Search: " + Sort.binarySearch(arrList, 0, arrList.size() - 1, word));
				algName = "Binary Search";
			}
			else if (i == 2) {
				System.out.println("Jump Search: " + Sort.jumpSearch(arr1, word));
				algName = "Jump Search";
			}
			long endTime = System.nanoTime();
			System.out.println("The "+algName+" algorithm took "+ (endTime-startTime) + " nanoseconds to run");
			arrStats.add(algName+": "+(endTime-startTime));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int counterSort = 7;
		System.out.println(arrList+"\n");
		for (int j = 0; j <= counterSort; j++) {
			// Randomize list for sorting methods
			// Collections.shuffle(arrList);
			// String[] arrShuffle = arrList.toArray(new String[] {});
			Collections.shuffle(arrList);
			long startTime = System.nanoTime();
			if (j == 0) {
				System.out.println("Bubble Sort: "+(Sort.bubbleSort(arrList, "descending")));
				algName = "Bubble Sort";
			}
			else if (j == 1) {
				Sort.mergeSort(arrList, arrList.size(), "descending");
				System.out.println("Merge Sort: "+arrList);
				algName = "Merge Sort";
			}
			else if (j == 2) {
				System.out.println("Quick Sort: "+ Sort.quicksort(arrList, 0, arrList.size() - 1));
				algName = "Quick Sort";
			}
			else if (j == 3) {
				System.out.println("Selection Sort: "+Sort.selectionSort(arrList));
				algName = "Selection Sort";
			}
			else if (j == 4) {
				System.out.println("Insertion Sort: "+Sort.insertionSort(arrList,  "descending"));
				algName = "Insertion Sort";
			}
			else if (j == 5) {
				Collections.shuffle(arrList2d.get(0));
				Collections.shuffle(arrList2d.get(1));
				System.out.println(arrList2d);
				System.out.println("Gnome Sort: "+Sort.gnomeSort(arrList2d, "descending"));
				algName = "Gnome Sort";
			}
			else {
				System.out.println("hi");
			}
			long endTime = System.nanoTime();
			System.out.println("The "+algName+" algorithm took "+ (endTime - startTime) + " nanoseconds to run");
			arrStats.add(algName+": "+(endTime-startTime));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(arrStats);

	}
}