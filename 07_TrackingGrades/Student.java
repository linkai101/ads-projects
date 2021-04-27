// ****************************************************************
//   Student.java
//
//   Define a student class that stores name, score on test 1, and
//   score on test 2.  Methods prompt for and read in grades, 
//   compute the average, and return a string containing student’s info. 
// ****************************************************************
import java.util.Scanner;

public class Student {
  //declare instance data 
  String name;
  double test1;
  double test2;

  //-----------------------------------------------
  //constructor
  //-----------------------------------------------
  public Student(String studentName) {
	  //add body of constructor
    this.name = studentName;
  }

  //-----------------------------------------------
  //inputGrades: prompt for and read in student's grades for test1 and test2.
  //Use name in prompts, e.g., "Enter's Joe's score for test1".

  //-----------------------------------------------
  public void inputGrades() {
	  //add body of inputGrades
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter "+this.name+"'s grade for test 1: ");
    this.test1 = sc.nextDouble();

    System.out.println("Enter " + this.name+ "'s grade for test 2: ");
    this.test2 = sc.nextDouble();
  }

  //-----------------------------------------------
  //getAverage: compute and return the student's test average
  //-----------------------------------------------

  //add header for getAverage
  public double getAverage() {
	  //add body of getAverage
    return (this.test1+this.test2)/2;
  }

  //-----------------------------------------------
  //getName: print the student's name
  //-----------------------------------------------

  //add header for printName
  public void getName() {
	  //add body of printName
    System.out.println(this.name);
  }

  public String toString() {
    return "Name: "+this.name+" Test1: "+this.test1+" Test2: "+this.test2;
  }

}
