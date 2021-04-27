import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;

public class ArrayofSunshine {

  /* Take in an array of ints and a value
  * index = -1 as a default
  * For every value in the ints array:
  * 	If the value is the value looked for:
  * 		index = the index of that value
  * return index 
  */

  public static int lastIndexOf(int[] ints, int value) {
    int index = -1;
    //if the value wasn't found, index will be -1
    for (int i = 0; i < ints.length; i++) {
      if (ints[i] == value) {
        index = i;
      }
    }
    return index;
  }

/* returns 1 if array has only one element
  else sort array and return the difference between the first and last values in the array + 1*/

  public static int range(int[] ints) {
    if (ints.length == 1) return 1;
    Arrays.sort(ints);
    return ints[ints.length-1]-ints[0]+1; // is this else?
  }
  
/*sets a counter to 0; for each index position of the array given, adds 1 to the counter if the value is between the minValue and maxValue; returns counter */
  public static int countInRange(int[] ints, int minValue, int maxValue) {
    int count = 0;
    for (int i = 0; i < ints.length ; i++) {
      if (ints[i] >= minValue && ints[i] <= maxValue) {
        count++;
      }
    }
    return count;
  }

  // Check if double array is sorted
  public static boolean isSorted(double[] nums) {
    double[] sortedNums = nums;
    String nums_str = Arrays.toString(nums);
    Arrays.sort(sortedNums); // Sorts instance of given array
    String sort_str = Arrays.toString(sortedNums);
    return nums_str.equals(sort_str); // Compares string values of sorted and unsorted arrays
  }
  
  // Returns the mode of an int array
  public static int mode(int[] nums) {
    int mode=-1;
    int occurances=0;
    int tempMode=-1;
    int tempOccurances=0;

    Arrays.sort(nums); // Sorts given array
    for (int i=nums.length-1; i>0; i--) { // Iterates sorted array from greatest to least
      if (nums[i] == nums[i-1]) { // If value is equal to next value, add to temp counters
        tempMode = nums[i];
        tempOccurances++;
      } else { // At the end of sequence of duplicate numbers, assigns to counters if temp count is greater than previous count
        mode = (tempOccurances >= occurances) ? tempMode : mode;
        occurances = (tempOccurances >= occurances) ? tempOccurances : occurances;
        tempOccurances = 0;
      }
    }

    if (occurances==0) return nums[0];
    return mode;
  }

  // Returns the standard deviation of an int array
  // square root of the sum of the squares of the differences between each element and the mean, divided by one less than the number of elements
  public static double stdev(int[] a) { 
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    double average = (double) sum / a.length;
    double sumDifSquare = 0;
    for (int k = 0; k < a.length; k++) {
      sumDifSquare += Math.pow((a[k] - average), 2);
    }
    double quotient = sumDifSquare / (a.length - 1);
    double stDevVar = Math.sqrt(quotient);
    return stDevVar;
  }

  // Returns the kth largest value of an int array
  /* sorts array and returns the value k index positions from the end of the array (length - k - 1)*/
  public static int kthLargest(int k, int[] a) {
    Arrays.sort(a);
    return a[a.length - k - 1];
  }
  
  // Returns the minimum difference between each adjacent pair in an int array
  public static int minGap(int[] a) {
    int smallestGap;
    if (a.length < 2) { // If there is less than 2 values, return 0
      smallestGap = 0;
    }
    else {
      smallestGap = a[1] - a[0];
      for (int i = 0; i < a.length - 1; i++) { // Iterates through array
        if (a[i+1] - a[i] < smallestGap) { // Changes smallestGap if gap is smaller than previous smallestGap value
          smallestGap = a[i+1] - a[i];
        }
      }
    }
    return smallestGap;
  }

  // Returns the percent of the values of an int array that is even
  public static double percentEven(int[] a) {
    int numEven = 0;
    for (int i = 0; i < a.length; i++) { // Counts number of even values in array
      if (a[i] % 2.0 == 0) {
        numEven++;
      }
    }
    double percent;
    if (a.length > 0) {
      percent = (double) numEven / a.length * 100; // Calculates percent
    }
    else { // Returns 0 if array is empty
      percent = 0.0;
    }
    return percent;
  }
/* set a unique variable to true; sorts array; if the array has at least two index positions, checks to see if a value is the same as the value in the next index position in the sorted array, breaks and sets unique to false if true; returns unique variable */
  public static boolean isUnique(int[] a) {
    boolean unique = true;
    Arrays.sort(a);
    if (a.length >= 2) {
      for (int i = 0; i < a.length - 1; i++) {
        if (a[i] == a[i+1]) {
          unique = false;
          break;
        }
      }
    }
    return unique;
  }
  
  // Returns the greatest value in an int array that is less than a given int
  public static int priceIsRight(int[] bids, int price) {
    Arrays.sort(bids); // Sorts array
    for (int i=bids.length-1; i>=0; i--) { // Iterates from greatest to least
      if (bids[i] < price) return bids[i]; // Returns value in array if value is less than price
    }
    return -1;
  }
  
  // Returns the length of the longest sorted sequence of adjacent values in an int array
  public static int longestSortedSequence(int[] a) {
    int currentLength = 1;
    int longestLength = 0;
    for (int i = 0; i < a.length - 1; i++) { // Iterates through array
      if (a[i] <= a[i+1]) { // If value and next value is sorted, add 1 to length counter
        currentLength++;
        //System.out.println(a[i+1]);
      }
      else { // At the end of a sorted sequence, if length is longer than the longestLength counter, assign current length to longestLength
        if (currentLength>longestLength) longestLength = currentLength;
        currentLength = 1; // Reset length counter
      }
    }
    if (currentLength > longestLength) {
      longestLength = currentLength;
    }
    if (a.length > 0) {
      return longestLength;
    }
    else {
      return 0; // Returns 0 if array is empty
    }
  }
/* sets contains variable to false; for each index position possible in a1, checks to see if the index position and the few after it are the same as a2; returns true if a2 is contained in a1 and false otherwise */
  public static boolean contains(int[] a1, int[] a2) {
    boolean contains = false;

    for (int i=0; i<a1.length-a2.length + 1; i++) {
      boolean atIndexContains = true;
      for (int j=0; j<a2.length; j++) {
        if (a1[i+j] != a2[j]) atIndexContains = false;
      }
      if (atIndexContains) contains = true;
    }

    return contains;
  }

  // Returns an int array with every other adjacent values summed from a given int array
  public static int[] collapse(int[] list) {
    int[] newList = new int[(int)(Math.ceil(list.length/2.0))];
    int currentIndex = 0;
    for (int i=0; i<list.length-1; i+=2) { // Iterates through list by every two values
      newList[currentIndex] = list[i]+list[i+1]; // Add sum of two values to newList
      currentIndex++;
    }
    if (list.length%2 != 0) newList[currentIndex] = list[list.length-1]; // If list is odd, add last value to newList
    return newList;
  }

  // Returns an int array with the second int array appended to the first int array
  /* creates a combined array with the length of the sum of the lengths of a and b; sets the first a index positions to the values of a and the rest of the values to b; returns combined array */
  public static int[] append(int[] a, int[] b) {
    int[] combined = new int[a.length + b.length];
    for (int i=0; i < a.length; i++) {
      combined[i] = a[i];
    }
    for (int k = a.length; k < combined.length; k++) {
      combined[k] = b[k - a.length];
    }
    return combined;
  }

  // Returns an array with the occurences of A,E,I,O,U respectively in a given string
  public static int[] vowelCount(String word) {
    int[] count = {0,0,0,0,0};
    for (int i=0; i<word.length(); i++) { // Iterates through characters in string
      if (word.substring(i,i+1).equals("a")) count[0]++; // If character is equal to vowel, add 1 to respective value in counter
      if (word.substring(i,i+1).equals("e")) count[1]++;
      if (word.substring(i,i+1).equals("i")) count[2]++;
      if (word.substring(i,i+1).equals("o")) count[3]++;
      if (word.substring(i,i+1).equals("u")) count[4]++;
    }
    return count;
  }

}