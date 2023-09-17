package com.KN.OrderManagementSystem.Model;

public class OrderBody {
    private long productid;
    private float quantity;
    private long customerid;

    @Override
    public String toString() {
        return "OrderBody{" +
                "productid=" + productid +
                ", quantity=" + quantity +
                ", customerid=" + customerid +
                '}';
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public OrderBody(long productid, float quantity, long customerid) {
        this.productid = productid;
        this.quantity = quantity;
        this.customerid = customerid;
    }
}
