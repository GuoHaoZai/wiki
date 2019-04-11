package nuc.mapper;

import nuc.model.Knowledge;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeMapper {

    @Select(value = "select id,name " +
            "from nuc_uoe_knowledge " +
            "where topic_id=#{topic_id} ")
    public List<Knowledge> getKnowledgeByTopicId(int topic_id);

}
