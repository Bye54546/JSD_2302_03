package cn.tedu.boot10;

import cn.tedu.boot10.mapper.ClassMapper;
import cn.tedu.boot10.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import cn.tedu.boot10.entity.Class;
@SpringBootTest
class Boot10ApplicationTests {
@Autowired
    ClassMapper mapper;
    StudentMapper sMapper;
    @Test
    void contextLoads() {
        Class c = new Class();
        c.setTeacherName("王大锤");
        c.setGradeLevel("四年级");
        c.setName("四班");
        mapper.insert(c);
    }
    @Test
    void select(){
        System.out.println(mapper.select());
        System.out.println(mapper.selectById(1));
        System.out.println(mapper.deleteById(1));
        Integer[]ids=new Integer[]{1,2};
        System.out.println(mapper.deleteByIds(ids));
        System.out.println(mapper.count());
    }
    @Test
    void update(){
        Class c = new Class();
        c.setId(3);
        c.setTeacherName("王大锤");
        c.setGradeLevel("四年级");
        c.setName("四班");
        mapper.update(c);
    }
}
