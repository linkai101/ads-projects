import java.util.*;

class Dictionary {

  TreeMap<String, String> dictionary;

  public Dictionary() {
    this.dictionary = new TreeMap<String, String>();
  }

  public void menu() {
    Scanner scanner = new Scanner(System.in);

    boolean isOpen = true;
    while (isOpen) {
      System.out.println("--------------------");
      System.out.println("Dictionary");
      System.out.println("Words: " + dictionary.size());
      System.out.println("");

      System.out.println("Commands: display, add <word> <definition>, remove <word>, change <word> <definition>, search <query>, quit");
      
      System.out.println("--------------------");
      System.out.println("");

      System.out.print("> ");
      String command = scanner.nextLine();

      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

      ArrayList<String> args = new ArrayList<String>(Arrays.asList(command.split(" ")));

      switch(args.get(0)) {
        case "quit":
          isOpen = false;
          break;
        case "display":
          display();
          break;
        case "add":
          if (args.size() < 3) {
            System.out.println("Invalid usage!\nUsage: add <word> <definition>");
            break;
          } else if (dictionary.containsKey(args.get(1))) {
            System.out.println("Word already exists!");
            break;
          }
          add(args.get(1), command.split(" ", 3)[2]);
          break;
        case "remove":
          if (args.size() != 2) {
            System.out.println("Invalid usage!\nUsage: remove <word>");
            break;
          } else if (!dictionary.containsKey(args.get(1))) {
            System.out.println("Word does not exist!");
            break;
          }
          remove(args.get(1));
          break;
        case "change":
          if (args.size() < 3) {
            System.out.println("Invalid usage!\nUsage: change <word> <definition>");
            break;
          } else if (!dictionary.containsKey(args.get(1))) {
            System.out.println("Word does not exist!");
            break;
          }
          change(args.get(1), command.split(" ", 3)[2]);
          break;
        case "search":
          if (args.size() < 2) {
            System.out.println("Invalid usage!\nUsage: search <query>");
            break;
          }
          search(command.split(" ", 2)[1]);
          break;
        default:
          System.out.println("Unknown command!");
      }
      
      System.out.println("");
    }

    scanner.close();
  }

  public void display() {
    System.out.println("--------------------");
    System.out.println("Words: " + dictionary.size());

    System.out.println();
    dictionary.forEach((key, value) -> {
      System.out.println(key + ": " + value);
    });

    if (dictionary.size() == 0) System.out.println("Dictionary is empty!");
    
    System.out.println("--------------------");
  }

  public void add(String word, String definition) {
    dictionary.put(word, definition);
  }

  public void remove(String word) {
    dictionary.remove(word);
  }

  public void change(String word, String definition) {
    dictionary.put(word, definition);
  }

  public void search(String query) {
    TreeMap<String, String> results = new TreeMap<String, String>();
    
    dictionary.forEach((key, value) -> {
      if ((key.toLowerCase()).contains(query.toLowerCase())) {
        results.put(key, value);
      } else if ((value.toLowerCase()).contains(query.toLowerCase())) {
        results.put(key, value);
      }
    });
    
    System.out.println("--------------------");
    System.out.println("Query: " + query);
    System.out.println("Results: " + results.size());

    System.out.println();
    results.forEach((key, value) -> {
      System.out.println(key + ": " + value);
    });

    if (results.size() == 0) System.out.println("No words or definitions matched your query.");
    
    System.out.println("--------------------");

  }

}
