package nuc.model;

public class StudentPaper_Question {

    private int id;
    private Question question;
    private String answer;
    private boolean correctly;
    private int studentPaper_id;


    public StudentPaper_Question() {
    }

    @Override
    public String toString() {
        return "StudentPaper_Question{" +
                "id=" + id +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                ", correctly=" + correctly +
                ", studentPaper_id=" + studentPaper_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrectly() {
        return correctly;
    }

    public void setCorrectly(boolean correctly) {
        this.correctly = correctly;
    }

    public int getStudentPaper_id() {
        return studentPaper_id;
    }

    public void setStudentPaper_id(int studentPaper_id) {
        this.studentPaper_id = studentPaper_id;
    }
}
