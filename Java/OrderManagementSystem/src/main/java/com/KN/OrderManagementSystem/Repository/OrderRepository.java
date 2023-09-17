package com.KN.OrderManagementSystem.Repository;

import com.KN.OrderManagementSystem.Model.Customer;
import com.KN.OrderManagementSystem.Model.Orders;
import com.KN.OrderManagementSystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findOrderLineById(Long id);
}
