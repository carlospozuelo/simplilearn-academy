package DTO;

public class TeacherDTO {
    private int teacherId;
    private String teacherName;
    private String teacherEmail;

    public TeacherDTO() {}

    public TeacherDTO(int teacherId, String teacherName, String teacherEmail) {
        setTeacherId(teacherId);
        setTeacherName(teacherName);
        setTeacherEmail(teacherEmail);
    }
    
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
    	this.teacherEmail = teacherEmail;
    }
}