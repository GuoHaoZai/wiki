package nuc.mapper;

import nuc.model.Option;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionMapper {

    @Select(value = "select * from nuc_uoe_option where question_id = #{question_id}  ")
    public Option getOptions(int question_id);
}
