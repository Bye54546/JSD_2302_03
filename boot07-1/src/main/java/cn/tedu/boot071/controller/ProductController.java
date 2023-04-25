package cn.tedu.boot071.controller;

import cn.tedu.boot071.entity.Product;
import cn.tedu.boot071.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;

    @RequestMapping("/insert")
    public void insert(@RequestBody Product product){
        mapper.insert(product);
    }
    @RequestMapping("/select")
    public List<Product> select(){
        //SpringMVC框架当发现响应给客户端的数据为自定义对象或集合或数组时
        //会自动将其转成JSON格式的字符串,然后再响应给客户端
        return mapper.select();
    }

}
