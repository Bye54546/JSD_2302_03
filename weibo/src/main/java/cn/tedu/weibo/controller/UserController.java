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
    public int reg(@RequestBody UserRegDto udto) {
        UserVO u = mapper.selectByUsername(udto.getUsername());
        if(u!=null){
            return 2;
        }
        User user = new User();
//        把dto里面的数据装进user
        BeanUtils.copyProperties(udto,user);
        mapper.insert(user);
        return 1;
    }

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDto uldto, HttpSession hs) {
        UserVO user =mapper.selectByUsername(uldto.getUsername());
        if (user != null) {
            if (user.getPassword().equals(uldto.getPassword()))
            {
                hs.setAttribute("user",user);

                return 1;
            }
            return 2;
        }
        return 3;
    }

    @RequestMapping("/currentUser")
    public UserVO currentUser(HttpSession session) {
//        从当前客户端对应的会话对象中取出登陆成功时保存的用户对象
        return (UserVO) session.getAttribute("user");
    }
    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }
}
