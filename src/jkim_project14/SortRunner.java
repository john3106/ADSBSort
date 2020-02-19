package jkim_project14;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortRunner {
	
	private static String[] arr1;
	private static ArrayList<String> arrList = new ArrayList<String>();
	private static void readUsingScanner(String fileName) throws IOException {
	       Path path = Paths.get(fileName);
	       Scanner scanner = new Scanner(path);
	        System.out.println("Read text file using Scanner");
	        //read line by line
	        while(scanner.hasNextLine()){
	            //process each line
	            String line = scanner.nextLine();
	            arrList.add(line);
	        }
	        scanner.close();
	    }
	 
	 public static void main(String[] args) {
		 try {
			readUsingScanner("words.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 arrList.sort();
		 arr1 =  arrList.toArray(new String[]{});

		 Arrays.sort(arr1);
		 System.out.println("Array length: " + arr1.length); //Arrays.toString(arr1));

		 String word = "insulation";

		 System.out.println(Sort.linearSearch(arr1, word));
		 System.out.println(Sort.binarySearch(arr1,  0,  arr1.length-1, "2"));
		//  System.out.println(Sort.jumpSearch(arr1, word));
		// pick your own search
	 }
}
