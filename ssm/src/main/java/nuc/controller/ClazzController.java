package nuc.controller;

import nuc.model.Clazz;
import nuc.model.PO;
import nuc.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping(value = "/class")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @RequestMapping(value = "/getClass")
    public PO getClazz(){
        PO po = new PO();
        po.setStatus(200);
        Clazz clazz = new Clazz();
        clazz.setId(0);
        clazz.setName("全部");
        List<Clazz> classes = clazzService.getAllClazz();
        classes.add(0,clazz );
        po.setObject(classes);
        po.setMessage("已经返回所有班级信息");
        return po;
    }
}
