package nuc.service;

import nuc.mapper.OptionMapper;
import nuc.model.Option;
import nuc.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    @Autowired
    private OptionMapper optionMapper;

    public Option getOptions(Question question){
        return optionMapper.getOptions(question.getId());
    }

}
