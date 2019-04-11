package nuc.model;

import java.util.Date;
import java.util.List;

public class Student_paper {

    private int id;
    private Student student;
    private Paper paper;
    private int score;
    private Date date;

    private List<StudentPaper_Question> studentPaper_questions;

    public Student_paper() {
    }

    @Override
    public String toString() {
        return "Student_paper{" +
                "id=" + id +
                ", student=" + student +
                ", paper=" + paper +
                ", score=" + score +
                ", date=" + date +
                '}';
    }

    public List<StudentPaper_Question> getStudentPaper_questions() {
        return studentPaper_questions;
    }

    public void setStudentPaper_questions(List<StudentPaper_Question> studentPaper_questions) {
        this.studentPaper_questions = studentPaper_questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
