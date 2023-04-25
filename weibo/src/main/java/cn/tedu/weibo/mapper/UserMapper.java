package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.User;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserVO selectByUsername(String username);
    int insert(User user);
}
