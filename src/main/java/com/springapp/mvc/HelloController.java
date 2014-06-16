package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value =  "/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is welcome page!");
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {

        model.addAttribute("title", "Spring Security Hello World");
        model.addAttribute("message", "This is protected page!");

        return "admin";
    }


}