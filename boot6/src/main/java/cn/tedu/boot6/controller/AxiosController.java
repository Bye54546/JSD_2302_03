package cn.tedu.boot6.controller;

import cn.tedu.boot6.entity.Products;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
    @RequestMapping("/p1")
    public String p1(String name,int age){
        return name+":"+age;
    }
//    当客户端是post请求并且提交的是JS对象时，使用@RequestBody注解，否则收到的时Null
    @RequestMapping("/p2")
    public String p2(@RequestBody Products product){
        return product.toString();
    }
}
