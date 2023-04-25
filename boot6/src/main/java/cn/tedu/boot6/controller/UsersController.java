package cn.tedu.boot6.controller;

import cn.tedu.boot6.entity.Users;
import cn.tedu.boot6.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    UsersMapper mapper;
    @RequestMapping("/reg")
    public String reg(@RequestBody Users user) {
        Users u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            return "2";
        }
        mapper.insert(user);
        return "ok";
    }
@RequestMapping("/login")
    public String login(@RequestBody Users user) {
    System.out.println(1);
        Users u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return "ok";
            }
            return "2";
        }
        return "1";
    }
}
