package com.OrderSystem.controller;

import com.OrderSystem.Service.UserService;
import com.OrderSystem.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class CustomerRestController {

    private UserService userService;

    public CustomerRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getCustomers();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable int id) {
        return userService.findCustomer(id);
    }

}
