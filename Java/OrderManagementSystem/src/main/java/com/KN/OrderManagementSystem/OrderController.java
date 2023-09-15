package com.KN.OrderManagementSystem;

import com.KN.OrderManagementSystem.Model.Customer;
import com.KN.OrderManagementSystem.Model.Product;
import com.KN.OrderManagementSystem.Service.CustomerService;
import com.KN.OrderManagementSystem.Service.OrderService;
import com.KN.OrderManagementSystem.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class OrderController {

    public final CustomerService cs;
    public final ProductService ps;
    public final OrderService os;

    public OrderController(CustomerService cs, ProductService ps, OrderService os) {
        this.cs = cs;
        this.ps = ps;
        this.os = os;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer){
        System.out.println(newCustomer.toString());
        Customer customer = cs.addCustomer(newCustomer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct){
        System.out.println(newProduct.toString());
        Product product = ps.addProduct(newProduct);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    public void order(){

    }

    public void searchOrderByDate(LocalDate date){

    }

    public void searchOrderByProduct(){

    }

    public void searchOrderByCustomer(){

    }
}
