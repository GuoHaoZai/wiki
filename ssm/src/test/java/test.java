import nuc.mapper.KnowledgeMapper;
import nuc.mapper.QuestionMapper;
import nuc.mapper.UserMapper;
import nuc.model.Paper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void test2(){
        Paper paper = new Paper();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        KnowledgeMapper mapper = (KnowledgeMapper) applicationContext.getBean("knowledgeMapper");
        System.out.println(mapper.getKnowledgeByTopicId(1));
        System.out.println(paper);
    }

    @Test
    public void test1(){
        Paper paper = new Paper();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        UserMapper mapper = (UserMapper) applicationContext.getBean("userMapper");
        System.out.println(mapper.getStudent("1"));
        System.out.println(paper);
    }

    @Test
    public void test3(){
        Paper paper = new Paper();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        QuestionMapper mapper = (QuestionMapper) applicationContext.getBean("questionMapper");
        System.out.println(mapper.getQuestionByTopicANDKnowledge(4,8));
    }
}
