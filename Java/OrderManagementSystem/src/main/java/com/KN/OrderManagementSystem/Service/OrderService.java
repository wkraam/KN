package com.KN.OrderManagementSystem.Service;

import com.KN.OrderManagementSystem.Exceptions.OrderLineNotFoundException;
import com.KN.OrderManagementSystem.Model.Customer;
import com.KN.OrderManagementSystem.Model.OrderLine;
import com.KN.OrderManagementSystem.Model.Orders;
import com.KN.OrderManagementSystem.Model.Product;
import com.KN.OrderManagementSystem.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders addOrderLine(OrderLine newOrderLine, Customer customer){
        return orderRepository.save(newOrderLine, customer, LocalDate.now());
    }

    public Orders updateOrdersLines(Orders newOrders) {
        return orderRepository.save(newOrders);
    }

    public Orders findOrderLineByIds(Long id) throws Throwable {
        return orderRepository.findOrderLineById(id).orElseThrow(() -> new OrderLineNotFoundException("OrderLine: "+id+" is not int the database"));
    }

    public List<Orders> findAllOrderLines(){
        return orderRepository.findAll();
    }

    public Optional<Orders> findAllOrdersByDate(LocalDate date){
        return orderRepository.findOrdersByBuyTime(date);
    }

    public Optional<Orders> findAllOrdersByProduct(Product product){
        return orderRepository.findOrderLineByProduce(product);
    }

    public Optional<Orders> findAllOrdersByCustomer(Customer customer){
        return orderRepository.findOrderLinesByCustomer(customer);
    }

    public void deleteOrderLine(Orders delOrderLine){
        orderRepository.delete(delOrderLine);
    }

}
