package nuc.service;

import nuc.mapper.PaperMapper;
import nuc.model.Clazz_Paper;
import nuc.model.Course;
import nuc.model.Paper;
import nuc.model.Question;
import nuc.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperService {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;


    @Autowired
    private PaperMapper paperMapper;

    public Paper autoGroupPaper(String difficulty_level, int topic_idORCourse_id, String name){
        Paper paper = new Paper();
        paper.setName(name);
        paper.setCreate_time(new Date());

        List<Question> questions = new LinkedList<>();
        List<Question> select = questionService.getQuestions(difficulty_level, topic_idORCourse_id, Constant.SELECT_TYPE, Constant.SELECT);
        Iterator<Question> iterator = select.iterator();
        while (iterator.hasNext()){
            Question question = iterator.next();
            question.setOption(optionService.getOptions(question));
        }
        questions.addAll(select);
        questions.addAll(questionService.getQuestions(difficulty_level, topic_idORCourse_id, Constant.EXERCISE_TYPE, Constant.EXERCISE));
        questions.addAll(questionService.getQuestions(difficulty_level, topic_idORCourse_id, Constant.SHORT_ANSWER_TYPE, Constant.SHORT_ANSWER));
        questions.addAll(questionService.getQuestions(difficulty_level, topic_idORCourse_id, Constant.CODE_TYPE, Constant.CODE));

        paper.setStatus("0");
        paper.setTotal_score(Constant.TOTAL_SCORE);
        paper.setQuestions(questions);
        return paper;
    }

    public List<Paper> getPaperByCourse(Course course){
        return paperMapper.getPaperByCourse(course.getId());
    };


    public Paper autoEndPaper(String difficulty_level, int topic_id){
        Paper paper = new Paper();
        paper.setTotal_score(Constant.TOTAL_SCORE);
        paper.setCreate_time(new Date());
        paper.setStatus("0");

        List<Question> questions = new LinkedList<>();
        List<Question> select = questionService.getQuestions("", topic_id, Constant.SELECT_TYPE, Constant.SELECT);
        Iterator<Question> iterator = select.iterator();
        while (iterator.hasNext()){
            Question question = iterator.next();
            question.setOption(optionService.getOptions(question));
        }
        questions.addAll(select);
        questions.addAll(questionService.getQuestions(difficulty_level, topic_id, Constant.EXERCISE_TYPE, Constant.EXERCISE));
        questions.addAll(questionService.getQuestions(difficulty_level, topic_id, Constant.SHORT_ANSWER_TYPE, Constant.SHORT_ANSWER));
        questions.addAll(questionService.getQuestions(difficulty_level, topic_id, Constant.CODE_TYPE, Constant.CODE));

        paper.setQuestions(questions);
        return paper;
    }

    public int addPaper(Paper paper){
        paper.setCreate_time(new Date());
        paper.setStatus("0");
        paperMapper.addPaper(paper);

        int total_score = 0;
        if ("".equals(paper.getCreate_time())){
            paper.setTotal_score(Constant.TOTAL_SCORE);
            paper.setCreate_time(new Date());
            paper.setStatus("0");
        }

        Iterator<Question> iterator = paper.getQuestions().iterator();
        while (iterator.hasNext()){
            Question question = iterator.next();
            String type = questionService.getQuestionById(question.getId()).getType();
            int score = Constant.scoreFactory(type);
            total_score += score;
            paperMapper.addPaper_Question(paper.getId(), question.getId(),score);
        }

        paper.setTotal_score(total_score);
        this.updateScore(paper);

        return paper.getId();
    }


    public List addClazz_Paper(Clazz_Paper clazz_paper){
        System.out.println(clazz_paper);
        List<Integer> clas = new LinkedList<>();
        for (int id :clazz_paper.getClazz_ids()) {
            clazz_paper.setClazz_id(id);
            if (getClazz_paper(clazz_paper) == 0){
                paperMapper.addClazz_Paper(clazz_paper);
            }else{
                clas.add(clazz_paper.getClazz_id());
            }
        }
        return clas;
    }

    public int getClazz_paper(Clazz_Paper clazz_paper){
        return paperMapper.getClazz_paper(clazz_paper);
    }

    public int updateScore(Paper paper){
        return paperMapper.updateScore(paper.getTotal_score(), paper.getId());
    }

}
