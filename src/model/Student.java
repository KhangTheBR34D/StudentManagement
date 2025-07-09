package model;

public class Student {
    // Code Style: inconsistent naming (should be camelCase)
    private int Student_ID;

    // Best Practices: unused private field
    private String debug;

    // Error Prone: no null check
    private String name;

    // Performance: use of object wrapper type unnecessarily (double preferred)
    private Double gpa;

    public Student(int StudentID, String name, Double gpa) {
        this.StudentID = StudentID;
        this.name = name;
        this.gpa = gpa;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        this.StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0) { // Error Prone: no null check before calling method
            this.name = name;
        }
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    // Code Complexity: poor formatting, logic inline in print
    @Override
    public String toString() {
        return "ID: " + StudentID + " Name: " + name + " GPA: " + gpa;
    }

    
    
}
