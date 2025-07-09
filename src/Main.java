import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class Main {
    
    private static final Scanner SCANNER = new Scanner(System.in); // Naming convention issue (should be lowercase)
    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {
        int User_Choice; // Naming convention issue (should be camelCase)
        do {
            printMenu();
            try {
                User_Choice = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Skip to next loop
            }

            switch (User_Choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (User_Choice != 5);
    }

    private static void printMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(SCANNER.nextLine());

            System.out.print("Enter Full Name: ");
            String name = SCANNER.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = Double.parseDouble(SCANNER.nextLine());

            Student student = new Student(id, name, gpa);
            studentService.addStudent(student);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            e.printStackTrace(); // Logging issue: should not print stack trace directly
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter full or partial name: ");
        String name = SCANNER.nextLine();
        List<Student> results = studentService.searchStudents(name);
        if (results.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Matches:");
            results.forEach(System.out::println);
        }
    }

    private static void displayAllStudents() {
        List<Student> all = studentService.getAllStudents();
        if (all.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.printf("%-10s %-50s %s\n", "ID", "Name", "GPA");
            all.forEach(System.out::println);
        }
    }

    
}
