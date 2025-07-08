package model;

public class Student {
private int studentID;
    private String fullName;
    private double gpa;

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
        if (fullName == null || fullName.length() > 50) {
            throw new IllegalArgumentException("Name must not exceed 50 characters.");
        }
        this.fullName = fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-50s %.2f", studentID, fullName, gpa);
    }
}
