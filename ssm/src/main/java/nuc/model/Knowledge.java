package nuc.model;

import java.util.List;

public class Knowledge {
    private int id;
    private int topic_id;
    private String name;
    private String introduce;

    private List<Question> questions;
    public Knowledge() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topic_id=" + topic_id +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
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

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}