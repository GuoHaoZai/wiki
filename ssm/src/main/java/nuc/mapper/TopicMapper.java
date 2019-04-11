package nuc.mapper;

import nuc.model.Topic;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicMapper {

    @Select(value = "select id,name " +
            "from nuc_uoe_topic " +
            "where course_id=#{course_id} ")
    public List<Topic> getTopicByCourseId(int course_id);




}
