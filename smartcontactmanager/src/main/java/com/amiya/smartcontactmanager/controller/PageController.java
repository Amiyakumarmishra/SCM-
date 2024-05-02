package com.amiya.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("This is home page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        System.out.println("This is home page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "about";
    }

    @RequestMapping("/services")
    public String services(Model model) {
        System.out.println("This is home page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "services";
    }

}
