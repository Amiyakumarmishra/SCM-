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
        System.out.println("This is about page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "about";
    }

    @RequestMapping("/contact")
    public String services(Model model) {
        System.out.println("This is contact page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "contact";
    }

    @RequestMapping("/login")
    public String contact(Model model) {
        System.out.println("This is login page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "login";
    }

    @RequestMapping("/signup")
    public String login(Model model) {
        System.out.println("This is signup page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "signup";
    }

    @RequestMapping("/services")
    public String signuo(Model model) {
        System.out.println("This is services page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "services";
    }

}
