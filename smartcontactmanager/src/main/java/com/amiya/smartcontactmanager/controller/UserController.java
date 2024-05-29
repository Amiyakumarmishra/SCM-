package com.amiya.smartcontactmanager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amiya.smartcontactmanager.utils.Helper;

@Controller
@RequestMapping("/user")
public class UserController {

    // user dashbaord page

    @RequestMapping(value = "/dashboard")
    public String userDashboard(Authentication authentication) {
        System.out.println("User dashboard");
        String email = Helper.getEmailOfLoggedInUser(authentication);
        System.out.println(email);
        return "user/dashboard";
    }

    // user profile page

    @RequestMapping(value = "/profile")
    public String userProfile() {
        System.out.println("User profile");
        return "user/profile";
    }

    // user add contacts page

    // user view contacts

    // user edit contact

    // user delete contact

}
