package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.UserMapper;
import cn.tedu.coolshark.pojo.Dto.UserDto;
import cn.tedu.coolshark.pojo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;
    @RequestMapping("/login")
    public int login(@RequestBody UserDto userDto) {
        UserVo u = mapper.selectByUsername(userDto.getUsername());
        if (u!=null){
            if (u.getPassword().equals(userDto.getPassword())){
                return 1;
            }
            return 2;
        }
        return 3;
    }
}
