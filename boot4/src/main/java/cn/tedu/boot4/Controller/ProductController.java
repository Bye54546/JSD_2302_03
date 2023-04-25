package cn.tedu.boot4.Controller;


import cn.tedu.boot4.entity.Products;
import cn.tedu.boot4.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;
    @RequestMapping("/insert")
    public String insert(Products product){
        mapper.insert(product);
        return "success!<a href='/'>return</a>";
    }
    @RequestMapping("/select")
    public String select(){
        List<Products> list = mapper.select();

        String html = "<table border=1>";
        html+="<caption>shoppingList</caption>";
        html+="<tr><th>id</th><th>Title</th><th>Price</th><th>Num</th><th>Content</th></tr>";
        for (Products p:list) {
            html+="<tr>";
            html+="<td>"+p.getId()+"</td>";
            html+="<td>"+p.getTitle()+"</td>";
            html+="<td>"+p.getPrice()+"</td>";
            html+="<td>"+p.getNum()+"</td>";
//            超链接触发业务
            html+="<td><a href='/delete?id="+p.getId()+"'>Delete</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }
    @RequestMapping("/delete")
    public String delete(int id){
        mapper.deleteById(id);
        return "success!<a href='/'>back</a>";
    }
    @RequestMapping("/update")
    public String update(Products product){
        mapper.update(product);
        return "success!<a href='/'>back</a>";
    }
}
