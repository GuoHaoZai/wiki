package nuc.mapper;

import nuc.model.Clazz_Paper;
import nuc.model.Paper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperMapper {

    /*添加试卷 返回id*/
    public int addPaper(Paper paper);

    @Select(value = "select id,name from nuc_uoe_paper where course_id = #{0} ")
    public List<Paper> getPaperByCourse(int course_id);

    //  试卷和问题关联表
    @Insert(value = "insert into paper_question(paper_id, question_id,score) values (#{0} ,#{1}, #{2})")
    public int addPaper_Question(int paper_id, int question_id, int score);

    @Insert(value = "insert into clazz_paper(paper_id, clazz_id, start_date, end_date) " +
            "VALUES (#{paper_id} ,#{clazz_id},#{start_date} ,#{end_date})")
    public int addClazz_Paper(Clazz_Paper clazz_paper);

    @Select(value = "select count(*) from clazz_paper where paper_id=#{paper_id} and clazz_id=#{clazz_id}")
    public int getClazz_paper(Clazz_Paper clazz_paper);

    @Update(value = "update nuc_uoe_paper set total_score = #{0} where id=#{1}" )
    public int updateScore(int total_score, int paper_id);

}
