package nuc.service;

import nuc.mapper.TopicMapper;
import nuc.model.Course;
import nuc.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicMapper topicMapper;

    public List<Topic> getTopicByCourseId(Course course){
        return topicMapper.getTopicByCourseId(course.getId());
    }

}
