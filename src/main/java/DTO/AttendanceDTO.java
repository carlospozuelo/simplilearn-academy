package DTO;

public class AttendanceDTO {

    private StudentDTO student;
    private ClassDTO classDto;

    public AttendanceDTO() {}

    public AttendanceDTO(StudentDTO student, ClassDTO classDto) {
        this.student = student;
        this.classDto = classDto;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public ClassDTO getClassDto() {
        return classDto;
    }

    public void setClassDto(ClassDTO classDto) {
        this.classDto = classDto;
    }
}