import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String method = "";
    while (!method.equals("caesar") && !method.equals("vigenere")) {
      System.out.println("Select encryption method: (caesar/vigenere) ");
      method = scanner.nextLine().toLowerCase();
    }
    System.out.println();

    if (method.equals("caesar")) { //  Caesar cypher
      System.out.print("TEXT: ");
      String text = scanner.nextLine();
      System.out.print("SHIFT: ");
      int shift = scanner.nextInt();

      System.out.println("\nENCRYPTED TEXT:");
      System.out.println(Caesar.encrypt(text, shift));

    } else { // Vigenere cypher
      System.out.print("TEXT: ");
      String text = scanner.nextLine();
      System.out.print("KEYWORD: ");
      String keyword = (scanner.nextLine()).toUpperCase();

      System.out.println("\nENCRYPTED TEXT:");
      System.out.println(Vigenere.encrypt(text, keyword));
    }
    
    scanner.close();
  }
}