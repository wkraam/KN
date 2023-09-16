package com.KN.OrderManagementSystem.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_line_id")
    private OrderLine orderLine;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private LocalDate buyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders(OrderLine orderLine, Customer customer, LocalDate buyTime) {
        this.orderLine = orderLine;
        this.customer = customer;
        this.buyTime = buyTime;
    }

    public Orders() {

    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(LocalDate buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderLine=" + orderLine +
                ", customer=" + customer +
                ", buyTime=" + buyTime +
                '}';
    }
}
