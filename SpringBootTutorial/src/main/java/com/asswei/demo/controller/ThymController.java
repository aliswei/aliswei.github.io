package com.asswei.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Asswei
 */
@Controller
public class ThymController {
    @RequestMapping("/test")
    public String test1(Model model){
        //存入数据
        model.addAttribute("msg","<h1>Hello,Thymeleaf</h1>");
        model.addAttribute("users", Arrays.asList("asswei","flower"));
        //classpath:/templates/test.html
        return "test";
    }
}
