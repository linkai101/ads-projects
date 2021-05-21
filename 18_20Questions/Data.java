import java.io.*;
import java.util.*;

class Data {
  public static TreeNode importData(String filePath) {
    File questionsFile = new File(filePath);
    Scanner s = null;
    try {
      s = new Scanner(questionsFile);
    } catch(Exception e) {}
    
    ArrayList<String> lines = new ArrayList<String>();
    while (s.hasNextLine()) {
      String data = s.nextLine();
      lines.add(data);
    }
    s.close();

    TreeNode root = new TreeNode(lines.get(1));
    TreeNode current = root;
    for (int i=3; i<lines.size(); i+=2) {
      TreeNode newNode = new TreeNode(lines.get(i), current);

      if (current.getLeft() == null) { // Assign next node to left
        current.setLeft(newNode);
        current = current.getLeft();
        if (lines.get(i-1).equals("A:")) current = current.getParent();
      } else if (current.getRight() == null) { // Assign next node to right
        current.setRight(newNode);
        if (lines.get(i-1).trim().equals("A:")) {
          current = current.getParent();
        } else {
          current = current.getRight();
        }
      } else { // Node children are fully assigned
        while (current.getLeft() != null && current.getRight() != null) {
          current = current.getParent();
        }
        i-=2;
      }
    }

    return root;
  }

  public static void exportData(TreeNode node, String filePath) throws IOException {
    PrintWriter writer = new PrintWriter(new FileWriter(filePath));
    exportData(node, writer);
    writer.close();
  }

  private static void exportData(TreeNode node, PrintWriter writer) {
    if(node.getLeft() == null && node.getRight() == null) {
      writer.println("A:");
      writer.println(node.getValue());
    } else {
      writer.println("Q:");
      writer.println(node.getValue());
      exportData(node.getLeft(), writer);
      exportData(node.getRight(), writer);
    }
  }
}