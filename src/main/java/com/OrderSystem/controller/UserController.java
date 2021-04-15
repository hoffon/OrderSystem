package com.OrderSystem.controller;

import com.OrderSystem.Service.UserService;
import com.OrderSystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("allUsers", userService.getCustomers());
        return "user";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute User user, Model model) {
        userService.createCustomer(user);
        model.addAttribute("allUsers", userService.getCustomers());
        return "redirect:user";
    }
}
