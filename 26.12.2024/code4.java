import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
}

public class GradeAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        Student[] students = new Student[numStudents];
        double totalGrades = 0;

        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine(); // Consume the newline
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();

            students[i] = new Student(name, grade);
            totalGrades += grade;
        }

        double average = totalGrades / numStudents;

        System.out.println("\nAverage Grade: " + average);
    }
}
