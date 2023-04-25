package cn.tedu.boot10.mapper;

import cn.tedu.boot10.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student>selectByCid(int id);
    Student selectById(int id);
    int insert(Student student);
    int deleteById(int id);
    int deleteByIds(Integer[] ids);
    int update(Student student);
    int count();
    void deleteByCId(int id);
}
