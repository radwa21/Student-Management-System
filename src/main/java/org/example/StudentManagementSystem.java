package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addStudent() {
        System.out.print("\nEnter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, age, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private void displayAllStudents() {
        System.out.println("\nAll Students:");
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Age: " + student.getAge());
                System.out.println("Grade: " + student.getGrade());
                System.out.println();
            }
        }
    }

    private void searchStudent() {
        System.out.print("\nEnter roll number to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("\nStudent found:");
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Age: " + student.getAge());
                System.out.println("Grade: " + student.getGrade());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private void updateStudent() {
        System.out.print("\nEnter roll number to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
//        Student student = new Student();

        boolean found = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                student.setAge(newAge);
                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    private void deleteStudent() {
        System.out.print("\nEnter roll number to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }
}
