package nuc.controller;

import nuc.model.Uek_privilege_user;
import nuc.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "login",method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody int login(@RequestBody Uek_privilege_user uek_privilege_user, HttpServletRequest request){
        if(userService.isExist(uek_privilege_user)){
            request.getSession().setAttribute("username", uek_privilege_user.getUsername());
            return 1;
        }else{
            return 0;
        }
    }
}
