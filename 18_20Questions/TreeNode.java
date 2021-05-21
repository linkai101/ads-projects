import java.util.Scanner;

public class TreeNode {
	private String value;
  private TreeNode left;
  private TreeNode right;
  private TreeNode parent;

	// Constructors:
	public TreeNode (String v) {  
		value = v; 
		left = null; 
		right = null; 
		parent = null; 
	}
	public TreeNode (String v, TreeNode up) {  
		value = v; 
		left = null; 
		right = null; 
		parent = up; 
	}
	public TreeNode (String v, TreeNode lt, TreeNode rt, TreeNode up) {
		value = v; 
		left = lt; 
		right = rt; 
		parent = up; 
	}
  //Getters and setters
  public String getValue() { 
    return value; 
  }
  public TreeNode getLeft() { 
    return left; 
  }

  public TreeNode getRight() { 
    return right; 
  }

  public TreeNode getParent() {
    return parent;
  }
  
  public void setValue(String v) { 
    value = v; 
  }

  public void setLeft(TreeNode lt) { 
    left = lt; 
  }

  public void setRight(TreeNode rt) { 
    right = rt; 
  }

  //Tree traversal method
  public TreeNode getAnswer() {
    // Base case: root == null,
    // the tree is empty -- do nothing
    // Recursive case
      //process (root.getValue ( ));

    if(getLeft() == null && getRight() == null) {
      return this;
    }
    
    String response = Main.promptYOrN(getValue(), new Scanner(System.in));

    if("y".equals(response)) {
      return getLeft().getAnswer();
    } else {
      return getRight().getAnswer();
    }
  }
}