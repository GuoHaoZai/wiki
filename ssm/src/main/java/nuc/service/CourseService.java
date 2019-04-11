package nuc.service;

import nuc.mapper.CourseMapper;
import nuc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> getAllCourse(){
        return courseMapper.getAllCourseName();
    }

}
