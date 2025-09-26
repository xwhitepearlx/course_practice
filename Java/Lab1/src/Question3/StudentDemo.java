package Question3;

public class StudentDemo {
    public static void main(String[] args) {
        // Create an array of 6 students
        Student[] students = new Student[6];

        students[0] = new UndergraduateStudent(101, "Smith");
        students[1] = new UndergraduateStudent(102, "Johnson");
        students[2] = new GraduateStudent(201, "Williams");
        students[3] = new GraduateStudent(202, "Brown");
        students[4] = new StudentAtLarge(301, "Jones");
        students[5] = new StudentAtLarge(302, "Garcia");

        // Display all students
        System.out.println("Parker University Student Records:");
        for (Student s : students) {
            s.displayInfo();
        }
    }
}