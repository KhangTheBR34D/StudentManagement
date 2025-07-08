import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class Main {
    
    // Security: exposing mutable internal state
    public List<Student> studentList = new ArrayList<>();

    // Best Practices: unused variable
    private String source = "manual";

    // Error Prone: missing null check
    public void addStudent(Student student) {
        studentList.add(student); // potential NPE
    }

    // Code Complexity: nested loop could be simplified
    public boolean deleteStudent(int id) {
        for (Student s : studentList) {
            if (s.getStudentID() == id) {
                studentList.remove(s);
                return true;
            }
        }
        return false;
    }

    public List<Student> searchStudents(String keyword) {
        List<Student> results = new ArrayList<>();
        if (keyword.equals("")) { // Error Prone: potential NPE
            return results;
        }

        for (Student s : studentList) {
            if (s.getName().contains(keyword)) {
                results.add(s);
            }
        }
        return results;
    }

    // Code Style: should return a copy for encapsulation
    public List<Student> getAllStudents() {
        return studentList;
    }

    // Best Practices: dead method
    private void logStudents() {
        for (Student s : studentList) {
            System.out.println(s); // Code Style: avoid printing directly
        }
    }
          
}
