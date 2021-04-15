package com.OrderSystem.controller;


import com.OrderSystem.Service.ProductService;
import com.OrderSystem.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService ;

    public ProductController(ProductService productService){
        this.productService = productService ;
    }
    @GetMapping
    public String getProductPage(Model model){
        model.addAttribute("allProducts", productService.getProducts());
        return "product" ;
    }
    @PostMapping
    public String addProduct(@ModelAttribute Product product, Model model) {
        productService.addProduct(product);
        model.addAttribute("allProducts",productService.getProducts());
        return "redirect:product";
    }
    @GetMapping("/edit/{product_id}")
    public String getEditProductPage(@PathVariable int product_id, Model model) {
        Product product = productService.getProduct(product_id);
        model.addAttribute("product", product);
        return "product-edit";
    }
    @PostMapping("/edit/{product_id}")
    public String editproduct(@PathVariable int product_id,
                              @ModelAttribute Product product,
                              Model model) {

        productService.editProduct(product);
        model.addAttribute("products",productService.getProducts());
        return "redirect:/product";
    }
    @PostMapping("/delete/{product_id}")
    public String deleteAccount(@PathVariable int product_id,
                                Model model) {
        productService.deleteBankAccount(product_id);
        model.addAttribute("allProducts",productService.getProducts());
        return "redirect:/product";
    }



//    @PostMapping
//    public String registerProduct(@ModelAttribute Product product, Model model) {
//        productService.createBankAccount(product);
//        model.addAttribute("allProduct", productService.getAllProducts());
//        return "redirect:product";
//    }
}
