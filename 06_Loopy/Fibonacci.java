import java.util.Scanner;

class Fibonacci {
  public static void run() {
    Scanner scanner = new Scanner(System.in);
    int input = 0;
    while (input != -1) {
      System.out.print("Enter a positive number or -1 to quit:");
      input = scanner.nextInt();
      if (input != -1) System.out.println("Fibonacci number "+input+" is "+fibonacci(input));
    }
    scanner.close();
  }

  public static int fibonacci(int index) {
    int a = 1;
    int b = 1;
    int temp;
    for (int i=0; i<index-2; i++) {
      temp = b;
      b += a;
      a = temp;
    }
    return b;
  }
}