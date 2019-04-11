package nuc.service;

import nuc.mapper.UserMapper;
import nuc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Object login(User user){
        User u = userMapper.getUser(user);
        if (u != null){
            if ("学生".equals(u.getStatus())){
                return userMapper.getStudent(u.getNumber());
            }else if ("教师".equals(u.getStatus())){
                return userMapper.getTeacher(u.getNumber());
            }
        }
        return null;
    }

}
