import java.util.Scanner;
import java.util.*;

class Main {
  public static void main(String[] args) {
    //digitSum
    //int n = 1234;
    //System.out.println(digitSum(n));
    
    //countCannonballs
    //int height = 6;
    //System.out.println(countCannonballs(height));

    //isPalindrome
    //String str1 = "racecar";
    //System.out.println(isPalindrome(str1));
    
    //String str2 = "{[(])]}";
    //System.out.println(isBalanced(str2));

    // substrings
    System.out.println(substrings("ABC"));

    //printInBinary
    //System.out.println(printInBinary(12));
  }


	//digitSum
	public static int digitSum(int n){
		if (n == 0){
			return 0;
		}
		return (n % 10 + digitSum(n / 10));
	}

	//countCannonballs
	public static int countCannonballs(int height) {
			if (height == 0) return 0; // Return 0 if height is 0
			return height+countCannonballs(height-1); // Return sum of longest row (also the height) and count of height-1
	}

	//isPalindrome
	public static boolean isPalindrome(String str1) {
    if (str1.length() <= 1) return true;
    return str1.substring(0,1).equals(str1.substring(str1.length()-1, str1.length())) && isPalindrome(str1.substring(1,str1.length()-1));
	}

	public static boolean isBalanced(String str) {
		str = str.replaceAll("\\s", "");
		if (str.length() == 0) return true; // If is blank string, return true
		if (str.length()%2 == 1) return false; // If length is odd, return false
		// If first and last chars are a pair, recall function with substring without first and last chars
		if ((str.substring(0,1).equals("(") && str.substring(str.length()-1, str.length()).equals(")"))
				|| (str.substring(0,1).equals("[") && str.substring(str.length()-1, str.length()).equals("]"))
				|| (str.substring(0,1).equals("{") && str.substring(str.length()-1, str.length()).equals("}"))) {
				return isBalanced(str.substring(1,str.length()-1));
		}
		return false; // Return false if first and last chars are not a pair
	}

	//substrings
	public static String substrings(String str) {
		return substringsHelper(str, "");
	}

  public static String substringsHelper(String str, String ans) {
    if (str.length()==0) return ans;
    return substringsHelper(str.substring(1), ans+str.charAt(0))+","+substringsHelper(str.substring(1), ans);
  }

	//printInBinary
	public static String printInBinary(int decimal) {
		if (decimal == 0){
			return "0";
		} else {
      return String.valueOf(decimal % 2 + 10 * Integer.parseInt(printInBinary(decimal/2)));
    }
	}
}
