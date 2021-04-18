package com.OrderSystem.Service;

import com.OrderSystem.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Product> getCustomerProduct(int customerId) {
        String url = "http://localhost:8091/api/product/user/" +
                customerId;
        ResponseEntity<Product[]> response =
                restTemplate.getForEntity(url, Product[].class);
        Product[] products = response.getBody();

        return Arrays.asList(products);
    }
    public void addProduct(Product product) {
        String url = "http://localhost:8091/api/product";

        restTemplate.postForObject(url, product, Product.class);
    }
    public List<Product> getProducts() {
        String url = "http://localhost:8091/api/product/";

        ResponseEntity<Product[]> response =
                restTemplate.getForEntity(url, Product[].class);

        Product[] products = response.getBody();
        return Arrays.asList(products);
    }

    public Product getProduct(int id) {
        String url = "http://localhost:8091/api/product/" + id;

        ResponseEntity<Product> response =
                restTemplate.getForEntity(url, Product.class);

        return response.getBody();
    }
    public void editProduct(Product product) {
        String url = "http://localhost:8091/api/product/" +
                product.getProduct_id();
        restTemplate.put(url, product);
    }
    public void deleteProduct(int product_id) {
        String url = "http://localhost:8091/api/product/" + product_id;
        restTemplate.delete(url);
    }






//    @PostConstruct
//    public void postConstruct() {
//        this.products = new ArrayList<>();
//    }
//
//    public void createBankAccount(Product product) {
//        products.add(product);
//    }
//
//    public List<Product> getAllProducts() {
//        return new ArrayList<>(this.products);
//    }
}



