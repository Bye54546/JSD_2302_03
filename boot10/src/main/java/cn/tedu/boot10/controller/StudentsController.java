package cn.tedu.boot10.controller;

import cn.tedu.boot10.entity.Class;
import cn.tedu.boot10.entity.Student;
import cn.tedu.boot10.mapper.ClassMapper;
import cn.tedu.boot10.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
        @Autowired
        StudentMapper mapper;
        @RequestMapping("/selectByCid")
        public List<Student> selectByCid(int id){
            return mapper.selectByCid(id);
        }
        @RequestMapping("/insert")
        public int insert(@RequestBody Student s){
           return mapper.insert(s);
        }

        @RequestMapping("/deleteById")
        public void deleteById(int id) {
            mapper.deleteById(id);
        }
}
