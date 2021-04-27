import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) {
		guessMyNumberUnlimited();
	}
	
	public static void coinFlip() {
		int max = 1;
		int min = 0;
		int x = (int) (Math.random() * (max - min + 1) + min);
		
		if (x == 0) {
			System.out.println("Heads");
		} else {
			System.out.println("Tails");
		}
	}
	
	public static void rollDice() {
		String[] diceGraphics = {"\n     x\n", "x\n\n        x", "x\n    x\n        x", "x        x\n\nx        x", "x        x\n    x\nx        x", "x        x\nx        x\nx        x"};
		
		int max = 6;
		int min = 1;
		int dice1 = (int) (Math.random() * (max - min + 1) + min);
		int dice2 = (int) (Math.random() * (max - min + 1) + min);
		
		System.out.println(String.format("You rolled %s, %s", dice1, dice2));
		System.out.println("----------");
		System.out.println(diceGraphics[dice1-1]);
		System.out.println("----------");
		System.out.println(diceGraphics[dice2-1]);
		System.out.println("----------");
	}
	
	
	public static void guessMyNumberLimited() {
		int max = 1000;
		int min = 1;
		int num = (int) (Math.random() * (max - min + 1) + min);
		
		Scanner scanner = new Scanner(System.in);
		
		int guesses = 0;
		int maxGuesses = 10;
		boolean guessedNum = false;
		boolean noMoreGuesses = false;
		System.out.println(String.format("What number am I thinking of? (%s-%s)  You have %s guesses.", min, max, maxGuesses));
		while (!guessedNum && !noMoreGuesses) {
			if (guesses < maxGuesses) {
				System.out.print(String.format("Guess  %s: ", guesses+1));
				int guess = scanner.nextInt();
				System.out.println();
				
				if (guess > num) System.out.println("Guess lower.");
				else if (guess < num) System.out.println("Guess higher.");
				else {
					guessedNum = true;
					System.out.println(String.format("Congratulations! You got it. The number was %s.", num));
				}
				guesses++;
			} else  {
				noMoreGuesses = true;
				System.out.println(String.format("Sorry, you have no guesses left. The number was %s.", num));
			}
		}
		scanner.close();
	}

	public static void guessMyNumberUnlimited() {
		int max = 1000;
		int min = 1;
		int num = (int) (Math.random() * (max - min + 1) + min);
		
		Scanner scanner = new Scanner(System.in);
		
		int guesses = 0;
		boolean guessedNum = false;
		System.out.println(String.format("What number am I thinking of? (%s-%s)", min, max));
		while (!guessedNum) {
			System.out.print(String.format("Guess  %s: ", guesses+1));
			int guess = scanner.nextInt();
			System.out.println();
			
			if (guess > num) System.out.println("Guess lower.");
			else if (guess < num) System.out.println("Guess higher.");
			else {
				guessedNum = true;
				System.out.println(String.format("Congratulations! You got it. The number was %s.", num));
			}
			guesses++;
		}
		scanner.close();
	}

}
