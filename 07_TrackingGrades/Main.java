// ****************************************************************
//   Grades.java
//
//   Use Student class to get test grades for two students
//   and compute averages
//      
// ****************************************************************
public class Main {
  public static void main(String[] args) {
    Student student1 = new Student("Mary");
    //create student2, "Mike"
    Student student2 = new Student("Mike");

    //input grades for Mary
    student1.inputGrades();
    //print average for Mary
    System.out.println("The average grade for " + student1.name + " is " + student1.getAverage());

    System.out.println();

    //input grades for Mike
    student2.inputGrades();
    //print average for Mike
    System.out.println("The average grade for " + student2.name + " is " + student2.getAverage());

    System.out.println();
    
    System.out.println("Student 1: " + student1.toString());
    System.out.println("Student 2: " + student2.toString());
  }
}
