package nuc.mapper;

import nuc.model.Question;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionMapper {

    /*根据 难度，章节id，问题类型 随机查找指定个数的题目*/
    @Select(value = "select nuc_uoe_question.id,content " +
            "from nuc_uoe_question,question_topic " +
            "where question_topic.question_id = nuc_uoe_question.id " +
            "   and nuc_uoe_question.difficult_level = #{0}" +
            "   and question_topic.topic_id = #{1} " +
            "   and nuc_uoe_question.type = #{2} " +
            "order by rand() limit #{3}")
    public List<Question> getQuestions(String difficult_level, int topic_id, String question_type, int num);

    /*期末*/
    @Select(value = "select nuc_uoe_question.id,nuc_uoe_question.content " +
            "from nuc_uoe_topic, question_topic, nuc_uoe_question " +
            "where nuc_uoe_topic.course_id = #{0} " +
            "   and question_topic.topic_id = nuc_uoe_topic.id " +
            "   and question_topic.question_id = nuc_uoe_question.id " +
            "   and nuc_uoe_question.type = #{1} " +
            "   order by rand() limit #{2}")
    public List<Question> getQuestionsByCourseId(int course_id,String question_type, int num);

    @Select(value = "select * from nuc_uoe_question where id=#{question_id}")
    public Question getQuestionById(int question_id);

    @Select(value = "select nuc_uoe_question.id,content,type " +
            "from nuc_uoe_question,question_knowledge,nuc_uoe_knowledge " +
            "where nuc_uoe_knowledge.topic_id = #{0}" +
            "   and nuc_uoe_knowledge.id = #{1}" +
            "   and nuc_uoe_knowledge.id = question_knowledge.knowledge_id"+
            "   and question_knowledge.question_id = nuc_uoe_question.id ")
    public List<Question> getQuestionByTopicANDKnowledge(int topic_id,int knowledge_id);

}
