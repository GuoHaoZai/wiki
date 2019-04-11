package nuc.service;

import nuc.mapper.KnowledgeMapper;
import nuc.model.Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    public List<Knowledge> getKnowledgeByTopicId(int topic_id){
        return knowledgeMapper.getKnowledgeByTopicId(topic_id);
    }

}
