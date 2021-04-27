import java.util.ArrayList;
import java.util.Scanner;

class Palindromes {
  public static void run() {
  Scanner scanner = new Scanner(System.in);
  String inputString = "";
  while(!inputString.equals("-1")){
    System.out.print("Enter a string: ");
    inputString = scanner.nextLine();
    if (!inputString.equals("-1")) {
      isPalindrome(inputString);
    }
  }
  scanner.close();
  }
  public static void isPalindrome(String inputString) {
  String inputString1 = inputString.toLowerCase();
  ArrayList<Character> textLetters = new ArrayList<Character>();
  for(int position = inputString.length() - 1; position >=0; position--){
    textLetters.add(inputString1.charAt(position));
  }
  //String inputBackwards = String.join("", textLetters);

  // Convert textLetters to string
  StringBuilder result = new StringBuilder(textLetters.size());
  for (Character c : textLetters) {
  result.append(c);
  }
  String inputBackwards = result.toString();

  if (inputBackwards.equals(inputString1)){
  System.out.println("'" + inputString + "' is a palindrome!");
  }
  else{
  System.out.println("'" + inputString + "' is not a palindrome!");   
  }
  }
}
