package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Solomon on 6/16/2014.
 */
@Controller
@RequestMapping(value = "/")
public class DemoIndexPageController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("title", "Spring MVC Template");
        model.addAttribute("message", "Let's build an awesome project");
        return "index";
    }
}
