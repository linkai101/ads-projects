import java.util.*;
import java.util.ArrayList;

class Sort {
  public static int binarySearch(int value, ArrayList<Integer> list) { // BINARY SEARCH, list is already sorted
    int index = list.size()/2;
    while (list.get(index) != value) {
      if (list.get(index) > value) {
        index /= 2;
      } else if (list.get(index) < value) {
        index += (list.size()-index)/2;
      }
    }
    return index;
  }
  public static int jumpSearch(int value, ArrayList<Integer> list) { // JUMP SEARCH, list is already sorted
    int index = 0;
    int jumpSize = 3; //Math.sqrt(list.size());
    while (list.get(index) != value) {
      if (list.get(index) > value) {
        index--;
      } else if (list.get(index) < value) {
        index += jumpSize;
      }
    }
    return index;
  }
  
  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) { // BUBBLE SORT
    if (list.size() <= 1) return list;
    while (!checkSorted(list)) {
      // For each value, if value is less than before, swap values
      for (int i=1; i<list.size(); i++) {
        if (list.get(i) < list.get(i-1)) {
          int temp = list.get(i);
          list.set(i, list.get(i-1));
          list.set(i-1, temp);
        }
      }
    }

    return list;
  }
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) { // INSERTION SORT
    if (list.size() <= 1) return list;
    // For each value, if value is less than before, move value back until it is greater than value before
    for (int i=1; i<list.size(); i++) {
      if (list.get(i) < list.get(i-1)) {
        // For each value before the current value, if is greater than or equal, move current value to position
        for (int a=i-1; a>=0; a--) {
          if (list.get(i) >= list.get(a)) {
            //System.out.println(i+ " "+a);
            // Move to index a+1, break out of loop
            list.add(a+1, list.get(i));
            list.remove(i+1);
            break;
          }
          if (a == 0) {
            list.add(0, list.get(i));
            list.remove(i+1);
          }
        }
      }
    }

    return list;
  }
  public static ArrayList<Integer> bucketSort(ArrayList<Integer> list) { // BUCKET SORT
    if (list.size() <= 1) return list;
    //find the maximum value in the list
    int max = list.get(1);
    for (int i=0; i<list.size(); i++) {
      if (list.get(i) > max) {
        max = list.get(i);
      }
    }
    //puts every number in a bucket
    ArrayList<Integer> bucket1 = new ArrayList<Integer>();  
    ArrayList<Integer> bucket2 = new ArrayList<Integer>();
    ArrayList<Integer> bucket3 = new ArrayList<Integer>();
    ArrayList<Integer> bucket4 = new ArrayList<Integer>();
    ArrayList<Integer> bucket5 = new ArrayList<Integer>(); 
    for (int i = 0; i<list.size(); i++ ){
      if (i < (max * .2)) bucket1.add(list.get(i));
      else if (i<(max*.4)) bucket2.add(list.get(i));
      else if (i<(max*.6)) bucket3.add(list.get(i));
      else if (i<(max*.8)) bucket4.add(list.get(i));
      else bucket5.add(i);
    }
    //sorts every bucket
    insertionSort(bucket1);
    insertionSort(bucket2);
    insertionSort(bucket3);
    insertionSort(bucket4);
    insertionSort(bucket5);
    for (int i : bucket2){
      bucket1.add(i);
    }
    for (int i : bucket3){
    bucket1.add(i);
    }   
    for (int i : bucket4){
      bucket1.add(i);
    }
    for (int i : bucket5){
      bucket1.add(i);
    }
    return bucket1;
  } 
  public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
    if (list.size() <= 1) return list;
    ArrayList<ArrayList<Integer>> subLists = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<list.size(); i+=2) {
      ArrayList<Integer> nextSubList = new ArrayList<Integer>();
      nextSubList.add(list.get(i));
      if (i+1 < list.size()) { // if is not the last in list
        nextSubList.add(list.get(i+1));
      }
      subLists.add(nextSubList);
    }
    // sort
    while (subLists.size() > 1) {
      // sort sublist
      for (int i=0; i<subLists.size(); i++) {
        subLists.set(i, insertionSort(subLists.get(i)));
      }
      // merge if size is > 1
      if (subLists.size() > 1) {
        for (int i=0; i<subLists.size()-1; i++) {
          subLists.get(i).addAll(subLists.get(i+1));
          subLists.remove(i+1);
        }
      }
    }
    subLists.set(0, insertionSort(subLists.get(0)));
    return subLists.get(0);
  }

  public static boolean checkSorted(ArrayList<Integer> list) {
    // For each value, if value is less than value before, then list is unsorted
    for (int i=1; i<list.size(); i++) {
      if (list.get(i) < list.get(i-1)) return false;
    }
    return true;
  }
}