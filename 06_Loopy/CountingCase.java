import java.util.Scanner;

class CountingCase {
  public static void run() {
    String phrase;  // a string of characters
    int length;     // the length of the phrase
    char ch;      // an individual character in the string

    Scanner scan = new Scanner(System.in);

    // Print a program header
    System.out.println ();
    System.out.println ("Character Counter");
    System.out.println ();

    // Read in a string and find its length
    System.out.print("Enter a sentence or phrase: ");
    phrase = scan.nextLine();

    // Initialize counts
    int countBlank = 0;
    int countA = 0;
    int countE = 0;
    int countS = 0;
    int countT = 0;

    // a for loop to go through the string char by char
    // and count the blank spaces
    for (int i=0; i<phrase.length(); i++) {
      //if (phrase.charAt(i) === ' ') countBlank++;
      switch (Character.toLowerCase(phrase.charAt(i))) {
        case ' ':
          countBlank++;
          break;
        case 'a':
          countA++;
          break;
        case 'e':
          countE++;
          break;
        case 's':
          countS++;
          break;
        case 't':
          countT++;
          break;
      }
    }

    // Print the results
    System.out.println();
    System.out.println("Number of blank spaces: " + countBlank); 
    System.out.println("Number of A's: " + countA);   
    System.out.println("Number of E's: " + countE);   
    System.out.println("Number of S's: " + countS);   
    System.out.println("Number of T's: " + countT);   
    System.out.println();
  }
}