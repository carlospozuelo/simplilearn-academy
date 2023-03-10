package DTO;

import java.time.LocalDate;

public class ExamDTO {

    private int id;
    private Integer grade;
    private LocalDate date;
    private EnrollmentDTO enrollment;

    public ExamDTO() {}

    public ExamDTO(int id, Integer grade, LocalDate date, EnrollmentDTO enrollment) {
        this.id = id;
        this.grade = grade;
        this.date = date;
        this.enrollment = enrollment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EnrollmentDTO getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(EnrollmentDTO enrollment) {
        this.enrollment = enrollment;
    }
}
