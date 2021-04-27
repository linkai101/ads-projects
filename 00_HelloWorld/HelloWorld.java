import java.util.Scanner;

public class HelloWorld {
	// ADSA Project 00 - Hello World
	// Linkai Wu
	
	
	// Project specifications
	final static String PROJECT = "Project 00 - Hello World";
	final static String AUTHOR = "Linkai Wu";

	public static void main(String[] args) {
		System.out.println(String.format("%s\nby %s\n", PROJECT, AUTHOR));
		
		// Hello World!
		String helloWorld = 
				" _   _      _ _         _    _            _     _ \n"+
				"| | | |    | | |       | |  | |          | |   | |\n"+
				"| |_| | ___| | | ___   | |  | | ___  _ __| | __| |\n"+
				"|  _  |/ _ \\ | |/ _ \\  | |/\\| |/ _ \\| '__| |/ _` |\n"+
				"| | | |  __/ | | (_) | \\  /\\  / (_) | |  | | (_| |\n"+
				"\\_| |_/\\___|_|_|\\___/   \\/  \\/ \\___/|_|  |_|\\__,_|\n";
		System.out.println(helloWorld);
		
		Scanner in = new Scanner(System.in); // Declaring scanner
		
		// Getting name of user via scanner
		System.out.println("What is your name?"); 
		String name = in.nextLine();
		
		in.close();
		
		System.out.println(greet(name)); // Greet user
	}
	
	// Sends a greeting to a user
	public static String greet(String name) {
		String helloWorldText = String.format("Hello, %s!", name);
		return helloWorldText;
	}

}
