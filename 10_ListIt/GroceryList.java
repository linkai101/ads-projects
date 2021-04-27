import java.util.*;

class GroceryList {

  ArrayList<String> list;

  public GroceryList() {
    this.list = new ArrayList<String>();
  }
  
  public GroceryList(ArrayList<String> list) {
    this.list = list;
  }

  public void menu() {
    Scanner scanner = new Scanner(System.in);

    boolean isOpen = true;
    while (isOpen)  {
      display();
      System.out.println("Commands: add <item>, remove <index>, replace <index> <item>, quit\n");

      System.out.print("> ");
      String command = scanner.nextLine();

      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

      ArrayList<String> args = new ArrayList<String>(Arrays.asList(command.split(" ")));

      switch(args.get(0)) {
        case "quit":
          isOpen = false;
          break;
        case "add":
          add(command.split(" ", 2)[1]);
          break;
        case "remove":
          if (args.size() != 2) {
            System.out.println("Invalid usage!\nUsage: remove <index>");
            break;
          } else if (Integer.parseInt(args.get(1)) <= 0 || Integer.parseInt(args.get(1)) > list.size()) {
            System.out.println("Item does not exist, index out of range!");
            break;
          }
          remove(Integer.parseInt(args.get(1))-1);
          break;
        case "replace":
          if (args.size() < 3) {
            System.out.println("Invalid usage!\nUsage: replace <index> <item>");
            break;
          } else if (Integer.parseInt(args.get(1)) <= 0 || Integer.parseInt(args.get(1)) > list.size()) {
            System.out.println("Item does not exist, index out of range!");
            break;
          }
          replace(Integer.parseInt(args.get(1))-1, command.split(" ", 3)[2]);
          break;
        default:
          System.out.println("Unknown command!");
      }
      
      System.out.println("");
    }

    scanner.close();
  }

  public void add(String item) {
    list.add(item);
  }

  public void remove(int index) {
    list.remove(index);
  }

  public void replace(int index, String item) {
    list.set(index, item);
  }

  public void display() {
    System.out.println("--------------------");
    System.out.println("Grocery List");
    System.out.println("Items: " + list.size());
    System.out.println("");

    for (int i=0; i<list.size(); i++) {
      System.out.println(" - " + list.get(i) + " [" + (i+1) + "]");
    }

    if (list.size() == 0) System.out.println("List is empty!");
    
    System.out.println("--------------------");
  }

}