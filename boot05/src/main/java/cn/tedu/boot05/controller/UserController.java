package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import cn.tedu.boot05.maper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;
    @RequestMapping("/reg")
    public String reg(User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return "username exists";
        }
        mapper.insert(user);
        return "success";
    }
    @RequestMapping("/login")
    public String login(User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u==null){
            return "username not exists";
        }
        if (u.getPassword().equals(user.getPassword())){
            return "login success";
        }
        return "password error";
    }
}
