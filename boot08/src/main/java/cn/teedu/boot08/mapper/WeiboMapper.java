package cn.teedu.boot08.mapper;

import cn.teedu.boot08.entity.Weibo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface WeiboMapper {
    @Insert("INSERT INTO weibo VALUES(NULL,#{content},#{url})")
    void insert(Weibo weibo);
    @Select("SELECT * FROM weibo")
    List<Weibo> select();
    @Delete("DELETE FROM weibo WHERE id=#{id}")
    void deleteById(Integer id);
    @Select("SELECT url FROM weibo WHERE id=#{id}")
    String selectById(Integer id);
}
