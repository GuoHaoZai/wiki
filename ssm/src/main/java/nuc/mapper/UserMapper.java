package nuc.mapper;

import nuc.model.Uek_privilege_user;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select(value = "select * from uek_privilege_user where username = #{username} and password = #{password} ")
    public Uek_privilege_user isExist(Uek_privilege_user uek_privilege_user);

}
