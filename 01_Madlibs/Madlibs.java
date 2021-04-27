import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Madlibs {
	
	// Project specifications
	final static String PROJECT = "Project 01 - Madlibs";
	final static String AUTHOR = "Linkai Wu";
	
	final static String TITLE = 
			"___  ___          _ _ _ _         \n"+
			"|  \\/  |         | | (_) |        \n"+
			"| .  . | __ _  __| | |_| |__  ___ \n"+
			"| |\\/| |/ _` |/ _` | | | '_ \\/ __|\n"+
			"| |  | | (_| | (_| | | | |_) \\__ \\\n"+
			"\\_|  |_/\\__,_|\\__,_|_|_|_.__/|___/\n";

	public static void main(String[] args) {
		System.out.println(String.format("%s\nby %s\n", PROJECT, AUTHOR));
		System.out.println(TITLE);
		
		final File madlibsDir = new File("./madlibs");
		List<String> files = filesInDirectory(madlibsDir); // String list of files in madlibs directory
		
		// Listing all story titles in /src/madlibs folder
		System.out.println("Availible Story Titles:");
		for (int i=0; i<files.size(); i++) {
			System.out.println(String.format("- %s (%s)", files.get(i), files.indexOf(files.get(i))));
		}
		
		// Getting user input on story index
		int storyIndex = -1; // Preinitialized as -1 so variable can be checked if input is invalid
		
		boolean validStory = false;
		while (!validStory) {
			Scanner indexScanner = new Scanner(System.in); // Declaring scanner
			System.out.print("\nEnter index: ");
			try {
				storyIndex = indexScanner.nextInt();
			}
			catch(Exception e) {
				storyIndex = -1;
			}
			
			if (storyIndex>=0 && storyIndex<files.size()) validStory = true; // Breaks loop when input is an int between the valid indexes
			if (!validStory) System.out.println("Invalid index. Try again!");
			
		}
		
		
		String story = files.get(storyIndex); // Name of story
		
		File storyFile = new File(String.format("./src/madlibs/%s.txt", story));
		List<String> storyText = readFile(storyFile); // List of lines from story txt file
		
		Hashtable<String, String> placeholders = new Hashtable<String, String>(); // Dictionary of placeholders and values
		
		// Finding placeholders in text in {} and adding them to placeholders dictionary
		for (int i=0; i<storyText.size(); i++) {
			Matcher m = Pattern.compile("\\{(.*?)\\}").matcher(storyText.get(i));
			while(m.find()) {
			    //System.out.println(m.group(1));
				if (placeholders.get(m.group(1)) == null) {
					placeholders.put(m.group(1), "N/A");
				}
			}
		}
		
		// Gets user input for placeholder values and adding them to placeholder dictionary
		System.out.println("\nPlaceholders:");
		Scanner placeholderScanner = new Scanner(System.in); // Declaring scanner
		for (String key : placeholders.keySet()) {
		    System.out.print(String.format("(%s) ", key));
		    String value = placeholderScanner.nextLine();
		    placeholders.put(key, value);
		}
		placeholderScanner.close();
		
		// Replacing placeholders with values in storyText
		for (int i=0; i<storyText.size(); i++) {
			String line = storyText.get(i);
			for (String key : placeholders.keySet()) {
			    line = line.replaceAll(String.format("\\{%s\\}", key), placeholders.get(key));
			}
			storyText.set(i, line);
		}
		
		// Prints final story
		System.out.println("\n");
		printList(storyText);
	}
	
	// Returns a String list of txt files in a directory (without extension)
	public static List<String> filesInDirectory(final File directory) {
		List<String> files = new ArrayList<>();
		for (final File fileEntry : directory.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	filesInDirectory(fileEntry);
	        } else {
	        	if (fileEntry.getName().endsWith(".txt")) files.add(fileEntry.getName().replaceFirst("[.][^.]+$", ""));
	            //System.out.println(fileEntry.getName());
	        }
	    }
		
		return files;
	}
	
	// Reads a file and returns text in a String list
	public static List<String> readFile(File file) {
		List<String> fileText = new ArrayList<>();
		
		try {
	    	Scanner storyReader = new Scanner(file);
	    	while (storyReader.hasNextLine()) {
	    		String data = storyReader.nextLine();
	    		//System.out.println(data);
	    		fileText.add(data);
		    }
	    	storyReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return fileText;
	}
	
	// Prints a String list line by line
	public static void printList(List<String> list) {
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
