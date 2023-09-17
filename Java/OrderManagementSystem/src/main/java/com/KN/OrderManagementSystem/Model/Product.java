package com.KN.OrderManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name="product_generator", sequenceName = "product_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "skuCode")
    private long skuCode;
    @Column(name = "unitPrice")
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
                "id=" + id +
                ", productName=" + productName +
                ", skuCode=" + skuCode +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
