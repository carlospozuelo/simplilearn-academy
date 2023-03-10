package DTO;

public class StudentDTO {
    private int studentId;
    private String studentName;
    private String studentEmail;

    public StudentDTO() {
    	setStudentName("");
    	setStudentEmail("");
    }

    public StudentDTO(int studentId, String studentName, String studentEmail) {
        setStudentId(studentId);
        setStudentName(studentName);
        setStudentEmail(studentEmail);
    }
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}