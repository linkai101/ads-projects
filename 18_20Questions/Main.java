import java.util.*;

public class Main {
  public static void main(String[] args) throws java.io.IOException {
    TreeNode root = Data.importData("questions.txt");
    
    // traverse
    TreeNode newRoot = root.getAnswer();

    System.out.println("Your answer was probably: " + newRoot.getValue());

    Scanner scanner = new Scanner(System.in);
    String response = promptYOrN("Was that right?", scanner);

    if("n".equals(response)) {
      System.out.print("Then what was your object? ");
      String realObject = scanner.nextLine();

      System.out.print("Question: ");
      String newQuestion = scanner.nextLine();

      boolean realObjectYes = promptYOrN("What's the answer for " + realObject + "?", scanner).equals("y");

      String wrongObject = newRoot.getValue();

      newRoot.setValue(newQuestion);
      if(realObjectYes) {
        newRoot.setLeft(new TreeNode(realObject, newRoot));
        newRoot.setRight(new TreeNode(wrongObject, newRoot));
      } else {
        newRoot.setLeft(new TreeNode(wrongObject, newRoot));
        newRoot.setRight(new TreeNode(realObject, newRoot));
      }

      Data.exportData(root, "questions.txt");
    }
  }

  public static String promptYOrN(String question, Scanner scanner) {
    System.out.print(question);
    System.out.print(" (y/n) ");
    String response = scanner.nextLine();
    while(!"y".equals(response) && !"n".equals(response)) {
      System.out.println("Invalid");
      System.out.print(question);
      System.out.print(" (y/n) ");
      response = scanner.nextLine();
    }

    return response;
  }
}