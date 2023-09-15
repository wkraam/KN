package com.KN.OrderManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    private @Id @GeneratedValue long id;
    private int name;
    private long skuCode;
    private float unitPrice;

    public Product(int name, long skuCode, float unitPrice) {
        this.name = name;
        this.skuCode = skuCode;
        this.unitPrice = unitPrice;
    }

    public Product() {}

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(long skuCode) {
        this.skuCode = skuCode;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", skuCode=" + skuCode +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
