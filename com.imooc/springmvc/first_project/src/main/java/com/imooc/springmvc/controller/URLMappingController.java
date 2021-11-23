package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.BMI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class URLMappingController {
    @GetMapping("/bmi")
    public ModelAndView inputBMI(){
        ModelAndView modelAndView = new ModelAndView("/bmi/bmi.jsp");
        return modelAndView;
    }
    @PostMapping("/bmiResult")
    @ResponseBody
    public String calculateBMI(int height, int weight){
        double bmi = weight / (height * 0.01 * height * 0.01);
        String result;
        if (bmi < 19) {
            result = "too thin";
        } else if (bmi > 25) {
            result = "too fat";
        } else {
            result = "norml";
        }
        return "result:" + result;
    }
    @PostMapping("/bmiResultInMav")
    public ModelAndView calculateBMIInView(int height, int weight){
        ModelAndView modelAndView = new ModelAndView("/bmi/bmiresult.jsp");
        BMI bmi = new BMI(height, weight,"");
        double result = weight / (height * 0.01 * height * 0.01);
        if (result < 19) {
            bmi.setResult("too thin");
        } else if (result > 25) {
            bmi.setResult("too fat");
        } else {
            bmi.setResult("normal");
        }
        modelAndView.addObject("b", bmi);
        return modelAndView;
    }
}
