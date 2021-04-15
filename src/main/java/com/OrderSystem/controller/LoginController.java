package com.OrderSystem.controller;

import com.OrderSystem.Service.CustomerService;
import com.OrderSystem.Service.ProductService;
import com.OrderSystem.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {

    private CustomerService customerService;
    private ProductService productService;

    public LoginController(CustomerService customerService,ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";   // return login.html
    }



    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model) {
        Customer storedCustomer = customerService.checkPin(customer);

        if (storedCustomer != null) {
            model.addAttribute("producttitle",
                    storedCustomer.getName() + " Products");
            model.addAttribute("products",
                    productService.getCustomerProduct(customer.getId()));
            return "customerproduct";
        } else {
            model.addAttribute("greeting", "Can't find customer");
            return "home";
        }
    }

//    @PostMapping
//    public String login(@ModelAttribute Customer customer, Model model) {
//        // 1. เอา id กับ pin ไปเช็คกับข้อมูล customer ที่มีอยู่ ว่าตรงกันบ้างไหม
//        Customer matchingCustomer = customerService.checkPin(customer);
//
//        // 2. ถ้าตรง ส่งข้อมูล customer กลับไปแสดงผล
//        if (matchingCustomer != null) {
//            model.addAttribute("greeting",
//                    "Welcome, " + matchingCustomer.getName());
//        } else {
//            // 3. ถ้าไม่ตรง แจ้งว่าไม่มีข้อมูล customer นี้
//            model.addAttribute("greeting", "Can't find customer");
//        }
//        return "home";
//    }

}


