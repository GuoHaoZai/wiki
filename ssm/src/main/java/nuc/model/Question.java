package nuc.model;

import java.util.Date;

public class Question {

    private int id;
    private String content;
    private String standard_answer;
    private String analysis;
    private String type;
    private int teacher_id;
    private Date entry_date;
    private String difficult_level;
    private int score;

    Option option;



    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", standard_answer='" + standard_answer + '\'' +
                ", analysis='" + analysis + '\'' +
                ", type='" + type + '\'' +
                ", teacher_id=" + teacher_id +
                ", entry_date=" + entry_date +
                ", difficult_level='" + difficult_level + '\'' +
                ", score=" + score +
                ", option=" + option +
                '}';
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStandard_answer() {
        return standard_answer;
    }

    public void setStandard_answer(String standard_answer) {
        this.standard_answer = standard_answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public String getDifficult_level() {
        return difficult_level;
    }

    public void setDifficult_level(String difficult_level) {
        this.difficult_level = difficult_level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}