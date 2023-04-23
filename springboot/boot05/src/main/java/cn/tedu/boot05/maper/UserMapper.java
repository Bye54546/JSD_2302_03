package cn.tedu.boot05.maper;

import cn.tedu.boot05.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
//    返回值为对象时，会把查询结果封装到对象同名属性中
    @Select("select password from users where username=#{username}")
    User selectByUsername(String username);
    @Insert("insert into users values(null,#{username},#{password},#{nickname}")
    void insert(User user);
}
