package com.KN.OrderManagementSystem;


import com.KN.OrderManagementSystem.Model.*;
import com.KN.OrderManagementSystem.Service.CustomerService;
import com.KN.OrderManagementSystem.Service.OrderService;
import com.KN.OrderManagementSystem.Service.ProductService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomersList(){
        List<Customer> customers = cs.findAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProductsList(){
        List<Product> products = ps.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<Orders>> getOrdersList(){
        List<Orders> orders = os.findAllOrderLines();
        return new ResponseEntity<>(orders, HttpStatus.OK);
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

    @PostMapping("/order")
    public ResponseEntity<Orders> order(@RequestBody OrderBody orderBody) throws Throwable {

        Product product = ps.findProductByIds(orderBody.getProductid());
        Customer customer = cs.findCustomerByIds(orderBody.getCustomerid());
        OrderLine newOrder = new OrderLine(product, orderBody.getQuantity());

        Orders order = os.addOrderLine(newOrder, customer);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @PostMapping("/getOrdersByDate")
    public ResponseEntity<List<Orders>> searchOrderByDate(@RequestBody String date){
        //deJSON
        Scanner sc = new Scanner(date);
        Map<String, String> map = new HashMap<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            switch (line) {
                case "{", "}" -> {}
                default -> {
                    String key = line.split(": ")[0].strip();
                    String value = line.split(": ")[1].strip();
                    key = key.substring(1, key.length()-1);
                    value = value.substring(1, value.length()-1);
                    map.put(key, value);
                }
            }
        }

        String ds = map.get("date");
        int year = Integer.parseInt(ds.split("-")[0]);
        int month= Integer.parseInt(ds.split("-")[1]);
        int day= Integer.parseInt(ds.split("-")[2]);
        LocalDate searchTime = LocalDate.of(year, month, day);

        List<Orders> ordersByDate = os.findAllOrdersByDate(searchTime);
        return new ResponseEntity<>(ordersByDate, HttpStatus.OK);
    }

    @PostMapping("/getOrdersByProduct")
    public ResponseEntity<List<Orders>> searchOrderByProduct(@RequestBody Product product){
        List<Orders> ordersByProduct = os.findAllOrdersByProduct(product);
        return new ResponseEntity<>(ordersByProduct, HttpStatus.OK);
    }

    @PostMapping("/getOrdersByCustomer")
    public ResponseEntity<List<Orders>> searchOrderByCustomer(@RequestBody Customer customer){
        List<Orders> ordersByCustomer = os.findAllOrdersByCustomer(customer);
        return new ResponseEntity<>(ordersByCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Long customerId) throws Throwable {
        Customer customer = cs.findCustomerByIds(customerId);
        cs.deleteCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Long productId) throws Throwable {
        Product product = ps.findProductByIds(productId);
        ps.deleteProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
