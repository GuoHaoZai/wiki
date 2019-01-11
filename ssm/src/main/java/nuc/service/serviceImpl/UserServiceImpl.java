package nuc.service.serviceImpl;

import nuc.mapper.UserMapper;
import nuc.model.Uek_privilege_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    UserMapper userMapper;

    public boolean isExist(Uek_privilege_user uek_privilege_user){

        if(null != userMapper.isExist(uek_privilege_user)){
            return true;
        }
        return false;
    }

}
