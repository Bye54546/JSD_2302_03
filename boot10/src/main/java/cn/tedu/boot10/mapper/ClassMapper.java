package cn.tedu.boot10.mapper;

import cn.tedu.boot10.entity.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {
    List<Class> select();
    Class selectById(int id);
    int insert(Class c);
    int deleteById(int id);
    int deleteByIds(Integer[] ids);
    int update(Class c);
    int count();
}

