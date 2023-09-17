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
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders addOrderLine(OrderLine newOrderLine, Customer customer){
        return orderRepository.save( new Orders(newOrderLine, customer, LocalDate.now()));
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

    public List<Orders> findAllOrdersByDate(LocalDate date){
        List<Orders> unsortedOrders = orderRepository.findAll();
        List<Orders> sortedOrders = new ArrayList<>();
        for(Orders order:unsortedOrders){
            System.out.println("order date: "+order.getBuyTime()+", sorting date: "+date);
            if (order.getBuyTime().isEqual(date)) sortedOrders.add(order);
        }
        return sortedOrders;
    }

    public List<Orders> findAllOrdersByProduct(Product product){
        List<Orders> unsortedOrders = orderRepository.findAll();
        List<Orders> sortedOrders = new ArrayList<>();
        long productSkuCode = product.getSkuCode();
        for(Orders order:unsortedOrders){
            if (order.getOrderLine().getProduce().getSkuCode() == productSkuCode) sortedOrders.add(order);
        }
        return sortedOrders;
    }

    public void deleteOrderLine(Orders delOrderLine){
        orderRepository.delete(delOrderLine);
    }

    public List<Orders> findAllOrdersByCustomer(Customer customer) {
        List<Orders> unsortedOrders = orderRepository.findAll();
        List<Orders> sortedOrders = new ArrayList<>();
        long customerRegistrationCode = customer.getRegistrationCode();
        for(Orders order:unsortedOrders){
            if (order.getCustomer().getRegistrationCode() == customerRegistrationCode) sortedOrders.add(order);
        }
        return sortedOrders;
    }
}
