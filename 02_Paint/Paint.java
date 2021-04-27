import java.util.Scanner;

public class Paint {
	
	// Project specifications
	final static String PROJECT = "Project 02 - Painting a Room";
	final static String AUTHOR = "Linkai Wu";
	
	final static String TITLE = 
			"______     _       _   _                      ______                      \n"+
			"| ___ \\   (_)     | | (_)                     | ___ \\                     \n"+
			"| |_/ /_ _ _ _ __ | |_ _ _ __   __ _    __ _  | |_/ /___   ___  _ __ ___  \n"+
			"|  __/ _` | | '_ \\| __| | '_ \\ / _` |  / _` | |    // _ \\ / _ \\| '_ ` _ \\ \n"+
			"| | | (_| | | | | | |_| | | | | (_| | | (_| | | |\\ \\ (_) | (_) | | | | | |\n"+
			"\\_|  \\__,_|_|_| |_|\\__|_|_| |_|\\__, |  \\__,_| \\_| \\_\\___/ \\___/|_| |_| |_|\n"+
			"                                __/ |                                     \n"+
			"                               |___/                                      \n";
	
	final static int COVERAGE = 350;  //paint covers 350 sq ft/gal
	final static int WINDOW_AREA = 15; // in square ft
	final static int DOOR_AREA = 20; // in square ft
	static double length, width, height; // in ft
	static int numDoors, numWindows;
	static double totalArea; // in square ft
	static double paintNeeded; // in gallons

	public static void main(String[] args) {
		System.out.println(String.format("%s\nby %s\n", PROJECT, AUTHOR));
		System.out.println(TITLE);
		
		
		Scanner specsScanner = new Scanner(System.in);

		System.out.println("Room Specs:");
		
		System.out.print("(length) ");
		length = specsScanner.nextDouble();

		System.out.print("(width) ");
		width = specsScanner.nextDouble();
		
		System.out.print("(height) ");
		height = specsScanner.nextDouble();
		
		System.out.print("(# of doors) ");
		numDoors = specsScanner.nextInt();
		
		System.out.print("(# of windows) ");
		numWindows = specsScanner.nextInt();
		
		specsScanner.close();
		
		totalArea = calculateArea(length, width, height, numDoors, numWindows);
		
		paintNeeded = calculatePaintNeeded(totalArea);
		
		System.out.println("\n--------------------");
		System.out.println(String.format("LENGTH x WIDTH x HEIGHT\n%s x %s x %s\n", length, width, height));
		System.out.println(String.format("# of DOORS (%s sq ft each)\n%s\n", DOOR_AREA, numDoors));
		System.out.println(String.format("# of WINDOWS (%s sq ft each)\n%s\n", WINDOW_AREA, numWindows));
		System.out.println(String.format("GALLONS OF PAINT NEEDED: %s", paintNeeded));
		System.out.println("--------------------");

        //Print the length, width, and height of the room and the
        //number of gallons of paint needed.

	}
	
	public static double calculateArea(double length, double width, double height, int numDoors, int numWindows) {
		double area = height*width*2 + height*length*2;
		area -= numDoors*DOOR_AREA;
		area -= numWindows*WINDOW_AREA;
		
		return area;
	}
	
	public static double calculatePaintNeeded(double area) {
		return Math.ceil(area/COVERAGE);
	}

}
