package jkim_project14;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortRunner {
	
	private static Object[] arr1;
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
	        arr1 = arrList.toArray();
	    }
	 
	 public static void main(String[] args) {
		 try {
			readUsingScanner("source.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(Arrays.toString(arr1));
		 System.out.println(Sort.linearSearch(arr1, "2"));
		 System.out.println(Sort.binarySearch(arr1,  0,  arr1.length-1, "2"));
		 
		 
	 }
}
