import java.util.Scanner;

class TestNames {
  public static void run() {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first name for person 1:");
    String person1First = sc.nextLine();
    System.out.println("Enter middle name for person 1:");
    String person1Middle = sc.nextLine();
    System.out.println("Enter last name for person 1:");
    String person1Last = sc.nextLine();
    Name person1 = new Name(person1First, person1Middle, person1Last);
    
    System.out.println();
    System.out.println("Enter first name for person 2:");
    String person2First = sc.nextLine();
    System.out.println("Enter middle name for person 2:");
    String person2Middle = sc.nextLine();
    System.out.println("Enter last name for person 2:");
    String person2Last = sc.nextLine();
    Name person2 = new Name(person2First, person2Middle, person2Last);

    System.out.println();
    System.out.println(person1.firstMiddleLast());
    System.out.println(person1.lastFirstMiddle());
    System.out.println("Initials: " + person1.initials());
    System.out.println("Length: " + person1.length());

    System.out.println();
    System.out.println(person2.firstMiddleLast());
    System.out.println(person2.lastFirstMiddle());
    System.out.println("Initials: " + person2.initials());
    System.out.println("Length: " + person2.length());
    
    System.out.println();
    System.out.println("Person 1 and person 2 " + ((person1.equals(person2)) ? "have the same name." : "do not have the same name."));

    sc.close();

  }
}