package cn.tedu.boot10.controller;

import cn.tedu.boot10.mapper.ClassMapper;
import cn.tedu.boot10.entity.Class;
import cn.tedu.boot10.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassMapper mapper;
    @RequestMapping("/select")
    public List<Class>select(){
        return mapper.select();
    }
    @RequestMapping("/insert")
    public int insert(@RequestBody Class c){
        return mapper.insert(c);
    }
    @Autowired
    StudentMapper sMapper;
    @RequestMapping("/deleteById")
    public void deleteById(int id) {
        mapper.deleteById(id);
        sMapper.deleteByCId(id);
    }
    @RequestMapping("selectById")
    public Class selectById(int id){
        return mapper.selectById(id);
    }
}
