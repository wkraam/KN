package com.KN.OrderManagementSystem.Model;

import jakarta.persistence.*;

@Entity
public class OrderLine {
    private @Id @GeneratedValue long id;
    @ManyToOne
    @JoinColumn(name = "produce_id")
    private Product produce;
    private float quantity;

    public OrderLine(Product produce, float quantity) {
        this.produce = produce;
        this.quantity = quantity;
    }

    public OrderLine() {}

    public Product getProduce() {
        return produce;
    }

    public void setProduce(Product produce) {
        this.produce = produce;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", produce=" + produce +
                ", quantity=" + quantity +
                '}';
    }
}
