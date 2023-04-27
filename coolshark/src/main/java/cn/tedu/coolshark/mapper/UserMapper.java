package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserVo selectByUsername(String username);
}
