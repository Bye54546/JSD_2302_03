package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public void hello(HttpServletResponse response) throws Exception {
//        1. 设置响应头，告诉浏览器，响应体的数据类型是html
//        2. 设置响应体的编码格式
//        3. 获取输出流
//        4. 输出响应体
//        5. 关闭输出流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1 style='background-color: red';>你好，SpringBoot</h1>");
        pw.close();
    }
}
