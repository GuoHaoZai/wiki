package nuc.controller;

import nuc.model.Course;
import nuc.model.PO;
import nuc.model.Topic;
import nuc.service.KnowledgeService;
import nuc.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private KnowledgeService knowledgeService;

    @RequestMapping(value = "/getTopic")
    public PO getTopic(@RequestBody Course course){
        PO po = new PO();
        po.setStatus(200);
        po.setObject(topicService.getTopicByCourseId(course));
        po.setMessage("已经返回所有主题信息");
        return po;
    }

    @RequestMapping(value = "/getKnowledge")
    public PO getKnowledge(@RequestBody Course course){
        PO po = new PO();
        po.setStatus(200);
        List<Topic> topics =  topicService.getTopicByCourseId(course);
        Iterator<Topic> topicIterator = topics.iterator();
        while (topicIterator.hasNext()){
            Topic topic = topicIterator.next();
            topic.setKnowledges(knowledgeService.getKnowledgeByTopicId(topic.getId()));
        }
        po.setObject(topics);
        po.setMessage("已经返回信息");
        return po;
    }

}
