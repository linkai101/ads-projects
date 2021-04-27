//SortRunner

// Read data from txt file
// Convert to array
// Start timer
// Search and sort
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner t = new Scanner(System.in);

    System.out.println("Which file do you want to sort? (in sets folder, include extension name)");
    String fileName = t.nextLine();
    System.out.println();

    // Reading file
    File f = new File("sets/"+fileName);
    Scanner s = new Scanner(f);
    ArrayList<Integer> list = new ArrayList<Integer>();
    while (s.hasNext()){
      list.add(Integer.parseInt(s.next()));
    }
    s.close();
    
    /*
      SORT METHOD
    */
    System.out.println("Which sort method do you want to use? (bubble/insertion/bucket/merge)");
    String sortMethod = t.nextLine().toLowerCase();
    
    // Start timer
    long startSortTime = System.currentTimeMillis();

    if (sortMethod.equals("bubble")){
      list = Sort.bubbleSort(list);
    }
    else if (sortMethod.equals("insertion")){
      list = Sort.insertionSort(list);
    }
    else if (sortMethod.equals("bucket")){
      list = Sort.bucketSort(list);
    }
    else if (sortMethod.equals("merge")){
      list = Sort.mergeSort(list);
    }
    else {
      System.out.println("Invalid sort method!");
      return;
    }

    // End timer
    long endSortTime = System.currentTimeMillis();
    
    System.out.println("The sort algorithm took " + (endSortTime - startSortTime) + " milliseconds to run.");
    System.out.println(list);
    System.out.println();

    /*
      SEARCH METHOD
    */
    System.out.println("Which search method do you want to use? (binary/jump)");
    String searchMethod = t.nextLine().toLowerCase();
    
    System.out.println("What value do you want to search for? (int)");
    int searchValue = Integer.parseInt(t.nextLine());
    
    // Start timer
    long startSearchTime = System.currentTimeMillis();

    int searchIndex = -1;
    if (searchMethod.equals("binary")){
      searchIndex = Sort.binarySearch(searchValue, list);
    }
    else if (searchMethod.equals("jump")){
      searchIndex = Sort.jumpSearch(searchValue, list);
    }
    else {
      System.out.println("Invalid search method!");
      return;
    }

    // End timer
    long endSearchTime = System.currentTimeMillis();
    
    System.out.println("The search algorithm took " + (endSearchTime - startSearchTime) + " milliseconds to run.");
    System.out.println("The index of the value '" + searchValue + "' is " + searchIndex);
    System.out.println();


    // Close input scanner
    t.close();
  }
}