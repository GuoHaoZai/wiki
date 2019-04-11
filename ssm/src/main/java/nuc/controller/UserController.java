package nuc.controller;

import nuc.model.PO;
import nuc.model.User;
import nuc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@ResponseBody
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public PO login(@RequestBody User user, HttpSession session){
        PO po = new PO();
        Object o = userService.login(user);
        if (o == null){
            po.setStatus(300);
            po.setMessage("该用户不存在");
        }else{
            session.setAttribute("user",o );
            po.setObject(o);
            po.setStatus(200);
            po.setMessage("ok");
        }
        return po;
    }

}
