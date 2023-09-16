package com.KN.OrderManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    private @Id @GeneratedValue long id;
    private String productName;
    private long skuCode;
    private float unitPrice;

    public Product(String productName, long skuCode, float unitPrice) {
        this.productName = productName;
        this.skuCode = skuCode;
        this.unitPrice = unitPrice;
    }

    public Product() {}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
                "name=" + productName +
                ", skuCode=" + skuCode +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
