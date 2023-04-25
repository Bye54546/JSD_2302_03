package cn.tedu.boot7.controller;

import cn.tedu.boot7.entity.Products;
import cn.tedu.boot7.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    ProductsMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody Products products){
        mapper.insert(products);
    }
    @RequestMapping("/delete")
    public void delete(@RequestBody Products products){
        mapper.delete(products);
    }
    @RequestMapping("/select")
    public List<Products> select(){
        return mapper.select();
    }
    @RequestMapping("/selectById")
    public Products selectById(int id){
        return mapper.selectById(id);
    }
    @RequestMapping("/update")
    public void update(@RequestBody Products products){
        mapper.update(products);
    }
}
