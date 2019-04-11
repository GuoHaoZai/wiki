package nuc.service;

import nuc.mapper.OptionMapper;
import nuc.mapper.QuestionMapper;
import nuc.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private OptionMapper optionMapper;

    public List<Question> getQuestions(String difficulty_level, int topic_idOrCourse_id, String question_type, int num){
        if(difficulty_level.equals("0")){
            return questionMapper.getQuestionsByCourseId(topic_idOrCourse_id, question_type, num);
        }else{
            return questionMapper.getQuestions(difficulty_level,topic_idOrCourse_id , question_type, num);
        }
    };

    public Question getQuestionById(int question_id){
        return questionMapper.getQuestionById(question_id);
    }

    public List<Question> getQuestionByTopicAndKnowledge(int topic_id, int knowledge_id ){
        List<Question> questions = questionMapper.getQuestionByTopicANDKnowledge(topic_id, knowledge_id);
        Iterator<Question> questionIterator = questions.iterator();
        while(questionIterator.hasNext()){
            Question question = questionIterator.next();
            if ("选择题".equals(question.getType())){
                question.setOption(optionMapper.getOptions(question.getId()));
            }
        }
        return questions;
    }


}
