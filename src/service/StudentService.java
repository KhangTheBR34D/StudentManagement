package service;
import model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {
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

   
}
