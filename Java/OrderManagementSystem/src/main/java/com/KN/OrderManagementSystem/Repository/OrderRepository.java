package com.KN.OrderManagementSystem.Repository;

import com.KN.OrderManagementSystem.Model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderLine, Long> {
    Optional<OrderLine> findOrderLineById(Long id);
}
