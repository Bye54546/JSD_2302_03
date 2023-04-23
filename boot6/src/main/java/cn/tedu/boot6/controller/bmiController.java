package cn.tedu.boot6.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bmiController {
    @RequestMapping("/bmi")
    public Integer bmi(double h,double w){
        double bmi = w / (h * h);
        if (bmi < 18.5) {
            return  1;
        } else if (bmi < 25) {
            return  2;
        } else if (bmi < 28) {
            return  3;
        } else if (bmi < 32) {
            return  4;
        } else {
            return  5;
        }
    }
}
