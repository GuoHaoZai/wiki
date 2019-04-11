package nuc.mapper;

import nuc.model.Student;
import nuc.model.Teacher;
import nuc.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select(value = "select * from nuc_uoe_user where number=#{number} and password=#{password} ")
    public User getUser(User user);

    @Select(value = "select * from nuc_uoe_teacher where number=#{number}")
    public Teacher getTeacher(String number);


    @Select(value = "select * from nuc_uoe_student where number=#{number}")
    public Student getStudent(String number);

}
