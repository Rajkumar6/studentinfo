package com.deepan.bmw.studentinfo.entity;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
public class StudentSubject {

    private Subject subject;
    private String professor;
    private Integer studentId;

    public StudentSubject(Subject subject, String professor, Integer studentId) {
        this.subject = subject;
        this.professor = professor;
        this.studentId = studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentSubject that = (StudentSubject) o;

        if (subject != that.subject) return false;
        if (professor != null ? !professor.equals(that.professor) : that.professor != null) return false;
        return !(studentId != null ? !studentId.equals(that.studentId) : that.studentId != null);

    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (professor != null ? professor.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "subject=" + subject +
                ", professor='" + professor + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
