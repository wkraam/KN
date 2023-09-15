package com.KN.OrderManagementSystem.Model;

import com.KN.OrderManagementSystem.Model.Product;

public class OrderLine {
    private Product produce;
    private float quantity;

    public OrderLine(Product produce, float quantity) {
        this.produce = produce;
        this.quantity = quantity;
    }

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
                "produce=" + produce +
                ", quantity=" + quantity +
                '}';
    }
}
