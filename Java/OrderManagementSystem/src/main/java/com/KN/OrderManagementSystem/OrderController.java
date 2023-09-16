package com.KN.OrderManagementSystem;

import com.KN.OrderManagementSystem.Model.Customer;
import com.KN.OrderManagementSystem.Model.OrderLine;
import com.KN.OrderManagementSystem.Model.Orders;
import com.KN.OrderManagementSystem.Model.Product;
import com.KN.OrderManagementSystem.Service.CustomerService;
import com.KN.OrderManagementSystem.Service.OrderService;
import com.KN.OrderManagementSystem.Service.ProductService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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


    //An Order is made of N OrderLine and is related to a Customer, and has a date of submission
    //Each OrderLine is made of a Product and a quantity
    @PostMapping("/order")
    public ResponseEntity<Orders> order(Product product, float buyQuantity, Customer customer){
        OrderLine newOrder = new OrderLine(product, buyQuantity);
        os.addOrderLine(newOrder, customer);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/getOrdersByDate")
    public ResponseEntity<List<Orders>> searchOrderByDate(LocalDate date){
        List<Orders> ordersByDate = os.findAllOrderLines();
        return new ResponseEntity<>(ordersByDate, HttpStatus.OK);
    }

    @GetMapping("/getOrdersByProduct")
    public ResponseEntity<List<Orders>> searchOrderByProduct(Product product){
        List<Orders> ordersByProduct = os.findAllOrderLines();
        return new ResponseEntity<>(ordersByProduct, HttpStatus.OK);
    }

    @GetMapping("/getOrdersByCustomer")
    public ResponseEntity<List<Orders>> searchOrderByCustomer(Customer customer){
        List<Orders> ordersByCustomer = os.findAllOrderLines();
        return new ResponseEntity<>(ordersByCustomer, HttpStatus.OK);
    }
}
