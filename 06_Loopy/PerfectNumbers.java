import java.util.Scanner;

class PerfectNumbers {
  public static void run() {
    Scanner scanner = new Scanner(System.in);
    double inputNumber = 1;
    while (inputNumber != -1){
      System.out.print("Enter a natural number or -1 to quit:");
      inputNumber = scanner.nextDouble();
      if (inputNumber != -1) {
        perfect(inputNumber);
      }
    }
    scanner.close();
  }
  public static void perfect(double inputNumber) {
    int sum = 0;
    int inputNumber1 = (int) inputNumber;
    for (double possibleFactor = 1; possibleFactor < inputNumber; possibleFactor++) {
      double division1 = inputNumber / possibleFactor;
      int division2 = (int) (inputNumber / possibleFactor);
    if (division1 == division2 ){
    sum += possibleFactor;
    }
    }
    if (sum == inputNumber){
    System.out.println(inputNumber1 + " is a perfect number!");  
    }
    else {
    System.out.println(inputNumber1 + " is not a perfect number!");
    }
    }
}
