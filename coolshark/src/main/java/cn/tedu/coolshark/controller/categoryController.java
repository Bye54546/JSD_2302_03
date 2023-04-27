package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.CategoryMapper;
import cn.tedu.coolshark.pojo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category/")
public class categoryController {
    @Autowired
    CategoryMapper mapper;
    @RequestMapping("select")
    public List<Category> select() {
        return mapper.select();
    }
}
