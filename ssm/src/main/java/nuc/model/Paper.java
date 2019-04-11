package nuc.model;

import java.util.Date;
import java.util.List;

public class Paper {

    private int id;
    private String name;
    private Date create_time;
    private int teacher_id;
    private int course_id;
    private int total_score;
    private String status;
    private String difficult_level;
    private int topic_id;

    private List<Question> questions;

    public Paper() {
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_time=" + create_time +
                ", teacher_id=" + teacher_id +
                ", course_id=" + course_id +
                ", total_score=" + total_score +
                ", status='" + status + '\'' +
                ", difficult_level='" + difficult_level + '\'' +
                ", topic_id=" + topic_id +
                ", questions=" + questions +
                '}';
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDifficult_level() {
        return difficult_level;
    }

    public void setDifficult_level(String difficult_level) {
        this.difficult_level = difficult_level;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }
}