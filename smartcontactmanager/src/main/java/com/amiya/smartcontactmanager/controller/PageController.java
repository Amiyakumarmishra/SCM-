package com.amiya.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amiya.smartcontactmanager.entity.Users;
import com.amiya.smartcontactmanager.form.UserForm;
import com.amiya.smartcontactmanager.service.UserService;
import com.amiya.smartcontactmanager.utils.Message;
import com.amiya.smartcontactmanager.utils.MessageType;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    public String index(Model model) {
        System.out.println("This is home page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "home";
    }

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
        return "login";
    }

    @RequestMapping("/signup")
    public String login(Model model) {
        System.out.println("This is signup page handler");
        UserForm userForm = new UserForm();
        // userForm.setName("Amiya Mishra");
        // userForm.setAbout("Write Something About your self");

        model.addAttribute("userForm", userForm);
        return "signup";
    }

    @RequestMapping("/services")
    public String signup(Model model) {
        System.out.println("This is services page handler");
        model.addAttribute("userName", "Amiya Mishra");
        return "services";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegisterForm(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        System.out.println("Processing Registration Form");

        System.out.println(userForm.toString());

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "signup";
        }

        Users user = new Users();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

        Users savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        return "redirect:/signup";
    }

}
