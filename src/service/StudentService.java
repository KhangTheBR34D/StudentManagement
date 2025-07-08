package service;
import model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {
 private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == student.getStudentID()) {
                throw new IllegalArgumentException("Duplicate student ID.");
            }
        }
        students.add(student);
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Student> searchStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(students.get(i));
            }
        }
        return result;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
