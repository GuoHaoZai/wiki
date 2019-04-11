package nuc.service;

import nuc.mapper.ClazzMapper;
import nuc.model.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    public List<Clazz> getAllClazz(){
        return clazzMapper.getAllClazz();
    }

}
