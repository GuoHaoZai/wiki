package nuc.controller;

import nuc.model.*;
import nuc.service.PaperService;
import nuc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping(value = "/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private QuestionService questionService;

    /**
     * 自动组卷
     * @param paper
     * @param session
     * @return
     */
    @RequestMapping(value = "/autoGroupPaper")
    public PO autoGroupPaper(@RequestBody Paper paper, HttpSession session){
        Paper temporaryPaper = null;
        System.out.println(paper);
//        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (paper.getDifficult_level().equals("0")){
            paper.setName("期末组卷");
            temporaryPaper = paperService.autoGroupPaper(paper.getDifficult_level(),paper.getCourse_id(),paper.getName());
        }else{
            temporaryPaper = paperService.autoGroupPaper(paper.getDifficult_level(),paper.getTopic_id(), paper.getName());
        }
        temporaryPaper.setDifficult_level(paper.getDifficult_level());
        temporaryPaper.setTopic_id(paper.getTopic_id());
        temporaryPaper.setCourse_id(paper.getCourse_id());

        PO po = new PO();
        po.setMessage("paper返回成功");
        po.setStatus(200);
        po.setObject(temporaryPaper);
        session.setAttribute("temporaryPaper",temporaryPaper);
        return po;
    }

    /**
     * 确认组卷
     * @param paper
     * @param session
     * @return
     */
    @RequestMapping(value = "/confirmPaper")
    public PO confirmPaper(@RequestBody Paper paper,HttpSession session){
        PO po = new PO();
        po.setStatus(200);
        po.setObject(paperService.addPaper(paper));
        po.setMessage("成功保存");
        return po;
    }

    @RequestMapping(value = "/getPaperByCourse")
    public PO getPaperByCourse(@RequestBody Course course){
        List<Paper> papers = paperService.getPaperByCourse(course);
        PO po = new PO();
        po.setObject(papers);
        po.setStatus(200);
        return po;
    }

    @RequestMapping(value = "/distribute")
    public PO distribute(@RequestBody Clazz_Paper clazz_paper){
        System.out.println(clazz_paper);
        PO po = new PO();
        po.setStatus(200);
        po.setMessage("ok");
        po.setObject(paperService.addClazz_Paper(clazz_paper));
        return po;
    }

    @RequestMapping(value = "/getQuestions")
    public PO getQuestions(@RequestBody Knowledge knowledge){
        PO po = new PO();
        knowledge.setQuestions(questionService.getQuestionByTopicAndKnowledge(knowledge.getTopic_id(),knowledge.getId()));
        po.setObject(knowledge);
        po.setStatus(200);
        return po;
    }
}
