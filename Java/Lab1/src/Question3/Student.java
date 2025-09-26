package Question3;

public abstract class Student {
 private int studentID;
 private String lastName;
 private double annualTuition;

 // Constructor
 public Student(int studentID, String lastName) {
     this.studentID = studentID;
     this.lastName = lastName;
 }

 // Getters and Setters
 public int getStudentID() {
     return studentID;
 }

 public void setStudentID(int studentID) {
     this.studentID = studentID;
 }

 public String getLastName() {
     return lastName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 public double getAnnualTuition() {
     return annualTuition;
 }

 protected void setAnnualTuition(double annualTuition) {
     this.annualTuition = annualTuition;
 }

 // Abstract method to set tuition
 public abstract void setTuition();

 // Display student info
 public void displayInfo() {
     System.out.printf("ID: %d | Name: %s | Tuition: $%.2f%n",
             studentID, lastName, annualTuition);
 }
}

