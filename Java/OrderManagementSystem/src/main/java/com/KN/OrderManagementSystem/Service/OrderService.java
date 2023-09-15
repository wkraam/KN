package com.KN.OrderManagementSystem.Service;

import com.KN.OrderManagementSystem.Exceptions.OrderLineNotFoundException;
import com.KN.OrderManagementSystem.Model.OrderLine;
import com.KN.OrderManagementSystem.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderLine addOrderLine(OrderLine newOrderLine){
        return orderRepository.save(newOrderLine);
    }

    public OrderLine updateOrderLine(OrderLine newOrderLine) {
        return orderRepository.save(newOrderLine);
    }

    public OrderLine findOrderLineByIs(Long id) throws Throwable {
        return orderRepository.findOrderLineById(id).orElseThrow(() -> new OrderLineNotFoundException("OrderLine: "+id+" is not int the database"));
    }

    public List<OrderLine> findAllOrderLines(){
        return orderRepository.findAll();
    }

    public void deleteOrderLine(OrderLine delOrderLine){
        orderRepository.delete(delOrderLine);
    }

}
