package nuc.controller;

import nuc.model.PO;
import nuc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/getCourse")
    public PO getCourse(){
        PO po = new PO();
        po.setStatus(200);
        po.setObject(courseService.getAllCourse());
        po.setMessage("已经返回所有课程信息");
        return po;
    }




}
