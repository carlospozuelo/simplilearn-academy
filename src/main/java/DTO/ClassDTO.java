package DTO;

import java.time.LocalDateTime;

public class ClassDTO {

    private int id;
    private SubjectDTO subject;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ClassDTO() {}

    public ClassDTO(int id, SubjectDTO subject, String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.subject = subject;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
