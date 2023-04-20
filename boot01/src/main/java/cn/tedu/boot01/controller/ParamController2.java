package cn.tedu.boot01.controller;

import cn.tedu.boot01.entity.Emp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//添加此注解后就不用再添加@ResponseBody注解了
@RestController
//@Controlle
public class ParamController2 {
    @RequestMapping("/p2")
//    @ResponseBody
    public String p2(String username, String password) {
        return "name=" + username + ", age=" + password;
    }
    @RequestMapping("/p3")
//    @ResponseBody
    public String p3(Emp emp) {
        System.out.println("emp = " + emp);
        return emp.toString();
    }
    @RequestMapping("/bmi")
    public String bmi(double height, double weight){
        double bmi = weight / Math.pow(height, 2);
        String result = "";
        if (bmi < 18.5) {
            result = "过轻";
        } else if (bmi < 25) {
            result = "正常";
        } else if (bmi < 28) {
            result = "过重";
        } else if (bmi < 32) {
            result = "肥胖";
        } else {
            result = "非常肥胖";
        }
        return "bmi=" + bmi + ", " + result;
    }
}
