package com.OrderSystem.Service;

import com.OrderSystem.model.Customer;
import com.OrderSystem.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Customer> getCustomerCus(int customerId) {
        String url = "http://localhost:8092/api/customer/customer/" +
                customerId;
        ResponseEntity<Customer[]> response =
                restTemplate.getForEntity(url, Customer[].class);
        Customer[] customers = response.getBody();

        return Arrays.asList(customers);
    }

    public void addCustomer(Customer customer) {
        String url = "http://localhost:8092/api/customer";

        restTemplate.postForObject(url, customer, Customer.class);
    }

    public List<Customer> getCustomers() {
        String url = "http://localhost:8092/api/customer/";

        ResponseEntity<Customer[]> response =
                restTemplate.getForEntity(url, Customer[].class);

        Customer[] customers = response.getBody();
        return Arrays.asList(customers);
    }

    public Customer getCustomer(int id) {
        String url = "http://localhost:8092/api/customer/" + id;

        ResponseEntity<Customer> response =
                restTemplate.getForEntity(url, Customer.class);

        return response.getBody();
    }

    public void editCustomer(Customer customer) {
        String url = "http://localhost:8092/api/customer/" +
                customer.getCustomerID();
        restTemplate.put(url, customer);
    }

    public void deleteCustomer(int customerID) {
        String url = "http://localhost:8092/api/customer/" + customerID;
        restTemplate.delete(url);
    }
}
