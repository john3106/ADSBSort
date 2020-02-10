package jkim_project14;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SortRunner {
	 private static void readUsingScanner(String fileName) throws IOException {
	        Path path = Paths.get(fileName);
	        Scanner scanner = new Scanner(path);
	        System.out.println("Read text file using Scanner");
	        //read line by line
	        while(scanner.hasNextLine()){
	            //process each line
	            String line = scanner.nextLine();
	            System.out.println(line);
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
	 }
}
