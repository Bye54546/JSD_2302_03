package cn.tedu.boot6.mapper;

import cn.tedu.boot6.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UsersMapper {
    @Select("select password from users where username=#{username}")
    Users selectByUsername(String username);
    @Insert("insert into users values(null,#{username},#{password},#{nickname})")
    int insert(Users user);
}
