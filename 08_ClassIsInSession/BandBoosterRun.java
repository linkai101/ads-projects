import java.util.Scanner;

class BandBoosterRun {
  public static void run() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the name of the first BandBooster: ");
    //String name1 = sc.nextLine();
    BandBooster booster1 = new BandBooster(sc.nextLine());
    System.out.println("Enter the name of the second BandBooster: ");
    //String name2 = sc.nextLine();
    BandBooster booster2 = new BandBooster(sc.nextLine());

    System.out.println();
    System.out.println("Enter the number of boxes sold by " + booster1.name + " in week 1: ");
    //int sales = sc.nextInt();
    booster1.updateSales(sc.nextInt());
    System.out.println("Enter the number of boxes sold by " + booster1.name + " in week 2: ");
    //int sales = sc.nextInt();
    booster1.updateSales(sc.nextInt());
    System.out.println("Enter the number of boxes sold by " + booster1.name + " in week 3: ");
    //int sales = sc.nextInt();
    booster1.updateSales(sc.nextInt());

    System.out.println();
    System.out.println("Enter the number of boxes sold by " + booster2.name + " in week 1: ");
    //int sales = sc.nextInt();
    booster2.updateSales(sc.nextInt());
    System.out.println("Enter the number of boxes sold by " + booster2.name + " in week 2: ");
    //int sales = sc.nextInt();
    booster2.updateSales(sc.nextInt());
    System.out.println("Enter the number of boxes sold by " + booster2.name + " in week 3: ");
    //int sales = sc.nextInt();
    booster2.updateSales(sc.nextInt());

    System.out.println();
    System.out.println(booster1.toString());
    System.out.println(booster2.toString());

    sc.close();
  }
}