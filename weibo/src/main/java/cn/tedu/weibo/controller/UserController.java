package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.UserMapper;
import cn.tedu.weibo.pojo.dto.UserLoginDto;
import cn.tedu.weibo.pojo.dto.UserRegDto;
import cn.tedu.weibo.pojo.entity.User;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;
    @RequestMapping("/reg")
    public int reg(@RequestBody UserRegDto userRegDto){
        //通过用户输入的用户名查询数据库里面的用户对象
        UserVO u = mapper.selectByUsername(userRegDto.getUsername());
        if (u!=null){
            return 2;//代表用户名已存在
        }
        User user = new User();
        //把dto里面的数据装进user
        BeanUtils.copyProperties(userRegDto,user);
        mapper.insert(user);
        return 1;//注册成功
    }

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDto userLoginDto, HttpSession session){
        UserVO user = mapper.selectByUsername(userLoginDto.getUsername());
        System.out.println(user.getPassword());
        if (user!=null){
            if (user.getPassword().equals(userLoginDto.getPassword())){
                //把当前登录成功的用户对象保存进会话对象里面
                session.setAttribute("user",user);
                return 1;//登录成功
            }
            return 2;//密码错误
        }
        return 3; //用户名不存在
    }
    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session){
        //从当前客户端对应的会话对象中取出登录成功时保存的用户对象
        return (UserVO) session.getAttribute("user");
    }
    @RequestMapping("/logout")
    public void logout(HttpSession session){
        //删除会话对象中的user
        session.removeAttribute("user");
    }
}
