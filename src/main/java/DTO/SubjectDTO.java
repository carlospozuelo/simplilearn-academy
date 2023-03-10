package DTO;

public class SubjectDTO {
    private int subjectId;
    private String subjectName;
    private Integer credits;
    
    public SubjectDTO() {}

    public SubjectDTO(int subjectId, String subjectName, Integer credits) {
        setSubjectId(subjectId);
        setSubjectName(subjectName);
        setCredits(credits);
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}