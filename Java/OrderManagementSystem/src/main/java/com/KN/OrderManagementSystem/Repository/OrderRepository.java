package com.KN.OrderManagementSystem.Repository;

import com.KN.OrderManagementSystem.Model.Customer;
import com.KN.OrderManagementSystem.Model.OrderLine;
import com.KN.OrderManagementSystem.Model.Orders;
import com.KN.OrderManagementSystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findOrderLineById(Long id);

    Orders save(OrderLine newOrderLine, Customer customer, LocalDate date);

    Optional<Orders> findOrderLineByProduce(Product product);

    Optional<Orders> findOrderLinesByCustomer(Customer customer);

    Optional<Orders> findOrdersByBuyTime(LocalDate buyTime);
}
