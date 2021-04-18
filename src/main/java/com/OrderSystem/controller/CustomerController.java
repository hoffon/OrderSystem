package com.OrderSystem.controller;

import com.OrderSystem.Service.CustomerService;
import com.OrderSystem.Service.ProductService;
import com.OrderSystem.model.Customer;
import com.OrderSystem.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService ;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService ;
    }
    @GetMapping
    public String getCustomerPage(Model model){
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "customer" ;
    }
    @PostMapping
    public String addCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.addCustomer(customer);
        model.addAttribute("allCustomers",customerService.getCustomers());
        return "redirect:customer";
    }
    @GetMapping("/edit/{customerID}")
    public String getEditCustomerPage(@PathVariable int customerID, Model model) {
        Customer customer = customerService.getCustomer(customerID);
        model.addAttribute("customer", customer);
        return "customer-edit";
    }
    @PostMapping("/edit/{customerID}")
    public String editcustomer(@PathVariable int customerID,
                              @ModelAttribute Customer customer,
                              Model model) {

        customerService.editCustomer(customer);
        model.addAttribute("customers",customerService.getCustomers());
        return "redirect:/customer";
    }
    @PostMapping("/delete/{customerID}")
    public String deleteCustomer(@PathVariable int customerID,
                                Model model) {
        customerService.deleteCustomer(customerID);
        model.addAttribute("allCustomers",customerService.getCustomers());
        return "redirect:/customer";
    }
}
