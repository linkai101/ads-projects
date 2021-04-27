import java.util.Scanner;
import java.lang.Math;
import java.util.*;

class Main {
  public static void main(String[] args){

		int counter1;
		int counter2;
		int sum;
		int column = 0;
		int d;
		int p;
		int row = 0;
		int w = 1;


		//Introduction
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to the N Queens Puzzle! The 0s represent empty spaces, and the 1s represent your Queens.");
		//Entering value n for n*n board
		System.out.println("Please enter a value n up to 12 (number of queens and size of your board)");
		int n = reader.nextInt();
		int[][] board = new int[n][n];
		System.out.println("");
		//Print empty board
		System.out.println("Your current board with no queens:");
		for (int i = 0; i < board.length; i++){
			System.out.println("\n");
			for (int k = 0; k < board[0].length; k++){
				System.out.print("\t" + board[i][k]);
			}
		}
		
		System.out.println("");

		//Special situations
		if (n == 1){
			board[0][0] = 1;
			System.out.println("");
			System.out.println("");
			System.out.println("One solution:");
			for (int i = 0; i < board.length; i++){
			System.out.println("\n");
				for (int k = 0; k < board[0].length; k++){
					System.out.print("\t" + board[i][k]);
				}
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("All solutions have been printed.");
			System.out.println("There is 1 solution");
			System.exit(-1);
		}
		if (n == 2 || n == 3){
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("No solutions found for " + n + "x" + n + " board.");
			System.exit(-1);
		}

		while (column <= board[0].length){
			//placing queen
			while (row < board.length){
				//testing
				while (column < board[0].length){
					counter1 = 0;
					counter2 = 0;
					//checking columns
					for (int c = 0; c < board.length; c++){
						if (board[c][column] == 1){
							counter1++; //counts how many other queens are in same column
						}
					}
					//checking diagonals
					d = 1;
					//left backwards
					while ((row - d >= 0) && (column - d >= 0)){
						if (board[row - d][column - d] == 1){ 
							counter2++; 
						}
						d++;
					}
					d = 1;
					//right backwards
					while ((row - d >= 0) && ((column + d) < board[0].length)){
						if (board[row - d][column + d] == 1){
							counter2++; 
						}
						d++;
					}
					//checks if spot is safe
					if ((counter1 >= 1) || (counter2 >= 1)){
						board[row][column] = 0;
						column++;
					}
					else{
						board[row][column] = 1;
						break;
					}
				}

				//backtracking
				row++;
				sum = 0;
				p = 0;
				if (row > 0){
					p = row - 1;
				}
				for (int i = 0; i < board[0].length; i++){
					sum += board[p][i];
				}
				if (sum == 0){
					if (row == 1){
						row -= 1; //check
					}
					else if (row > 1){
						row -= 2;
					}
					else{
						row = 0;
					}
					for (int f = 0; f < board[0].length; f++){
						if (row == -1){
							System.out.println("All solutions have been printed.");
							System.out.println("There are " + (w - 1) + " solutions.");
							System.exit(-1);
						}
						if (board[row][f] == 1){
							column = f + 1;
							board[row][f] = 0;
							f = board[0].length;
							if (column >= board[0].length){
								f = 0;
								row--;
							}
						}
						else{
							column = 0;
						}
					}
				}
				else{
					column = 0;
				}
			}

			row--;
			for (int s = 0; s < board[0].length; s++){
				if (board[row][s] == 1){
					column = s;
					s = board[0].length;
				}
			}

			System.out.println("");
			System.out.println("");

			System.out.println("Situation #" + w + ":");
			w++;
			for (int i = 0; i < board.length; i++){
				System.out.println("\n");
				for (int k = 0; k < board[0].length; k++){
					System.out.print("\t" + board[i][k]);
				}
			}
			System.out.println("");
			System.out.println("");

			board[row][column] = 0;
			column++;
		}
	}
}