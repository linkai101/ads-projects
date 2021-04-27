package wu.linkaiwu.GreedyPlus;

import java.util.Hashtable;
import java.util.Scanner;

public class Greedy {

	public static void main(String[] args) {
		Hashtable<Float, Integer> coinAmounts = calcCoinAmounts(getInput());
		System.out.println(String.format("\nQuarters (0.25): %s\nDimes (0.1): %s\nNickels (0.05): %s\nPennies (0.01): %s\n", coinAmounts.get(0.25f), coinAmounts.get(0.1f), coinAmounts.get(0.05f), coinAmounts.get(0.01f)));
	}
	
	public static float getInput() {
		Scanner scanner = new Scanner(System.in);
		
		float input = 0;
		
		do {
			if (input < 0) {
				System.out.println("USD amounts must be positive!");
				System.out.print("Enter amount in USD: ");
			} else if (input == 0) {
				System.out.print("Enter amount in USD: ");
			}
			
			while (!scanner.hasNextFloat()) {
				System.out.println("Invalid input!");
				System.out.print("Enter amount in USD: ");
				scanner.next();
			}
			
			input = scanner.nextFloat();
		} while (input <= 0);
	    
		scanner.close();
		
		input = Math.round(input*100.0f)/100.0f;
		
		return input;
	}
	
	public static Hashtable<Float, Integer> calcCoinAmounts(float amount) {
		Hashtable<Float, Integer> amounts = new Hashtable<Float, Integer>();
		
		int numQuarters = (int) (amount/0.25);
		amount %= 0.25;

		int numDimes = (int) (amount/0.1);
		amount %= 0.1;

		int numNickels = (int) (amount/0.05);
		amount %= 0.05;

		int numPennies = (int) (amount/0.01);
		amount %= 0.01;
		
		
		amounts.put(0.25f, numQuarters);
		amounts.put(0.1f, numDimes);
		amounts.put(0.05f, numNickels);
		amounts.put(0.01f, numPennies);
		
		return amounts;
	}
}
