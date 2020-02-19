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
	private static ArrayList<String> arrList = new ArrayList<String>();

	private static void readUsingScanner(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
		System.out.println("Read text file using Scanner");
		// read line by line
		while (scanner.hasNextLine()) {
			// process each line
			String line = scanner.nextLine();
			arrList.add(line);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		try {
			readUsingScanner("source.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// arrList.sort();
		arr1 = arrList.toArray(new String[] {});

		Collections.sort(arrList);
		Arrays.sort(arr1);
		System.out.println("Array length: " + arr1.length); // Arrays.toString(arr1));


		 String word = "african wild dog";
		 System.out.println("Linear Search: "+Sort.linearSearch(arrList, word));
		 System.out.println("Binary Search: "+Sort.binarySearch(arrList,  0,  arrList.size()-1, word));
		 System.out.println("Jump Search: "+Sort.jumpSearch(arr1, word));
		 
		 
		 //Randomize list for sorting methods
		 Collections.shuffle(arrList);
		 String[] arrShuffle = arrList.toArray(new String[]{});
		 System.out.println("\n\n\n");
		 System.out.println(arrList);
		 System.out.println("Bubble Sort: ");
		 System.out.println((Sort.bubbleSort(arrList, "ascending")));
		 System.out.println("Merge Sort: ");
		 Collections.shuffle(arrList);
		 System.out.println(arrList);
		 System.out.println(Sort.mergeSort(arrList,  0,  arrList.size()-1, "ascending"));
	 

		System.out.println(Sort.quicksort(arrList, 0, arrList.size() - 1));
	}
}