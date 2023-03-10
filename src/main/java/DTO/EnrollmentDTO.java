package DTO;

public class EnrollmentDTO {

    private int id;
    private StudentDTO student;
    private SubjectDTO subjectDTO;

    public EnrollmentDTO() {}

    public EnrollmentDTO(int id, StudentDTO student, SubjectDTO subjectDTO) {
        this.id = id;
        this.student = student;
        this.subjectDTO = subjectDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public SubjectDTO getClassDTO() {
        return subjectDTO;
    }

    public void setClassDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }
}
