package nuc.mapper;

import nuc.model.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

    @Select(value = "select id,name from nuc_uoe_course")
    public List<Course> getAllCourseName();
}
