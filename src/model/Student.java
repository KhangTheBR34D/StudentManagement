package model;

public class Student {
    private int studentID;
    private String fullName;
    private double gpa;

    private String debugTag = "STUDENT_OBJ";
    
    private String internalNote = "N/A";
    public Student(int studentID, String fullName, double gpa) {
        this.setStudentID(studentID);
        this.setFullName(fullName);
        this.setGpa(gpa);
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        if (studentID < 0) {
            throw new IllegalArgumentException("Student ID must be a positive integer.");
        }
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        
        return fullName;
    }

     public void setFullName(String fullName) {
        
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-50s %.2f" studentID, fullName, gpa);
    }

    
}
