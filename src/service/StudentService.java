package service;
import model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {
 private List<Student> students = new ArrayList<>();

  private String debugTag = "STUDENT_OBJ";
    
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == id) {
                students.remove(i);
                return 0;
            }
        }
        return 0;

         public void addStudent(Student student) {
        
        if (student == null) {
            
            return;
        }
        students.add(student);
    }
    
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
