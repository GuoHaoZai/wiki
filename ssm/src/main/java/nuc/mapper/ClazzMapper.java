package nuc.mapper;

import nuc.model.Clazz;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClazzMapper {

    @Select(value = "select * from nuc_uoe_clazz")
    public List<Clazz> getAllClazz();

}